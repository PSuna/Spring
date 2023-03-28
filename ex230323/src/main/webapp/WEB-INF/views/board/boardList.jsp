<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${boardList}" var="board">
			<tr onclick='location.href="getBoardInfo?bno=${board.bno}"' >
				<td>${board.bno }</td>
				<td>${board.title }</td>
				<td>${board.writer }</td>
				<td><fmt:formatDate value="${board.regdate}" pattern = "yyyy년MM월dd일"/></td>
				<td><button onclick='boardUpdate(${board.bno},event)'>수정</button></td>
				<td><button onclick='boardDelete(${board.bno},event)'>삭제</button></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<script>
	function boardUpdate(bno, event){
		location.href="boardUpdate?bno="+bno
		event.stopPropagation(); // 이벤트 버블링 막음
	}
	
	function boardDelete(bno, event){
		location.href="boardDelete?bno="+bno
		event.stopPropagation(); // 이벤트 버블링 막음
	}
	
	</script>
</body>
</html>