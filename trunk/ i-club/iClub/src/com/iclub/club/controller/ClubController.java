package com.iclub.club.controller;

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
import com.iclub.service.ClubService;

@Controller
public class ClubController {
	
	@Autowired
	ClubService clubService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setRequiredFields(new String[] {"clubShortName", "clubFees", "clubLongName", "clubDescription","clubOtherDetails"});
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}	
	
	@RequestMapping(value="/add-club.do",method=RequestMethod.GET)
	public ModelAndView showAddClub() throws Exception{
		ModelAndView mv = new ModelAndView("add-club");
		mv.addObject("club",new Club());
		return mv;
	}

	@RequestMapping(value="/add-club.do",method=RequestMethod.POST)
	public ModelAndView addClub(@ModelAttribute("club") Club form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		if(bindingResult.hasErrors()){
			return showAddClub();
		}
		clubService.createClub(form);
		return listClub();
	}
	
	@RequestMapping(value="/list-club.do",method=RequestMethod.GET)
	public ModelAndView listClub() throws Exception{
		ModelAndView mv = new ModelAndView("list-club");
		mv.addObject("clubList",clubService.getAllClubs());
		return mv;
	}	
	
	@RequestMapping(value="/edit-club.do",method=RequestMethod.GET)
	public ModelAndView showeditClub(@RequestParam("id") long id){
		ModelAndView mv = new ModelAndView("edit-club");
		Club form = clubService.getClub(id);
		mv.addObject("club",form);
		return mv;
	}	
	
	@RequestMapping(value="/edit-club.do",method=RequestMethod.POST)
	public ModelAndView editClub(@ModelAttribute("club")Club form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		if(bindingResult.hasErrors()){
			return showeditClub(form.getClubId());
		}
		clubService.update(form);
		return listClub();	
	}		
	
	@RequestMapping(value="/delete-club.do",method=RequestMethod.POST)
	public ModelAndView deleteClub(@RequestParam("clubId") long id) throws Exception{
		clubService.delete(id);
		return listClub();
	}
	
	@RequestMapping(value="/club.do",method=RequestMethod.GET)
	public ModelAndView showClubArea() throws Exception{
		return new ModelAndView("club");
	}
}
