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

@WebServlet("/joinus/login")
public class loginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("joinus.login",request,response);	
		container.endContext(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid=request.getParameter("mid");
		String pwd=request.getParameter("pwd");;
		
		//인증
		MemberDao memberDao = new MyBatisMemberDao();
		Member member = memberDao.get(mid);
		//만약에 회원이 존재하지않는다면 회원이 존재하지않습니다. 문구를출력
		if(member==null) {
			
			request.setAttribute("msg", "회원이존재하지않습니다.");
			TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
			container.render("joinus.login",request,response);	
			container.endContext(request,response);
		
		}
		else if (!pwd.equals(member.getPwd())) {
			request.setAttribute("msg", "비밀번호가 틀립니다..");
			TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
			container.render("joinus.login", request, response);
			container.endContext(request, response);

		}
		// 비밀번호가 잘못되엇다면 비번이틀리다고 문구를 출력
		
		else {
			//인증상태저장
			HttpSession session= request.getSession();
			session.setAttribute("mid", mid);
			
			response.sendRedirect("../index");

		}
		// 그렇지 않다면 인증성공
		
		
	
		
		
	}
	
}
