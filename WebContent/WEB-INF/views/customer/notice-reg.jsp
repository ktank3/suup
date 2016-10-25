<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<a href="">등록 페이지</a>
	</h1>
	<!-- 데이터를 수정한 후 전달하기 위해 form으로 감싸야 된다. -->
	<form action="notice-reg" method="post"  style="float:left; width:50%;">
		<fieldset>
			<legend>공지사항 등록 필드</legend>
			<table border=1>
				<tbody>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" value="${n.title}" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea rows="20" cols="60" name="content"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<input type="submit" value="등록"/>
				<a href="notice">취소</a>
			</div>
		</fieldset>
	</form>
</body>
</html>



















