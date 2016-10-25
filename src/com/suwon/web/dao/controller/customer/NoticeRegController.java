package com.suwon.web.dao.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suwon.web.dao.NoticeDao;
import com.suwon.web.dao.mybatis.MyBatisNoticeDao;
import com.suwon.web.entities.Notice;

@WebServlet("/customer/notice-reg")
public class NoticeRegController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.getRequestDispatcher("/WEB-INF/views/customer/notice-reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		//현재 로그인 사용자 정보를 얻는 로직
		notice.setWriter("me");
		
		noticeDao.insert(notice);
		response.sendRedirect("notice");
	}	
}
