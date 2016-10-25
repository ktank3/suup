package com.suwon.web.dao.controller.customer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suwon.web.dao.NoticeDao;
import com.suwon.web.dao.mybatis.MyBatisNoticeDao;
import com.suwon.web.entities.Notice;

@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice notice;
		
		notice = noticeDao.get(_code);
		request.setAttribute("n", notice);
		
		request.getRequestDispatcher("/WEB-INF/views/customer/notice-edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		
		Notice notice = new Notice();
		notice.setCode(code);
		notice.setTitle(title);
		notice.setContent(content);
		
		noticeDao.update(notice);
//		request.getRequestDispatcher("/WEB-INF/views/customer/notice-edit.jsp").forward(request, response);
		response.sendRedirect("notice-detail?code="+code);
	}	
}
