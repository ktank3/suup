package com.suwon.web.controller.joinus;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.suwon.web.dao.mybatis.MyBatisMemberDao;
import com.suwon.web.entities.Member;
@WebServlet("/joinus/join")
public class JoinController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/views/joinus/join.jsp").forward(request, response);
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("joinus.join",request,response);	//이걸 랜더링하라고
		container.endContext(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String btn = request.getParameter("btn-id-check");	//
			MyBatisMemberDao dao = new MyBatisMemberDao();
		
			
			if(btn.equals("확인")) {
				
				boolean hasMidChecked = false;
				
				//쿠키에 중복을 확인한적이 있는지를 검사
				//Cookie cookie = CookieManager.getCookie("mid-checked"); 따로 클래스만들어서 써도됨.
				Cookie[] cookies = request.getCookies();
				if(cookies != null) {
					for(Cookie ck : cookies) {
						if("cook_midcheck".equals(ck.getName())) {
							//System.out.println(ck.getValue());
							hasMidChecked = true;
						}
					}
				}
				
				String mid = request.getParameter("mid");
				String name = request.getParameter("name");
				String pwd = request.getParameter("pwd");
				String pwd2 = request.getParameter("pwd2");
				String email = request.getParameter("email");
				
				Pattern pattern = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");	// http://regexlib.com/Search.aspx
				
				boolean hasError = false; 
				
				StringBuilder errorMsg= new StringBuilder();
				errorMsg.append("<ul>");
				//유효성검사
				if(mid == null || mid.equals("")) {
					errorMsg.append("<li>아이디가 입력되지 않았습니다.</li>");
					hasError = true;
				}
				if(!hasMidChecked) {
					errorMsg.append("<li>아이디 중복을 확인하지 않았습니다.</li>");
					hasError = true;
				}
				if(name == null || name.equals("")) {
					errorMsg.append("<li>이름이 입력되지 않았습니다.</li>");
					hasError = true;
				}
				if(!pwd.equals(pwd2) || pwd.equals("")) {
					errorMsg.append("<li>비밀번호가 맞지 않습니다.</li>");
					hasError = true;
				}
				if(!pattern.matcher(email).matches()) 	{ //이메일이 우리의 정규식 패턴에 맞는지 확인
					errorMsg.append("<li>이메일 형식이 올바르지 않습니다.</li>");
					hasError = true;
				}
			
				
				errorMsg.append("</ul>");
				
				if(hasError) {
					request.setAttribute("error", errorMsg);
					
					request.setAttribute("mid",mid);
					request.setAttribute("name",name);
					request.setAttribute("email",email);
					request.setAttribute("pwd",pwd);
					request.setAttribute("pwd2",pwd2);

					TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
					container.render("joinus.join",request,response);	
					container.endContext(request,response);
				}
				
				else {
			
					Member member = new Member();
					member.setMid(mid);
					member.setName(name);
					member.setPwd(pwd);
					member.setEmail(email);
					member.setNicName("우루울");
				
					
					dao.insert(member);
					
					response.sendRedirect("confirm");
				}
			}
			
			
			if(btn.equals("중복확인")) {
				String mid = request.getParameter("mid");
				Member member = dao.get(mid);
				
				
				if(member != null)
					request.setAttribute("msgCheckId","이미 사용중인 아이디");
				else {
					request.setAttribute("msgCheckId","사용 가능한 아이디");
					//쿠키로 아이디 사용가능함을 검증한 결과를 저장
					Cookie cookie = new Cookie("cook_midcheck","ok");
					cookie.setMaxAge(24*60*60);	//단위는 초  몇초동안 저장할거냐? 
					response.addCookie(cookie);//응답할떄 야 쿠키 가져가 알려준거
				}
				
				request.setAttribute("mid",mid);
				
				
				TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
				container.render("joinus.join",request,response);	//사용자 한테 가는거 foward는 밑단으로 그냥 간다. doget으로 가지않는다. 
				container.endContext(request,response);
				
				
			}
			
		
	}

}
