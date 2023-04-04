package com.study.servlet.repository;

import com.study.servlet.entity.Role;
import com.study.servlet.util.DBConnectionMgr;

public class RoleRepositoryImpl implements RoleRepository{
	
	private static RoleRepository instance;
	public static RoleRepository getInstance() {
		if(instance == null) {
			instance = new RoleRepositoryImpl();
		}
		return instance;
	}
	private DBConnectionMgr pool;
	
	private RoleRepositoryImpl() {
		pool = DBConnectionMgr.getInstance();
		
	}

	@Override
	public Role findRoleByRolename(String roleName) {
		
		return null;
	}

}