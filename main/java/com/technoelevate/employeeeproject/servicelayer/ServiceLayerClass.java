package com.technoelevate.employeeeproject.servicelayer;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.technoelevate.employeeeproject.daolayer.DaoInterface;
import com.technoelevate.employeeeproject.daolayer.DaoLayerClass;
import com.technoelevate.employeeeproject.dtolayer.DtoClass;

public class ServiceLayerClass implements ServiceLayerInterface {
ApplicationContext context=new ClassPathXmlApplicationContext("com/technoelevate/employeeeproject/servicelayer/Config.xml");
	
	DaoInterface dao=context.getBean("daoObjcet",DaoLayerClass.class);
	
	
	public boolean addEmployee(DtoClass dto) {
		
		
		return dao.addEmployeee(dto, dto.getUsername(), dto.getPasskey(), dto.getUserid());
	}
	

	public List<DtoClass> getEmployee() {
		
		List<DtoClass> employeeDetails=dao.getEmployeee();
		
		return employeeDetails;
	}

	public boolean deleteEmployee(String name) {
		
		dao.deleteEmployeee(name);
		
		return true;
	}

	public boolean authentication(String name,String password) {
		
		if(dao.authentication(name, password)!=null) {
			return true;
		}
		return false;
	}


	public boolean search(String name) {
		if(dao.search(name)!=null) {
			return true;
		}
		return false;
	}


	public boolean update(String name, String password) {
		
		if(dao.update(name, password)==true) {
			return true;
		}else {
			return false;
		}
	}

}
