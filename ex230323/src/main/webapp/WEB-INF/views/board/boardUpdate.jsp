<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h3>게시글 수정</h3>
	<!-- onsubmit="return false" : 자동으로 submit이 동작하는 걸 막음 -->
	<form action="boardUpdate" method="POST" name="updateForm" onsubmit="return false">
		<div>
			<label>번호 : <input type="text" name="bno" readonly value="${boardInfo.bno}"></label>
		</div>
		<div>
			<label>제목 : <input type="text" name="title" value="${boardInfo.title}"></label>
		</div>
		<div>
			<label>작성자 : <input type="text" name="writer" value="${boardInfo.writer}" readonly></label>
		</div>
		<div>
			<label>내용 : </label><textarea name="contents">${boardInfo.contents}</textarea>
		</div>
		<div>
			<label>첨부이미지 : <input type="text" name="image" value="${boardInfo.image}"></label>
		</div>
		<div>
			<label>수정날짜 : <input type="date" name="updatedate"></label>
		</div>
		<button type="submit">수정</button>
		<button type="button" onclick='location.href="getBoardInfo?bno=${boardInfo.bno}"'>취소</button>
	</form>
	
	<script>
		function formOptionChk(){
			let title = document.getElementsByName('title')[0];
			let contents = document.getElementsByName('contents')[0];
			
			if(title.value == ""){
				alert("제목이 입력되지 않았습니다.");
				title.focus();
				return;
			}
			
			if(contents.value == ""){
				alert("내용이 입력되지 않았습니다.");
				contents.focus();
				return;
			}
			updateForm.submit();
		}	
		
		document.querySelector('button[type="submit"]').addEventListener("click", formOptionChk);
		
	</script>
</body>
</html>