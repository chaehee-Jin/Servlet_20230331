package com.study.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 데이터 베이스에서 파라미터로 넘어온 RoleName이 존재하는지 여부 확인 
 * 존재한다면 ResponseDto  Json (200, sucess, ture)
 * 존재하지 않으면 ResponseDto Json(400, error, false)
 * RoleService
 * RoleRespository
 */
@WebServlet("/role")
public class Role extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Role() {
 
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String roleName = request.getParameter("roleName");
	System.out.println("roleNaem:" + roleName);
		
	}

	
}
