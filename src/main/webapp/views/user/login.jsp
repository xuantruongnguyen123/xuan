<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="<c:url value='/template/user/img/logo-title.jpg'/>">
    <title>Đăng nhập - Netflip</title>
    <%@ include file="/common/head.jsp" %>
</head>
<body>
	<%@ include file="/common/header-log-reg.jsp" %>

   <div class="container-fluid tm-mt-60">
        <div class="row tm-mb-50">
            <div class="col-lg-12 col-12 mb-5">
                <h2 class="tm-text-primary mb-5" style="text-align: center;">ĐĂNG NHẬP</h2>
                <form id="login-form" action="login" method="POST" class="tm-contact-form mx-auto">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control rounded-0" placeholder="Tài khoản" required />
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control rounded-0" placeholder="Mật khẩu" required />
                    </div>
                    <div class="form-group tm-text-right">
                        <center><button type="submit" class="btn btn-primary">Đăng nhập</button></center>
                    </div>
                </form>                
            </div>
        </div>
    </div>

    <%@ include file="/common/footer.jsp" %>
</body>
</html>