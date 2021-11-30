<%@page import="model.bean.History"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
History his = null;
try {
	his = (History) session.getAttribute("his");
} catch (Exception e) {
	System.out.println(e);
	response.sendRedirect("/CK_LTM/Login");
}
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Xem kết quả</title>
<link rel="stylesheet" href="css/ViewResult.css">
</head>

<body>
	<h2>Kết quả tính</h2>
	<a href="/CK_LTM/Homepage">Về trang chủ</a>
	<%
	if (his.getInput2() == 0) {
	%>
	<p>
		Số đã nhập:
		<%=his.getInput()%>!
	</p>
	<p>
		Giai thừa:
		<%=his.getOutput()%>
	</p>
	<%
	} else {
	%>
	<p>
		Số đã nhập:
		<%=his.getInput()%>
		^
		<%=his.getInput2()%>
	</p>
	<p>
		Kết quả:
		<%=his.getOutput()%>
	</p>
	<%
	}
	%>


</body>

</html>