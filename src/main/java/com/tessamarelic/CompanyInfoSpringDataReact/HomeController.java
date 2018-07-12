package com.tessamarelic.CompanyInfoSpringDataReact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //marks class as Spring MVC controller
public class HomeController {
	
	@RequestMapping(value = "/")  //Spring Boot's autoconfigured view resolver maps to src/main/resources/templates/index.html
	public String index() {
		return "index";
	}
}
