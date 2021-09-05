package com.technoelevate.employeeeproject.servicelayer;

import java.util.List;

import com.technoelevate.employeeeproject.dtolayer.DtoClass;

public interface ServiceLayerInterface {
	
public boolean addEmployee(DtoClass dto);
	
	public List<DtoClass> getEmployee();
	
	public boolean deleteEmployee(String name);
	
	public boolean authentication(String name,String password);
	
	public boolean search(String name);
	
	public boolean update(String name,String password);

}
