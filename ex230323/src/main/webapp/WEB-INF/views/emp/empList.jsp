<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<style>
	table, tr, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
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
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp">
				<tr>
					<td>${emp.employeeId }</td>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.hireDate }</td>
					<td>${emp.jobId }</td>
					<td>${emp.salary }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		// JSP는 자바가 먼저 해석됨
		// 그다음에 HTML에 해석하는 브라우저 쪽에서 자바스크립트, CSS 등을 해석함
		function printAlert(message){
			alert(message);
		}
		
		// 달러 리절브 이렇게하면 얘가 가지고있는 순수한 값만 나옴 => 따라서 우리가 읽을수없는 형태로 나옴
		// 따라서 우리가 화면에서 볼수있게 하기위해 ` ` 를 사용
		printAlert(`${result}`);
		
	</script>

</body>
</html>