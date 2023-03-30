<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서등록</title>
</head>
<body>
<h3>도서등록</h3>
<form action="bookInsert" method="post" name="insertForm" onsubmit="return false">
	<div>도서번호<input type="text" name="bookNo" value="${bookNo.bookNo}" readonly></div>	
	<div>도서명<input   type="text" name="bookName"></div>
	<div>도서표지<input type="text" name="bookCoverimg"></div>
	<div>출판일자<input type="text" name="bookDate"></div>
	<div>금액<input type="text" name="bookPrice"></div>
	<div>출판사<input type="text" name="bookPublisher"></div>
	<div>도서소개<textarea name="bookInfo"></textarea></div>
	<button type="submit">등록</button>
	<button>조회</button>
</form>

<script>
	function formOptionChk(){
		
		let bookName = document.getElementsByName('bookName')[0];

		if(bookName.value == ""){
			alert("도서명이 입력되지 않았습니다.");
			bookName.focus();
			return;
		}
		
		alert("도서등록이 완료되었습니다.");
		insertForm.submit();
	}	
	
	document.querySelector('button[type="submit"]').addEventListener("click", formOptionChk);
</script>
</body>
</html>