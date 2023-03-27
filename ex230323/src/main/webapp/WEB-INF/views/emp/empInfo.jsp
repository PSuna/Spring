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
	<!--  이벤트 전파를 막음 -->
	<form onSubmit="return false">
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
	
	// 페이지 전환(이동)없이 수정
	function updateEmpInfo(){
		fetch('empUpdate',{
			method : 'post',
			headers : {
				'Content-Type' : 'application/json'
			},
			body : JSON.stringify(serializeObject())
		})
		.then(response => response.json())
		.then(data => {
			if(data != null && data['결과'] == 'Success'){
				alert('사원번호 : ' + data['사원번호'] + '의 정보가 수정되었습니다.');
			}else{
				alert('해당 사원의 정보가 정상적으로 수정되지 않았습니다.');
			}
		})
		.catch(reject => console.log(reject));
	}
	
	function serializeObject(){
		// 직렬화 : 객체 => text로
		// serializeArray : 직렬화 배열로 폼태그안에 있는걸 개별적으로 봄
		// [{name : 'firstName', value : 'Steven'}, {name : '', value : ''},...]
		// form 요소들(input, textarea, select)을 이름을 key로, 값을 value로 하는 배열로 인코딩합니다.
		let formData = $('form').serializeArray(); 
	
		let objectData={}
		formData.forEach(function(obj,idx){
			objectData[obj.name] = obj.value
		});
		
		return objectData;
	}
		document.querySelector('button[type="submit"]').addEventListener("click", updateEmpInfo);
	
	</script>
</body>
</html>