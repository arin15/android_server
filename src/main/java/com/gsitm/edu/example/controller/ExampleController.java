package com.gsitm.edu.example.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.edu.example.service.ExampleService;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/example/*")
public class ExampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);
	
	@Autowired
	private ExampleService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
    @RequestMapping(value="openSampleEmpList", method = RequestMethod.GET)
    public ModelAndView openSampleBoardList(Map<String,Object> requestMap) {
        ModelAndView mv = new ModelAndView("/example/empList");
         
        List<Map<String,Object>> list = service.selectEmpList(requestMap);
        mv.addObject("list", list);
         
        return mv;
    }
    
    @RequestMapping(value="empList_xtable", method = RequestMethod.GET)
    public void boardList_xtable(Map<String,Object> requestMap) {
    }
    
    @RequestMapping(value="selSampleEmpList_xtable", method = RequestMethod.GET)
    public ModelAndView selSampleBoardList_xtable(Map<String,Object> requestMap) {
    	ModelAndView mv = new ModelAndView("mappingJacksonJsonView");
        
        List<Map<String,Object>> list = service.selectEmpList(requestMap);
        mv.addObject("result", list);
        
        return mv;
    }
    
    
    @RequestMapping(value="findEmp", method = RequestMethod.POST)
    public ModelAndView findEmp(@RequestBody Map<String,Object> requestMap) {
    	System.out.println("컨트롤러시작");
    	ModelAndView mv = new ModelAndView("mappingJacksonJsonView");
        
        List<Map<String,Object>> list = service.selectEmpList(requestMap);
        mv.addObject("result", list);

        return mv;
    }

}
