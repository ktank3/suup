package com.suwon.web.controller.joinus;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.suwon.web.dao.MemberDao;
import com.suwon.web.dao.mybatis.MyBatisMemberDao;
import com.suwon.web.entities.Member;

@WebServlet("/joinus/logout")
public class logoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();//session의 정보를 날려버리겟다아
		response.sendRedirect("../index");

	}

}
