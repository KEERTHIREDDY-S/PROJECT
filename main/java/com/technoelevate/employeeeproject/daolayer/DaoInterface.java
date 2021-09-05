package com.technoelevate.employeeeproject.daolayer;

import java.util.List;

import com.technoelevate.employeeeproject.dtolayer.DtoClass;

public interface DaoInterface {
public boolean addEmployeee(DtoClass dto,String userName,String userPassword,String user_id);
	
	public List<DtoClass> getEmployeee();
	
	public boolean deleteEmployeee(String name);
	
	public List<DtoClass> authentication(String name,String password);
	
	public List<DtoClass> search(String name);
	
	public boolean update(String name,String password);

}
