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
				<h2>Hệ thống dự đoán hình ảnh</h2>
            </div>
        </section>
        <section>
            <div class="history">
                <a href="">History</a>
            </div>
            <div class="user">
                <p>Hello ${username}</p>
            </div>
            <div class="user">
                <a href="UserLogoutServlet">Logout    <i class="fas fa-sign-out-alt"></i></a>
            </div>
        </section>
    </header>
	
	<form action="">
	    <main>
	        <div class="image-box">
	            <img style="height: 470px"" id="preview-image" src="" alt="input image">
				<div class="input-group">
				  <input type="file" class="form-control" id="input_image" name="image" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
				</div>
	        </div>
			
	        <input type="submit" value="Predict" class="btn btn-danger" name="predict">
	
	        <div class="text-box">
	            <span>TEXT</span>
	        </div>
	    </main>
	</form>


    <footer>
    	<h4>&copy; Hoang Cong Trong - 102210333</h4>
    </footer>

    <script>
	    const input = document.getElementById('input_image');
	    const previewImage = document.getElementById('preview-image');
	    input.addEventListener('change', function(event) {
	        const file = event.target.files[0];
	        const reader = new FileReader();
	        reader.onload = function(e) {
	            previewImage.src = e.target.result;
	        }
	        reader.readAsDataURL(file);
	    });
	</script>
</body>
</html>