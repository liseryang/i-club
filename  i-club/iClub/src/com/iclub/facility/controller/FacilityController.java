package com.iclub.facility.controller;

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

import com.iclub.member.vo.Facility;
import com.iclub.service.FacilityService;

@Controller
public class FacilityController {
	
	@Autowired
	FacilityService facilityService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setRequiredFields(new String[] {"facilityCode", "facilityDescription"});
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}	
	
	@RequestMapping(value="/add-facility.do",method=RequestMethod.GET)
	public ModelAndView showAddFacility() throws Exception{
		ModelAndView mv = new ModelAndView("add-facility");
		mv.addObject("facility",new Facility());
		return mv;
	}

	@RequestMapping(value="/add-facility.do",method=RequestMethod.POST)
	public ModelAndView addFacility(@ModelAttribute("facility") Facility form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		if(bindingResult.hasErrors()){
			return showAddFacility();
		}
		facilityService.createFacility(form);
		return listFacility();
	}
	
	@RequestMapping(value="/list-facility.do",method=RequestMethod.GET)
	public ModelAndView listFacility() throws Exception{
		ModelAndView mv = new ModelAndView("list-facility");
		mv.addObject("facilityList",facilityService.getAllFacilities());
		return mv;
	}	
	
	@RequestMapping(value="/edit-facility.do",method=RequestMethod.GET)
	public ModelAndView showeditFacility(@RequestParam("id") long id){
		ModelAndView mv = new ModelAndView("edit-facility");
		Facility form = facilityService.getFacility(id);
		mv.addObject("facility",form);
		return mv;
	}	
	
	@RequestMapping(value="/edit-facility.do",method=RequestMethod.POST)
	public ModelAndView editFacility(@ModelAttribute("facility")Facility form,BindingResult bindingResult, HttpServletRequest request, ModelMap model) throws Exception{
		if(bindingResult.hasErrors()){
			return showeditFacility(form.getFacilityId());
		}
		facilityService.update(form);
		return listFacility();	
	}		
	
	@RequestMapping(value="/delete-facility.do",method=RequestMethod.POST)
	public ModelAndView deleteFacility(@RequestParam("facilityId") long id) throws Exception{
		facilityService.delete(id);
		return listFacility();
	}
	
	@RequestMapping(value="/facility.do",method=RequestMethod.GET)
	public ModelAndView showFacilityArea() throws Exception{
		return new ModelAndView("facility");
	}
}