<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<!-- onSubmit="return false" submit 하는거 막아버리는것 -->
	<form action="empUpdate" method="post" onSubmit="return false">
		<div>
			<label> id : <input type="text" name="employeeId" value="${empInfo.employeeId}" readonly></label>
		</div>
		<div>
			<label> first_name : <input type="text" name="firstName" value="${empInfo.firstName}"></label>
		</div>
		<div>
			<label> last_name : <input type="text" name="lastName" value="${empInfo.lastName}"></label>
		</div>
		<div>
			<label> email : <input type="text" name="email" value="${empInfo.email}"></label>
		</div>
		<div>
			<label> phone_number : <input type="text" name="phoneNumber" value="${empInfo.phoneNumber}"></label>
		</div>
		<div>
			<label> hire_date : <input type="date" name="hireDate" value='<fmt:formatDate value="${empInfo.hireDate}" pattern = "yyyy-MM-dd"/>'></label>
		</div>
		<div>
			<label> salary : <input type="text" name="salary" value="${empInfo.salary}"></label>
		</div>
		<div>
			<label> commission_pct : <input type="text" name="commissionPct" value="${empInfo.commissionPct}"></label>
		</div>
		<div>
			<label> manager_id : <input type="text" name="managerId" value="${empInfo.managerId}"></label>
		</div>
		<div>
			<label> department_id : <input type="text" name="departmentId" value="${empInfo.departmentId}"></label>
		</div>
		<button type="submit">수정</button>
		<button type="button">취소</button>
	</form>
	<script>
		fetch('empUpdate',{
			method : 'post',
			headers : {
				'Content-Type' : 'application/json'
			},
			body : convertData();
		})
		.then(response => response.json())
		.then(data => console.log(data))
		.catch(reject => console.log(reject));
		
		function convertData(){
			let selectForm = document.querySelector('form');
			
			let formData = new FormData(selectForm);
			
		}
	</script>
</body>
</html>