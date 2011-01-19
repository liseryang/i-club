package com.iclub.clubfacility.controller;

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

import com.iclub.common.CommonUtils;
import com.iclub.member.vo.ClubFacility;
import com.iclub.service.ClubFacilityService;
import com.iclub.service.ClubService;
import com.iclub.service.FacilityService;

@Controller
public class ClubFacilityController {
	@Autowired
	ClubFacilityService clubFacilityService;
	
	@Autowired
	ClubService clubService;
	
	@Autowired
	FacilityService facilityService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		//dataBinder.setRequiredFields(new String[] {"clubFacilityShortName", "clubFacilityFees", "clubFacilityLongName", "clubFacilityDescription","clubFacilityOtherDetails"});
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}	
	
	@RequestMapping(value="/add-clubFacility.do",method=RequestMethod.GET)
	public ModelAndView showAddClubFacility() throws Exception{
		ModelAndView mv = new ModelAndView("add-clubFacility");
		populateList(mv);
		mv.addObject("clubFacility",new ClubFacilityForm());
		return mv;
	}

	private void populateList(ModelAndView mv) {
		mv.addObject("clubList",clubService.getAllClubs());
		mv.addObject("facilityList",facilityService.getAllFacilities());
	}

	@RequestMapping(value="/add-clubFacility.do",method=RequestMethod.POST)
	public ModelAndView addClubFacility(@ModelAttribute("clubFacility") ClubFacilityForm form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		if(bindingResult.hasErrors()){
			return showAddClubFacility();
		}
		ClubFacility clubFacility = getClubFacilityfromForm(form,false);
		clubFacilityService.createClubFacility(clubFacility);
		return listClubFacility();
	}
	private ClubFacility getClubFacilityfromForm(ClubFacilityForm form,boolean existed){
		ClubFacility clubFacility = new ClubFacility();
		if(existed){
			clubFacility.setId(form.getId());
		}
		clubFacility.setClub(clubService.getClub(form.getClubId()));
		clubFacility.setFacility(facilityService.getFacility(form.getFacilityId()));
		clubFacility.setDateAvailable(CommonUtils.parseDate(form.getDateAvailbleStr()));
		clubFacility.setDateNotAvailable(CommonUtils.parseDate(form.getDateNotAvailableStr()));
		clubFacility.setFacilityCost(form.getFacilityCost());
		return clubFacility;
	}
	private ClubFacilityForm getFormfromClubFacility(ClubFacility clubFacility){
		ClubFacilityForm form = new ClubFacilityForm();
		form.setId(clubFacility.getId());
		form.setDateAvailbleStr(CommonUtils.formatDate(clubFacility.getDateAvailable()));
		form.setDateNotAvailableStr(CommonUtils.formatDate(clubFacility.getDateNotAvailable()));
		form.setFacilityCost(clubFacility.getFacilityCost());
		form.setClubId(clubFacility.getClub().getClubId());
		form.setFacilityId(clubFacility.getFacility().getFacilityId());
		return form;
	}
	
	
	@RequestMapping(value="/list-clubFacility.do",method=RequestMethod.GET)
	public ModelAndView listClubFacility() throws Exception{
		ModelAndView mv = new ModelAndView("list-clubFacility");
		mv.addObject("clubFacilityList",clubFacilityService.getAllClubFacilities());
		return mv;
	}	
	
	@RequestMapping(value="/edit-clubFacility.do",method=RequestMethod.GET)
	public ModelAndView showeditClubFacility(@RequestParam("id") long id){
		ModelAndView mv = new ModelAndView("edit-clubFacility");
		populateList(mv);
		ClubFacilityForm form = getFormfromClubFacility(clubFacilityService.getClubFacility(id));
		mv.addObject("clubFacility",form);
		return mv;
	}	
	
	@RequestMapping(value="/edit-clubFacility.do",method=RequestMethod.POST)
	public ModelAndView editClubFacility(@ModelAttribute("clubFacility")ClubFacilityForm form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		if(bindingResult.hasErrors()){
			return showeditClubFacility(form.getId());
		}
		ClubFacility clubFacility = getClubFacilityfromForm(form,true);
		clubFacilityService.update(clubFacility);
		return listClubFacility();	
	}
	
	@RequestMapping(value="/delete-clubFacility.do",method=RequestMethod.POST)
	public ModelAndView deleteClubFacility(@RequestParam("id") long id) throws Exception{
		clubFacilityService.delete(id);
		return listClubFacility();
	}
	
	@RequestMapping(value="/clubFacility.do",method=RequestMethod.GET)
	public ModelAndView showClubFacilityArea() throws Exception{
		return new ModelAndView("clubFacility");
	}	
}
