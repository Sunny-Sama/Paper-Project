package web.fdu_ac_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.fdu_ac_service.service.DBService;
@Controller
public class TestController {
	@Autowired
	private DBService dbService; 
	
	@RequestMapping("/getTestData")
	@ResponseBody
	public String returnTest(){
		System.out.println("success");
		return "Test success";
	}
	
	@RequestMapping("/dbTest")
	@ResponseBody
	public String dbTest(){
		long result = dbService.deleteRule(1);
		System.out.println("result = " + result);
		return "result = " + result;
	}
}
