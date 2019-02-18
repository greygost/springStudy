<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/floating-labels.css">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css">



<title>게시판 로그인</title>
</head>
<body data-gr-c-s-loaded="true" style="background-color: white">
<form class="form-signin" action="loginProcess" method="post">
    <div class="text-center mb-4">
        <!-- <img class="mb-4" src="/mpopAd/img/toplogo.png" alt="" style="width: 46%"> -->
        <h1 class="h3 mb-3 font-weight-normal">게시판 로그인</h1>
    </div>

    <div class="form-label-group">
        <input type="text" id="inputId" name="id" class="form-control" placeholder="아이디" required="" autofocus="">
        <label for="inputId">아이디</label>
    </div>

    <div class="form-label-group">
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="비밀번호" required="">
        <label for="inputPassword">비밀번호</label>
    </div>

    <div class="checkbox mb-3">

    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted text-center">©2019</p>
</form>
</body>
</html>