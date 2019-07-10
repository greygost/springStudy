<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css">

<title>게시판 글 보기 </title>
</head>
<body data-gr-c-s-loaded="true" style="background-color: white">
<form class="" action="" >
    <div class="text-center mb-4">
        <!-- <img class="mb-4" src="/mpopAd/img/toplogo.png" alt="" style="width: 46%"> -->
        <h1 class="h3 mb-3 font-weight-normal">게시판 글 보기 </h1>
    </div>
<c:forEach var="items" items="${contents}">
	<input id='idx' value="${items.idx }" style="display: none"/>
    <div class="form-label-group" style="width: 1000px;margin-right:auto;margin-left:auto">
        <input type="text" id="title" name="title" class="form-control" placeholder="제목" required="" autofocus="" disabled="disabled" value="${items.title }">        
    </div>

    <div class="form-label-group" style="margin-top: 5%;width: 1000px;height:500px; margin-right:auto;margin-left:auto">
        <textarea id="content" name="content" style="width: 1000px;height:500px;" disabled="disabled" >${items.content }</textarea>        
    </div>
</c:forEach>

    <div style="margin-right:auto;margin-left:auto;width:100%;height:5rem">
	    <button class="btn btn-lg btn-primary " style="width: 100px;margin-right:auto;margin-left:45%;display: inline-block;margin-top:1rem" type="button" id="updateBtn">수정</button>
		<button class="btn btn-lg btn-primary " style="width: 100px;margin-right:auto;display: inline-block;margin-top:1rem" type="button" onclick="updateRun();" >저장</button>
    </div>

</form>

<!-- 댓글 -->
<!--  
새로운 디비 테이블 컬럼 정보
테이블명 reply
컬럼명
idx - 댓글 인덱스 , (자동증가,pk, not null)
contentIdx - 참조되는 본문인덱스
replyContent - 댓글 내용
wrId - 댓글 쓴사람
 -->
 
 <c:set var="data" value="${fn:length(repls) }" />

<c:if test="${data > 0 }">

	<c:forEach var="replItems" items="${repls}">
	<div style="width: 1000px;margin-right:auto;margin-left:auto;margin-top: 1rem;height:5rem">
		
		<form class="" action="" >
		<textarea id = 'repltxt' rows="3" cols="120" style="float: left;" disabled="disabled">${replItems.wrId } ->${replItems.replyContent }</textarea>
		</form>
	</div>
	</c:forEach> 
</c:if>
 
<div style="width: 1000px;margin-right:auto;margin-left:auto;margin-top: 2rem;height:5rem">
	<p>${userId }</p>
	<form class="" action="" >
	<textarea id = 'repltxt' rows="3" cols="120" style="float: left"></textarea>
	<button class="btn btn-lg btn-primary " style="width: 100px;height:79px;float: left" type="button" onclick="repleWrite();" >저장</button>
	</form>
</div>
<script>
$('#updateBtn').click(function(){
	$('#content').prop('disabled', false);
});

function updateRun(){
   let idx = $("#idx").val();
   let content = $("#content").val();

	 $.ajax({
		url : "/bbs/updateProcess",
		type:"post",
		data:{'idx':idx,'content':content},
		success:function(res){
			console.log(res);
			if(res == false){
				alert("수정에 실패 하였습니다.");
			}else{
				alert("수정완료");
			}
		},
		fail:function(err){
			console.log(err);
			alert("수정 중에 문제가 발생하였습니다. \n"+err);
		}
	});	 
};

function repleWrite(){
	   let idx = $("#idx").val();
	   let replyContent = $("#repltxt").val();

		 $.ajax({
			url : "/bbs/replWriteProcess",
			type:"post",
			data:{'contentIdx':idx,'replyContent':replyContent},
			success:function(res){
				console.log(res);
				if(res == false){
					alert("입력에 실패 하였습니다.");
				}else{
					alert("입력완료");
				}
			},
			fail:function(err){
				console.log(err);
				alert("수정 중에 문제가 발생하였습니다. \n"+err);
			}
		});	 
	};
</script>
</body>
</html>
