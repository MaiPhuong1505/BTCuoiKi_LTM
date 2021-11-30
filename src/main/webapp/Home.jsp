<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String name = "";
try {
	if (session.getAttribute("id") == null) {
		response.sendRedirect("/CK_LTM/Login");
	}
	name = session.getAttribute("user").toString();
} catch (Exception e) {
	System.out.println(e);
	response.sendRedirect("/CK_LTM/Login");
}
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet" href="css/Home.css">
</head>

<body>
	<header>
		<div class="change-mode">
			Chế độ tính: <select onchange="ChangeMode(this)" class="mode-box">
				<option value="1">Giai thừa</option>
				<option value="2">Luỹ thừa</option>
			</select>
		</div>
		Chào,
		<%=name%>
		<!-- lấy tên nè -->
		<a href="Logout">Đăng xuất</a>
	</header>
	<section>

		<form name="FactorForm" id="FactorForm" action="Homepage?mode=1"
			method="post" class="form-container" style="display: block;">
			<!--giai thừa-->
			<h2>Tính giai thừa của một số lớn</h2>
			<p>
				<input type="text" id="factor-input" name="txtNumber"
					class="form-input" placeholder="Nhập số tự nhiên">
			</p>
			<p>
				<input type="submit" name="btnCalc" class="btn-important"
					value="Tính">
			</p>
		</form>
		<form name="ExpoForm" id="ExpoForm" action="Homepage?mode=2"
			method="post" class="form-container" style="display: none;">
			<!--giai thừa-->
			<h2>Tính luỹ thừa số lớn</h2>
			<p>
				<input type="text" id="ef-base" name="txtBase" class="form-input"
					placeholder="Cơ số">
			</p>
			<p>
				<input type="text" id="ef-ex" name="txtExpo" class="form-input"
					placeholder="Số mũ">
			</p>
			<p>
				<input type="submit" name="btnCalc" class="btn-important"
					value="Tính">
			</p>
		</form>
		<a href="/CK_LTM/History">Xem lịch sử đã tính toán</a>
	</section>
</body>
<script src="js/Home.js"></script>

</html>