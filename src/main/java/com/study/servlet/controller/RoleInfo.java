package com.study.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.study.servlet.dto.ResponseDto;
import com.study.servlet.entity.Role;
import com.study.servlet.service.RoleService;
import com.study.servlet.service.RoleServiceImpl;

/*
 * 데이터 베이스에서 파라미터로 넘어온 RoleName이 존재하는지 여부 확인 
 * 존재한다면 ResponseDto  Json (200, sucess, ture)
 * 존재하지 않으면 ResponseDto Json(400, error, false)
 * RoleService
 * RoleRespository
 */
@WebServlet("/role")
public class RoleInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RoleService roleService;
	private Gson gson;

	public RoleInfo() {
		roleService = RoleServiceImpl.getInstnace();
		gson = new Gson();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roleName = request.getParameter("roleName");
		System.out.println("roleNaem:" + roleName);

		Role role = roleService.getRole(roleName);

		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (role == null) {
			out.println(gson.toJson(new ResponseDto<>(400, "error", false)));
			return;

		}
		out.println(gson.toJson(new ResponseDto<>(200, "success", true)));

	}

}
