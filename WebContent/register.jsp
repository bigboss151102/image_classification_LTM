<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Đăng nhập vào hệ thống</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body style="background-color: hsla(89, 43%, 51%, 0.3);">
	<h1 style="text-align: center;">Chào mừng bạn đến với hệ thống phân loại hình ảnh</h1>
	<br>
	<br>
	<br>
	<div class="login-form">

	    <form action="AddUserServlet" method="POST">
	        <h2 class="text-center">Đăng Kí</h2>   
   	       	<c:if test="${message != null}">
				<div class="row">
					<div class="col text-center"><h4 class="message">${message}</h4></div>
				</div>
			</c:if>
	        <div class="form-group">
	        	<div class="input-group">
	                <div class="input-group-prepend">
	                    <span class="input-group-text">
	                        <span class="fa fa-user"></span>
	                    </span>                    
	                </div>
	                <input type="text" class="form-control" name="username" placeholder="Username" required="required">				
	            </div>
	        </div>
			<div class="form-group">
	            <div class="input-group">
	                <div class="input-group-prepend">
	                    <span class="input-group-text">
	                        <i class="fa fa-lock"></i>
	                    </span>                    
	                </div>
	                <input type="password" class="form-control" name="password" placeholder="Password" required="required">				
	            </div>
	        </div> 
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fa fa-lock"></i>
                        </span>
                    </div>
                    <input type="password" class="form-control" name="password_new_again" placeholder="Xác nhận mật khẩu" required="required">
                </div>
            </div>   
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fa fa-lock"></i>
                        </span>
                    </div>
                    <input type="email" class="form-control" name="email" placeholder="Vui lòng nhập email" required="required">
                </div>
            </div>    
	        <div class="form-group">
	            <button type="submit" class="btn btn-primary login-btn btn-block">Đăng ký</button>
	        </div>
	    </form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<footer style="text-align: center;"><h4>Hoàng Công Trọng-102210333</h4></footer>
</body>
</html>