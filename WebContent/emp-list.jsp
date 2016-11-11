<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="emp-save" >
		<s:textfield name="firstName" label="firstName"></s:textfield>
		<s:textfield name="lastName" label="lastName"></s:textfield>
		<s:textfield name="email" label="email"></s:textfield>
		<s:submit></s:submit>
	</s:form>
	<td>
	<hr>
	</td>
	<table cellpadding="10" cellspacing="0" >
		<thead>
			<tr>
				<td>id</td>
				<td>firstName</td>
				<td>lastName</td>
				<td>email</td>
				<td>Edit</td>
				<td>Delete</td>				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#request.emps">
				<td>${id}</td>
				<td>${firstName}</td>
				<td>${lastName}</td>
				<td>${email}</td>
				<td><a href="emp-edit?id=${id}">Edit</a></td><br>
				<td><a href="emp-delete?id=${id}">Delete</a></td>				
			</s:iterator>
		</tbody>
	</table>
</body>
</html>
