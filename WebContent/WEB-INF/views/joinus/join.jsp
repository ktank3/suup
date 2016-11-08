<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
<h2>회원가입</h2>
<c:if test="${error!=null}">
	<div style="border: 1px solid red; color: red">${error}</div>
</c:if>
<form action="join" method="post">
	<fieldset>
		<legend>회원정보</legend>
		<table>
			<tbody>
				<tr>
					<th><label>아이디<label></th>
					<td><input name="mid" value="${mid}" /><input type="submit"
						name="btn-id-check" value="중복확인" /> <span>${msgCheckId}</span></td>

				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" value="${pwd}" /></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="pwd2" value="${pwd2}" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input name="name" value="${name}" /></td>
				</tr>
				<tr>
					<th>필명</th>
					<td><input name="nickname" /></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><select name="gender">
							<option>선택</option>
							<option>남자</option>
							<option>여성</option>
					</select></td>
				</tr>
				<tr>
					<th><label>생년월일<label></th>
					<td><input name="year" />년<input name="month" />월<input
						name="day" />일 <input type="radio" name="calendar" />양력 <input
						type="radio" name="calendar" />음력</td>
				</tr>


				<tr>
					<th><label>핸드폰번호</label></th>
					<td><input name="phone" /></td>
				</tr>
				<tr>
					<th><label>이메일</label></th>
					<td><input name="email" value="${email}" /></td>
				</tr>


			</tbody>
		</table>
	</fieldset>
	<input type="submit" name="btn-id-check" value="확인" />

</form>
</main>
