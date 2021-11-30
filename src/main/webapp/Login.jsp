<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String str = "";
try {
	str = (String) (session.getAttribute("error"));
} catch (Exception e) {
	System.out.println(e);
}
try {
	if (session.getAttribute("id") != null) {
		response.sendRedirect("/CK_LTM/Homepage");
	}
} catch (Exception e) {
	System.out.println(e);
}
session.removeAttribute("error");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" href="css/Login.css">
</head>

<body>
	<form name="LoginForm" id="login-form" action="/CK_LTM/Login"
		method="post" class="form-container">
		<h1>ĐĂNG NHẬP</h1>
		<p>
			<input type="text" id="name-input" name="txtUN" class="form-input"
				placeholder="Tên đăng nhập">
		</p>
		<p>
			<input type="password" id="pass" name="txtPW" class="form-input"
				placeholder="Mật khẩu">
		</p>
		<p>
			<input type="submit" name="btnLogin"
				class="form-button btn-important" value="Đăng nhập">
		</p>
		<p>
			<input type="reset" id="butt-reset" name="btnReset"
				class="form-button btn-other" value="Huỷ">
		</p>
	</form>
</body>
<script src="js/Login.js"></script>
<script>
	const str = "<%=str%>";
	if (str != "null") {
		alert(str);
	}
</script>

</html>