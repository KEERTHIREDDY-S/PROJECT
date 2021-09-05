package com.technoelevate.employeeeproject.daolayer;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technoelevate.employeeeproject.dtolayer.DtoClass;

public class DaoLayerClass implements DaoInterface{
	JdbcTemplate template;


	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public boolean addEmployeee(DtoClass dto, String userName, String userPassword, String user_id) {
		String query="insert into springproject.employeedata values(?,?,?)";
		int add=template.update(query,userName,userPassword,user_id);
		return true;
		
	}

	public List<DtoClass> getEmployeee() {
		RowMapper<DtoClass> rowmap=new RowMapperImp();
		String query1="select * from springproject.employeedata";
		List<DtoClass> list=template.query(query1, rowmap);
		return list;
		
	}

	public boolean deleteEmployeee(String name) {
		String query="delete from springproject.employeedata where empname=?";
		template.update(query,name);
		return true;
		
	}

	public List<DtoClass> authentication(String name, String password) {
		String query="select * from  springproject.employeedata where empname='"+name+"' and emppassword='"+password+"'";
		List<DtoClass> list=template.query(query,new RowMapperImp());
		
		return list.size()>0 ? list:null;
		
	}

	public List<DtoClass> search(String name) {
		String query="select * from springproject.employeedata where empname='"+name+"'";
		List<DtoClass> list=template.query(query,new RowMapperImp());
		return list.size()>0 ? list:null;
		
	}

	public boolean update(String name, String password) {
		String query="update  springproject.employeedata set empPassword=? where empname='"+name+"'";
		template.update(query,password);
		return true;
		
	}
	

}
