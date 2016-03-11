package com.hrsystem.security;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

/* The purpose of this class is for activating permission with spring security */
public class HRsystemPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private DataSource datasource;
	
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		JdbcTemplate template = new JdbcTemplate(datasource);
		Object[] args = {((User)auth.getPrincipal()).getUsername(), targetDomainObject.getClass().getName(), permission.toString()};
		System.out.println(args.toString());
		int count = template.queryForObject("select count(*) from permissions p where p.username = ? and p.target = ? and p.permission = ?", 
				args, Integer.class);
		
		if(count == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasPermission(Authentication arg0, Serializable id, String type, Object permission) {
		return false;
	}

}
