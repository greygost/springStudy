<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css">

<title>게시판 글쓰기</title>
</head>
<body data-gr-c-s-loaded="true" style="background-color: white">
<form class="" action="writeProcess" method="post">
    <div class="text-center mb-4">
        <!-- <img class="mb-4" src="/mpopAd/img/toplogo.png" alt="" style="width: 46%"> -->
        <h1 class="h3 mb-3 font-weight-normal">게시판 글쓰기</h1>
    </div>

    <div class="form-label-group" style="width: 1000px;margin-right:auto;margin-left:auto">
        <input type="text" id="title" name="title" class="form-control" placeholder="제목" required="" autofocus="">        
    </div>

    <div class="form-label-group" style="margin-top: 5%;width: 1000px;height:500px; margin-right:auto;margin-left:auto">
        <textarea id="content" name="content" style="width: 1000px;height:500px;"></textarea>        
    </div>

    <div class="checkbox mb-3">

    </div>
    <button class="btn btn-lg btn-primary btn-block" style="width: 100px;margin-right:auto;margin-left:auto" type="submit">저장</button>
  
</form>
</body>
</html>