package com.suwon.web.dao.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suwon.web.dao.NoticeDao;
import com.suwon.web.dao.mybatis.MyBatisNoticeDao;
import com.suwon.web.model.NoticeModel;

//먼저 실행되려면 서블릿이 되어야 한다.
//root폴더에 customer에 notice에 들어가면 이런 요청을 하겠다 -> notice.jsp를 실행시키기 위해
@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p = request.getParameter("p");
		String t = request.getParameter("t");
		String q = request.getParameter("q");
	
		
		//전달이 되지 않았을 때의 기본값
		int page = 1;
		String field = "TITLE";
		String query = "";
		
		//전달된게 있을 때 설정
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);		
		if(t != null && !t.equals(""))
			field = t;
		if(q != null)
			query = q;
		
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		List<NoticeModel> list = noticeDao.getList(page, field, query);
		//레코드 개수 구하기(페이징 할 때 다음 버튼 누를 때 레코드가 있을 때만 다음하게 만들기 위해서)
		int count = noticeDao.getCount(field,query);
		
		/*//인자 없는용
		noticeDao.getList();*/
		
		

//		list = new MyBatisNoticeDao().getList();
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		/*super.doGet(request, response);*/
		
		/*//1. jsp부르기 : jsp가 알아서 새로 하기 
		  // 넘겨줄게 없으면 이렇게 해도될듯
		response.sendRedirect("notice.jsp");*/
		
		//2. 자원을 공유하면서 부르기 : 일을 이어서 계속하기
		//notice.jsp는 이제 직접적으로 호출되면 안됨 - web-inf에 숨겨둠으로서 개발자 이외의 접근을 막는다
		request.getRequestDispatcher("/WEB-INF/views/customer/notice.jsp").forward(request, response);
	}
}
