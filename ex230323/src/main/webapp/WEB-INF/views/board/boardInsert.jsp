<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h3>게시글 등록</h3>
	<!-- onsubmit="return false" : 자동으로 submit이 동작하는 걸 막음 -->
	<form action="boardInsert" method="POST" name="insertForm" onsubmit="return false">
		<div>
			<label>번호 : <input type="text" name="bno" readonly value="${boardInfo.bno}"></label>
		</div>
		<div>
			<label>제목 : <input type="text" name="title"></label>
		</div>
		<div>
			<label>작성자 : <input type="text" name="writer"></label>
		</div>
		<div>
			<label>내용 : </label><textarea name="contents"></textarea>
		</div>
		<div>
			<label>첨부이미지 : <input type="text" name="image"></label>
		</div>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='getBoardList'">목록</button>
	</form>
	
	<script>
		function formOptionChk(){
			let title = document.getElementsByName('title')[0];
			let writer = document.getElementsByName('writer')[0];
			let contents = document.getElementsByName('contents')[0];
			
			if(title.value == ""){
				alert("제목이 입력되지 않았습니다.");
				title.focus();
				return;
			}
			
			if(writer.value == ""){
				alert("작성자가 입력되지 않았습니다.");
				writer.focus();
				return;
			}
			
			if(contents.value == ""){
				alert("내용이 입력되지 않았습니다.");
				contents.focus();
				return;
			}
			insertForm.submit();
		}	
		
		document.querySelector('button[type="submit"]').addEventListener("click", formOptionChk);
		
	</script>
	
</body>
</html>