package com.technoelevate.employeeeproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.technoelevate.employeeeproject.dtolayer.DtoClass;
import com.technoelevate.employeeeproject.servicelayer.ServiceLayerClass;

@Controller
public class ControllerClass {
	@Autowired
	ServiceLayerClass service;
	
	@GetMapping("/registeremp")
	public String frontPage() {
		return"registeremp";
	}
	
	@PostMapping("/addemp")
	public String addEmployee(ModelMap map,DtoClass dto) {
		
		map.addAttribute("DTO_Object",dto);
	
		service.addEmployee(dto);
		
		return"addemp";
	}
	
	@GetMapping("/getemp")
	public String allEmployee() {
		return"allemp";
	}
	
	@GetMapping("/getallemp")
	public String getAllEmployees(ModelMap map,DtoClass dto) {
		
		map.addAttribute("myEmploeeDetails",service.getEmployee());
		
		return "getallemp";
	}
	
	@GetMapping("/delete")
	public String deleteEmployeeDetail() {
		return "delete";
	}
	@PostMapping("/deletemp")
	public String deleteEmployee(ModelMap map,DtoClass dto) {
		
		map.addAttribute("MyDtoObject",dto);
		map.addAttribute("name",dto.getUsername());
		
		if(dto.getUsername()!=null) {
			service.deleteEmployee(dto.getUsername());
			map.addAttribute("status","Deleted");
		}else {
			map.addAttribute("status","Not Deleted");
		}
		return "deleteemp";
	}
	
	@GetMapping("/login")
	public String authentication(DtoClass dto,HttpServletRequest req) {
		HttpSession session=req.getSession();
		session.setAttribute("name",dto.getUsername());
		return "authentication";
	}
	
	@PostMapping("/loginemp")
	public String authentication(ModelMap map,DtoClass dto) {
		
		map.addAttribute("MyDtoObject",dto);
		
		if(dto.getUsername()!=null) {
			
			
			if(service.authentication(dto.getUsername(), dto.getPasskey())){
				
				;
				
				map.addAttribute("status","Login successfull");
				map.addAttribute("username",dto.getUsername());
				
				return "authenticationlogin";
			}else{
				map.addAttribute("status","login Failed");
				return "authenticationfail";
			}
		}
		return "authentication1";
		
	}
	@GetMapping("/logout")
	
	public String logout() {
		
		return "authentication";
	}
	
	@GetMapping("/searchemp")
	public String searchEmployee() {
		
		return "searchemp";
	}
	
	@PostMapping("/searchemprecord")
	public String searchEmployeeInDataBase(ModelMap map,DtoClass dto) {
		
		map.addAttribute("DtoObjcet",dto);
		map.addAttribute("name",dto.getUsername());
		if(dto.getUsername()!=null) {
			if(service.search(dto.getUsername())==true) {
				map.addAttribute("status","Record is their");
			}else {
				map.addAttribute("status","Record not their");
			}
		}
		return "searchemprecord";
	}
	
	@GetMapping("/updateemp")
	public String update() {
		
		return "updateemp";
		
	}
	
	@PostMapping("/updateemprecord")
	public String updateEmployee(ModelMap map,DtoClass dto) {
		
		map.addAttribute("dtoOject",dto);
		map.addAttribute("name",dto.getUsername());
		
		if(dto.getUsername()!=null) {
			
			if(service.search(dto.getUsername())==true) {
				
				map.addAttribute("Record","Record is their");
				
				if(service.update(dto.getUsername(), dto.getPasskey())) {
					
					map.addAttribute("status","Record updated");
					
				}else {
					
					map.addAttribute("status","Record Not updated");
				}
			}else {
				map.addAttribute("Record","Record is not their");
			}
		}
		return "updateemprecord";
	}

}
