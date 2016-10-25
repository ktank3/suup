package com.suwon.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/greeting")
public class Index extends HttpServlet{		
	@Override	 							
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{								   		//��û		                //�Է�
		//�������� ���
		response.setCharacterEncoding("UTF-8");
		//client�� �о���� ���
		response.setContentType("text/html; charset=UTF-8");
		/*OutputStream os = response.getOutputStream();
		PrintWriter out = new PrintWriter(os);*/

		PrintWriter out = response.getWriter();
		
		//�Է¹��� ���� �����ų ����
		String _cnt = request.getParameter("cnt");
		
		//���������� ������ ������ ������ ������ �̸� ����(�ʱⰪ)
		int cnt = 0;
		
		//���� �Է¹��� ���� ������ 100�� ���� �ϰ� �Է¹��� ���� ������ �Է¹��� �� ��ŭ�� ���ư��� �����.
		if(_cnt != null && !_cnt.equals(""))
			cnt = Integer.parseInt(_cnt);		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"greeting\" method=\"get\">");
		out.write("		<fieldset>");
		out.write("			<legend>ȯ���λ� �Է�</legend>");
		out.write("			<div>");
		out.write("				<label>�ݺ�ȸ�� :</label>");
		out.write("				<input type=	\"text\" name=\"cnt\"/>");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<input type=\"submit\" value=\"say hello\"/>");
		out.write("			</div>");
		out.write("		</fieldset>");
		out.write("	</form>");
		for(int i=0; i<cnt; i++)
			out.println((i+1)+ ": �ȳ�?<br />");
		out.write("</body>");
		out.write("</html>");
		
	}	
}
