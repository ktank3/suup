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

//���� ����Ƿ��� ������ �Ǿ�� �Ѵ�.
//root������ customer�� notice�� ���� �̷� ��û�� �ϰڴ� -> notice.jsp�� �����Ű�� ����
@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p = request.getParameter("p");
		String t = request.getParameter("t");
		String q = request.getParameter("q");
	
		
		//������ ���� �ʾ��� ���� �⺻��
		int page = 1;
		String field = "TITLE";
		String query = "";
		
		//���޵Ȱ� ���� �� ����
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);		
		if(t != null && !t.equals(""))
			field = t;
		if(q != null)
			query = q;
		
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		List<NoticeModel> list = noticeDao.getList(page, field, query);
		//���ڵ� ���� ���ϱ�(����¡ �� �� ���� ��ư ���� �� ���ڵ尡 ���� ���� �����ϰ� ����� ���ؼ�)
		int count = noticeDao.getCount(field,query);
		
		/*//���� ���¿�
		noticeDao.getList();*/
		
		

//		list = new MyBatisNoticeDao().getList();
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		/*super.doGet(request, response);*/
		
		/*//1. jsp�θ��� : jsp�� �˾Ƽ� ���� �ϱ� 
		  // �Ѱ��ٰ� ������ �̷��� �ص��ɵ�
		response.sendRedirect("notice.jsp");*/
		
		//2. �ڿ��� �����ϸ鼭 �θ��� : ���� �̾ ����ϱ�
		//notice.jsp�� ���� ���������� ȣ��Ǹ� �ȵ� - web-inf�� ���ܵ����μ� ������ �̿��� ������ ���´�
		request.getRequestDispatcher("/WEB-INF/views/customer/notice.jsp").forward(request, response);
	}
}
