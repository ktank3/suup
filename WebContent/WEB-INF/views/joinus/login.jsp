<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
<h2>로그인</h2>
<c:if test="${msg}">
<div>${msg}</div> 
</c:if>
<form action= "login" method="post">
	<fieldset>
		<legend>로그인</legend>
		<table>
			<tbody>
				<tr>
					<th><label>아이디<label></th>
					<td><input name="mid" value="" /></td>

				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" value="${pwd}" /></td>
				</tr>
			</tbody>
		</table>
	</fieldset>
	<input type="submit" value="확인" />
</main>
