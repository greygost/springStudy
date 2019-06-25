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
  <tbody>
	<c:forEach var="titles" items="${titleList}">
		<tr>
			<td>${titles.idx}</td><td>${titles.title}</td>
		</tr>
	</c:forEach>
</tbody>
</table>

<script>
// 리스트에서 글 목록 클릭시 뷰어로 이동 하는 기능
//제이쿼리

$('tr').click(function(){
	//console.dir(this);
	let ftd = $(this).children().first().text();
	location.href = "/bbs/viewer?idx="+ftd;
});

//자바스크립트
/*
window.onload = function(){	
	let tds = document.getElementsByTagName('tr');	
	for(let i = 0;i < tds.length;i++){
		tds[i].onclick = function(){
			//console.log(this.firstChild.nextElementSibling.innerText);
			let ftd = this.firstChild.nextElementSibling.innerText;
			location.href = "/bbs/viewer?idx="+ftd;
		};
	}
};
*/

</script>
</body>
</html>

