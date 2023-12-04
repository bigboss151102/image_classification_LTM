<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hệ thống phân loại hình ảnh</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<link type="text/css" rel="stylesheet" href="css/predict.css">
</head>
<body>
	<header>
        <section>
            <div>
				<h2>Chào mừng bạn đến với hệ thống phân loại hình ảnh</h2>
            </div>
        </section>
        <section>
            <div class="history">
                <a href="#" onclick="goBack()">Quay lại trang trước</a>
            </div>
            <div class="user">
                <p>Xin chào ${username}</p>
            </div>
            <div class="user">
                <a href="UserLogoutServlet">Đăng xuất <i class="fas fa-sign-out-alt"></i></a>
            </div>
        </section>
    </header>
	<br>
	<br>
	<h4 style="text-align: center;">Danh sách dự đoán của bạn</h4>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Result</th>
		      <th scope="col">Rate Predict</th>
		      <th scope="col">Image</th>
		      <th scope="col">Date Predict</th>
		    </tr>
		  </thead>
		  <tbody class="table-group-divider">
		    <tr>
		      <th scope="row">1</th>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      <th scope="row">2</th>
		      <td>Jacob</td>
		      <td>Thornton</td>
		      <td>@fat</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      <th scope="row">3</th>
		      <td colspan="2">Larry the Bird</td>
		      <td>@twitter</td>
		      <td>@mdo</td>
		    </tr>
		  </tbody>
		</table>
	
    <footer>
    	<h4>&copy; Hoang Cong Trong - 102210333</h4>
    </footer>
    <script>
	    function goBack() {
	
	        window.history.back();
	
	    }
	</script>
</body>
</html>