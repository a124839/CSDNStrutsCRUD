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
	<s:debug></s:debug>
	<br><br>
	<s:form action="emp-edit" >
		<s:hidden name="id"></s:hidden>
		<s:textfield name="firstName" label="firstName"></s:textfield>
		<s:textfield name="lastName" label="lastName"></s:textfield>
		<s:textfield name="email" label="email"></s:textfield>
		<s:submit></s:submit>
	</s:form>
</body>
</html>