<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%
	String _code = request.getParameter("code");

	NoticeDao noticeDao = new MyBatisNoticeDao();
	Notice notice = noticeDao.get(_code);

	//이 페이지에서만 쓸거기 때문에 pageContext사용
	//여기서 notice는 모델ㅋ
	pageContext.setAttribute("n", notice);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<a href="">(${n.code})디테일 페이지</a>
	</h1>
	<table border=1>
		<tbody>
			<tr>
				<td>제목</td>
				<td colspan="3">
					<%-- <!-- 아이피가져오기 -->
					${pageContext.request.remoteAddr} /
					<!-- header꺼 가져와보기 --> 
					${header["User-Agent"]} /  --%> <%-- 같은 EL표기 : ${n["title"]} --%>
					${n.title}
				</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="3">
				<fmt:formatDate pattern="yy.MM.dd hh:mm" value="${n.regdate}"/>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${n.writer}</td>
				<td>조회수</td>
				<td>${n.hit}</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3">없음</td>
			</tr>
			<tr>
				<td colspan="4">${n.content}</td>
			</tr>
		</tbody>
	</table>
	<div>	
	<ul>
		<li><a href="notice">목록</a></li>
		<li><a href="notice-edit?code=${n.code}">수정</a></li>
		<li><a href="notice-del?code=${n.code}">삭제</a></li>
	</ul>
	</div>
</body>
</html>



















