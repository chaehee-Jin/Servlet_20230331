package com.study.servlet.service;

import com.study.servlet.entity.Role;
import com.study.servlet.repository.RoleRepository;
import com.study.servlet.repository.RoleRepositoryImpl;

public class RoleServiceImpl implements RoleService {

	private static RoleService instance;

	public static RoleService getInstnace() {
		if (instance == null) {
			instance = new RoleServiceImpl();
		}
		return instance;
	}

	private RoleRepository roleRepository;

	public RoleServiceImpl() {
		roleRepository = RoleRepositoryImpl.getInstance();
	}

	@Override
	public Role getRole(String roleName) {

		return roleRepository.findRoleByRolename(roleName);
	}

}
