<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Page Loader -->
    <div id="loader-wrapper">
        <div id="loader"></div>

        <div class="loader-section section-left"></div>
        <div class="loader-section section-right"></div>

    </div>
    <nav class="navbar navbar-expand-lg" style="background-color: black;">
        <div class="container-fluid">
            <a class="navbar-brand" href="index" style="color: red;">
            <strong>NETFLIP</strong>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
            <c:choose>
            	<c:when test="${not empty sessionScope.currentUser}">
	            	<li class="nav-item">
	                    <a class="nav-link" aria-current="page" href="">Chào mừng, <strong><i>${sessionScope.currentUser.username}</i></strong></a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="history">Lịch sử</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="favorites">Yêu thích</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="logout">Đăng xuất</a>
	                </li>
            	</c:when>
            	<c:otherwise>
	            	<li class="nav-item">
	                    <a class="nav-link" href="login">Đăng nhập</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="register">Đăng kí</a>
	                </li>
	               <li class="nav-item">
	                    <a class="nav-link" href="forgotpass">Quen Pass</a>
	                </li>
            	</c:otherwise>
            </c:choose>
                
            </ul>
            </div>
        </div>
    </nav>

    <div class="tm-hero d-flex justify-content-center align-items-center" data-parallax="scroll" data-image-src="<c:url value='/template/user/img/banner.jpg'/>">
			<form class="d-flex tm-search-form">
				<input class="form-control tm-search-input" type="search"
					placeholder="Tìm kiếm" aria-label="Tìm kiếm">
				<button class="btn btn-outline-success tm-search-btn" type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
    </div>