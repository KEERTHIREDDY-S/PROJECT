package com.technoelevate.employeeeproject.daolayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.technoelevate.employeeeproject.dtolayer.DtoClass;

public class RowMapperImp implements RowMapper<DtoClass>{

	public DtoClass mapRow(ResultSet rs, int rowNum) throws SQLException {
           DtoClass dto=new DtoClass();
		
		dto.setUsername(rs.getString(1));
		dto.setPasskey(rs.getString(2));
		dto.setUserid(rs.getString(3));
		
		return dto;
	
	}

}
