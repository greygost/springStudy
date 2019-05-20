<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    
 <!-- pom.xml 추가 사항 참조 -->   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css">
<title>게시판 리스트</title>
</head>
<body>

<table class="table">
<thead>
    <tr>
      <th scope="col">#</th>     
      <th scope="col">제목</th>
    </tr>
  </thead>
	<c:forEach var="titles" items="${titleList}">
		<tr>
			<td>${titles.idx}</td><td>${titles.title}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>