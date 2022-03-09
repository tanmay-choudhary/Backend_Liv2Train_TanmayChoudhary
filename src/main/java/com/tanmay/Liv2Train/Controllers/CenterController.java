package com.tanmay.Liv2Train.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tanmay.Liv2Train.dto.CenterDto;
import com.tanmay.Liv2Train.exception.SpringException;
import com.tanmay.Liv2Train.response.CenterResponse;
import com.tanmay.Liv2Train.services.CenterServices;

@Controller
public class CenterController {
	@Autowired
	private CenterServices centerServices;
	
	@RequestMapping(value = "/saveCenter", method = RequestMethod.POST)
	@ExceptionHandler({SpringException.class})
    public ModelAndView saveCenter(@RequestBody CenterDto centerDto) {
	   CenterResponse resp = centerServices.saveCenter(centerDto);
//	   ModelAndView mav = new ModelAndView("center");
       ModelAndView mav = new ModelAndView();
       if(resp.getSuccess()) {
    	   mav.addObject("center",resp.getCenter());
    	   mav.addObject("success",resp.getSuccess());
//    	   mav.setViewName("center");
    	   return mav;
       }
       throw new SpringException(resp.getResponsemsg());
    }
	@RequestMapping(value = "/getCenter", method = RequestMethod.GET)
    public ModelAndView getCenter() {
	   CenterResponse resp = centerServices.getCenter();
	   ModelAndView mav = new ModelAndView();
       if(resp.getSuccess()) {
    	   mav.addObject("centers",resp.getCenter());
    	   mav.addObject("success",resp.getSuccess());
    	   return mav;
       }
       throw new SpringException(resp.getResponsemsg());
    }
}
