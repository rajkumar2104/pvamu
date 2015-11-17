package com.pvamu.timesheet.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pvamu.timesheet.service.HelloWorldService;

@Controller
@EnableWebMvc
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	private final HelloWorldService helloWorldService;
	
	private Map<String, Issuer> issuers = new HashMap<String, Issuer>();
	@Autowired
	public WelcomeController(HelloWorldService helloWorldService ) {
		this.helloWorldService = helloWorldService;
		
		
		issuers.put("ATEN", new Issuer("ATEN", "A10 Networks Inc", "corp", "USA"));
	    issuers.put("AAPL", new Issuer("AAPL", "Apple Inc", "corp", "USA"));
	    issuers.put("T", new Issuer("T", "AT&T", "corp", "USA"));
	    issuers.put("CSCO", new Issuer("CSCO", "Cisco Systems, Inc.", "corp", "USA"));
	    issuers.put("CTXS", new Issuer("CTXS", "Citrix Systems, Inc.", "corp", "USA"));
	    issuers.put("GOOGL", new Issuer("GOOGL", "Google Inc", "corp", "USA"));
	    issuers.put("IBM", new Issuer("IBM", "IBM", "corp", "USA"));
	    issuers.put("JNPR", new Issuer("JNPR", "Juniper Networks, Inc.", "corp", "USA"));
	    issuers.put("MSFT", new Issuer("MSFT", "Microsoft Corporation", "corp", "USA"));
	    issuers.put("ORCL", new Issuer("ORCL", "Oracle Corporation", "corp", "USA"));
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());
		
		return "index";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());
		
		return model;

	}
	
	@RequestMapping(value="/issuers", method=RequestMethod.GET,headers = "Accept=application/json")
	  @ResponseBody
	  public Map<String, Issuer> getAllIssuers() {
	    logger.info("Inside getAllIssuers() method...");
	     
	    return issuers;
	  }

}