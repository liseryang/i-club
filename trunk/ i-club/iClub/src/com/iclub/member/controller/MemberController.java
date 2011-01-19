package com.iclub.member.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iclub.member.vo.Club;
import com.iclub.member.vo.Member;
import com.iclub.member.vo.MemberStatus;
import com.iclub.member.vo.MemberType;
import com.iclub.member.vo.Person;
import com.iclub.service.ClubService;
import com.iclub.service.MemberService;
import com.iclub.service.MemberStatusService;
import com.iclub.service.MemberTypeService;

@Controller
public class MemberController {

	
	@Autowired
	public MemberService memberService;
	
	@Autowired
	public MemberStatusService memberStatusService;
	
	@Autowired
	public MemberTypeService memberTypeService;
	
	@Autowired
	public ClubService clubService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setRequiredFields(new String[] {"person.name", "person.address", "person.phone", "person.email"});
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));

	}
	
	@RequestMapping(value="/add-member.do",method=RequestMethod.GET)
	public ModelAndView showAddMember() throws Exception{
		ModelAndView mv = new ModelAndView("add-member");
		List<MemberStatus> memberStatusList =  memberStatusService.getAllMemberStatus();
		List<MemberType> memberTypeList = memberTypeService.getAllMemberTypes();
		List<Club> clubList = clubService.getAllClubs();
		mv.addObject("clubList",clubList);
		mv.addObject("memberStatusList",memberStatusList);
		mv.addObject("memberTypeList",memberTypeList);
		mv.addObject("person",new ClubMemberForm());
		return mv;
	}

	@RequestMapping(value="/add-member.do",method=RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("person") ClubMemberForm form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		if(bindingResult.hasErrors()){
			return showAddMember();
		}
		Member member = getMemberFromForm(form,false);
		memberService.registerMember(member);
		return listMember();
	}
	
	@RequestMapping(value="/list-member.do",method=RequestMethod.GET)
	public ModelAndView listMember() throws Exception{
		ModelAndView mv = new ModelAndView("list-member");
		mv.addObject("memberList",memberService.getAllMembers());
		return mv;
	}	
	
	@RequestMapping(value="/edit-member.do",method=RequestMethod.GET)
	public ModelAndView showeditMember(@RequestParam("id") long id) throws Exception{
		ModelAndView mv = new ModelAndView("edit-member");
		Member p = memberService.getMember(id);
		List<MemberStatus> memberStatusList =  memberStatusService.getAllMemberStatus();
		List<MemberType> memberTypeList = memberTypeService.getAllMemberTypes();
		List<Club> clubList = clubService.getAllClubs();

		ClubMemberForm form = getFormFromMember(p);
		mv.addObject("clubList",clubList);
		mv.addObject("memberStatusList",memberStatusList);
		mv.addObject("memberTypeList",memberTypeList);
		
		mv.addObject("person",form);
		return mv;
	}	
	
	@RequestMapping(value="/edit-member.do",method=RequestMethod.POST)
	public ModelAndView editMember(@ModelAttribute("person")ClubMemberForm form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		if(bindingResult.hasErrors()){
			System.out.println("Has Errors");
			return showeditMember(form.getMember().getMemberId());
		}
		Member person = getMemberFromForm(form,true);
		memberService.update(person);
		return listMember();
	}		
	
	@RequestMapping(value="/delete-member.do",method=RequestMethod.POST)
	public ModelAndView deleteMember(@RequestParam("memberId") long id) throws Exception{
		memberService.delete(id);
		return listMember();
	}
	
	@RequestMapping(value="/member.do",method=RequestMethod.GET)
	public ModelAndView showMemberArea() throws Exception{
		return new ModelAndView("member");
	}
	
	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) throws Exception{
		request.getSession().invalidate();
		return new ModelAndView("login");
	}	
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public ModelAndView showLogin(@RequestParam(value="error", required=false) boolean error) throws Exception{
		ModelAndView mv = new ModelAndView("login");
		if(error){
			mv.addObject("error","User Name or Password is incorrect");
		}
		return mv;
	}
	
	public Member getMemberFromForm(ClubMemberForm form,boolean existed){

		Member member = new Member();
		member = form.getMember();
		member.setDateJoined(new Date());
		
		member.setMemberStatus(memberStatusService.getMemberStatus(form.getMember().getMemberStatus().getMemberStatusId()));
		member.setMemberType(memberTypeService.getMemberType(form.getMember().getMemberType().getMemberTypeId()));		
		member.setClub(clubService.getClub(form.getMember().getClub().getClubId()));		
		Person person = new Person();
		person = form.getPerson();
		member.setPerson(person);
		return member;
	}
	public ClubMemberForm getFormFromMember(Member m){
		ClubMemberForm form = new ClubMemberForm();
		form.setPerson(m.getPerson());
		form.setMember(m);
		return form;
	}
	
}