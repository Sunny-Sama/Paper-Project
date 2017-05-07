package web.fdu_ac_service.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.json.JSONArray;

import service.fdu_ac_service.model.ACConstants;
import service.fdu_ac_service.model.Rule;
import service.fdu_ac_service.service.DBService;

@Controller
public class UserACController {
	@Autowired
	private DBService dbService; 
	
	@RequestMapping("/getWhiteList")
	@ResponseBody
	public Map<String, Object> getWhiteList(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> rm = new HashMap<String, Object>();
		response.addHeader("Access-Control-Allow-Origin", "*");
		String tableIds = request.getParameter("tableIds");
		String tmp = tableIds.substring(0, tableIds.length() - 1);
		long hash = tmp.hashCode();
		try{
			Rule[] ruleList = dbService.getRuleList(hash, ACConstants.WHITE);
			JSONArray jsonArray = new JSONArray();
			
			if(ruleList != null && ruleList.length > 0){
				for(Rule r : ruleList){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("ruleId", r.getRuleId());
					map.put("userId", r.getUserId());
					map.put("userName", r.getUserName());
					jsonArray.put(map);
				}
			}
			 rm.put("result","success");
	         rm.put("message","success");
	         rm.put("code","200");
	         rm.put("ruleList",jsonArray.toString());
		}catch (Exception e) {
			 e.printStackTrace();
	         rm.put("result","error");
	         rm.put("message","error");
		}
		return rm;
	}
	
	@RequestMapping("/getBlackList")
	@ResponseBody
	public Map<String, Object> getBlackList(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> rm = new HashMap<String, Object>();
		response.addHeader("Access-Control-Allow-Origin", "*");
		String tableIds = request.getParameter("tableIds");
		String tmp = tableIds.substring(0, tableIds.length() - 1);
		long hash = tmp.hashCode();
		
		try{
			Rule[] ruleList = dbService.getRuleList(hash, ACConstants.BLACK);
			JSONArray jsonArray = new JSONArray();
			if(ruleList != null && ruleList.length > 0){
				for(Rule r : ruleList){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("ruleId", r.getRuleId());
					map.put("userId", r.getUserId());
					map.put("userName", r.getUserName());
					jsonArray.put(map);
				}
			}
			 rm.put("result","success");
	         rm.put("message","success");
	         rm.put("code","200");
	         rm.put("ruleList",jsonArray.toString());
		}catch (Exception e) {
			 e.printStackTrace();
	         rm.put("result","error");
	         rm.put("message","error");
		}
		return rm;
	}
	
	@RequestMapping("/addWhiteList")
	@ResponseBody
	public Map <String,Object> addToWhite(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> rm = new HashMap<String, Object>();
		
		String tableIds = request.getParameter("tableIds");
		long userId = Long.parseLong(request.getParameter("userId"));
		long catalogId = Long.parseLong(request.getParameter("catalogId"));
		String tmp = tableIds.substring(0, tableIds.length() - 1);
		long hash = tmp.hashCode();
		String[] tableList = tmp.split(",");
		long [] list = new long[tableList.length];
		for(int i = 0; i < list.length; i++)
			list[i] = Long.parseLong(tableList[i]);
		
		long ret = dbService.addRule(hash, list, userId, catalogId, ACConstants.WHITE);
		if(ret > 0){
			rm.put("result", "success");
			rm.put("message", "success");
		}else{
			rm.put("result", "error");
			rm.put("message", "duplicate");
		}
		return rm;
	}
	
	@RequestMapping("/addBlackList")
	@ResponseBody
	public Map <String,Object> addBlackList(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> rm = new HashMap<String, Object>();
		
		String tableIds = request.getParameter("tableIds");
		long userId = Long.parseLong(request.getParameter("userId"));
		long catalogId = Long.parseLong(request.getParameter("catalogId"));
		String tmp = tableIds.substring(0, tableIds.length() - 1);
		long hash = tmp.hashCode();
		String[] tableList = tmp.split(",");
		long [] list = new long[tableList.length];
		for(int i = 0; i < list.length; i++)
			list[i] = Long.parseLong(tableList[i]);
		
		long ret = dbService.addRule(hash, list, userId, catalogId, ACConstants.BLACK);
		if(ret > 0){
			rm.put("result", "success");
			rm.put("message", "success");
		}else{
			rm.put("result", "error");
			rm.put("message", "duplicate");
		}
		return rm;
	}
	
	@RequestMapping("/deleteRule")
	@ResponseBody
	public Map <String, Object> deleteRule(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> rm = new HashMap<String, Object>();
		long ruleId = Long.parseLong(request.getParameter("ruleId"));
		long ret = dbService.deleteRule(ruleId);
		if(ret > 0){
			rm.put("result", "success");
			rm.put("message", "success");
		}else{
			rm.put("result", "error");
			rm.put("message", "error");
		}
		return rm;
	}
	
	
	
	
}
