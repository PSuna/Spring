<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<style>
	table, tr, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='empInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp">
				<tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'">
					<td>${emp.employeeId }</td>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.hireDate }</td>
					<td>${emp.jobId }</td>
					<td>${emp.salary }</td>
					<!-- 보통 location.href='deleteInfo?employeeId=${emp.employeeId}' 이런식으로 잘 쓰지않는다 -->
					<td><button type="button" onclick="deleteInfo(${emp.employeeId},event)">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
	
		// JSP는 자바가 먼저 해석됨
		// 그다음에 HTML에 해석하는 브라우저 쪽에서 자바스크립트, CSS 등을 해석함
		function printAlert(message){
			if(message == null || message == '')
				return;
			alert(message);
		}
		
		// 달러 리절트 이렇게하면 얘가 가지고있는 순수한 값만 나옴 => 따라서 우리가 읽을수없는 형태로 나옴
		// 따라서 우리가 화면에서 볼수있게 하기위해 ` ` 를 사용
		printAlert(`${result}`);
		
		// 다량의 데이터에서 특정 데이터만 삭제
		function deleteInfo(id, event){
			$.ajax({
				url : 'empDelete',
				method : 'post',
				data : {employeeId : id},
				// dataType : 'json', 원래는 있어야하지만 생략 가능함 => html, text, json, xml은 알아서 파싱해줌
				success : function(data){
					console.log(data);
					
				},
				error : function(reject){
					console.log(reject);
				}
			});
			
			event.stopPropagation(); // 이벤트 버블링을 막는 메소드
			
		}
		
	</script>

</body>
</html>