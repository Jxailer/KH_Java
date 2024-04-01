<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<button class="btn1">json - json</button>
	
	<button class="btn2">object - json</button>
	
	<!-- 
	화면에서 이름과 나이를 입력받아 서버에 ajax로 전송하고,
	서버에서는 화면에서 보내준 이름과 나이를 콘솔에 출력하고,
	화면에 result값으로 "성공"을 전송.
	화면에서는 서버에서 보낸 result를 alert으로 출력
	
	1. 화면 구성
	2. 이벤트 등록
	3. 이벤트에서 ajax로 통신
		- 화면에 입력된 정보를 가져옴
		- ajax로 서버에 전송
	4. 서버에서는 화면에서 보낸 정보를 받아 콘솔에 출력
		- 서버에서 화면에 데이터를 전송
		- 화면에서는 서버에서 보낸 데이터를 alert으로 출력
	 -->
	 <br><br>
	 <form action="">
		 <input placeholder="이름" name="name">
		 <input placeholder="나이" name="age">
		 <button type="submit" class="btn3">전송</button>
	 </form>
	 
	 <button type="button" class="btn4">object - object</button>
	 <br>
	 
	 
	 
<!-- 예제 script(btn3) -->
<script type="text/javascript">
	$("form").submit(function (){
		// form에 있는 입력 태그들을 하나의 문자열로 만듦. 'name명=값&' 형태로.
		let obj = $(this).serialize();
		
		$.ajax({
			async : true, //비동기 : true(비동기), false(동기)
			url : '<c:url value="/ajax/test"/>', 
			type : 'get', 
			data : obj, 
			contentType : "application/json; charset=utf-8",
			dataType : "json", 
			success : function (data){
				alert(data.result);
			}, 
			error : function(jqXHR, textStatus, errorThrown){

			}
		});
	})
</script>

<!-- btn1 script -->
<script type="text/javascript">
	function clickTest1(obj){
		// ajax 통신으로 받아온 데이터를 함수의 결과값으로 return하는 방법
		// let name = ""; // 이렇게 해야 clickTest1 함수가 통신 후 받아온 data.name을 함수의 실행 결과로서 return할 수 있음.

		
		$.ajax({
			//동기는 작업1이 다 끝날때까지 기다린 후 작업2가 실행
			//비동기는 작업1이 실행된 후, 끝날때까지 기다리지 않고 작업2가 실행
			async : true,//생략하면 true
			url : '<c:url value="/ajax/json/json"/>', 
			type : 'post', 
			data : JSON.stringify(obj), //객체를 json형태의 문자열로 변환
			//서버로 보내는 데이터의 타입. 위에 있는 data의 타입
			contentType : "application/json; charset=utf-8",
			//서버에서 화면으로 보내는 데이터의 타입. 아래에 있는 success의 data 타입
			dataType : "json", 
			success : function (data){
				// 서버에서 보낸 name과 회원 id, pw를 콘솔창에 출력하는 코드
				console.log(data.name)
				console.log(data.member.id)
				console.log(data.member.pw)
				// $(this) 2번
				// 1번 this와 2번 this는 같다? (x)
				// 2번 = ajax가 일어난 success 객체.
				
				return data.name;
				// name = data.name // 이렇게 해야 clickTest1 함수가 통신 후 받아온 data.name을 함수의 실행 결과로서 return할 수 있음.

			}, 
			error : function(jqXHR, textStatus, errorThrown){
				
			}
		});
		
		// return name; // 이렇게 해야 clickTest1 함수가 통신 후 받아온 data.name을 함수의 실행 결과로서 return할 수 있음.
	}
	
	$(".btn1").click(function(){
		let obj = {
			id : "abc",
			pw : "def"
		}
		
		// $(this); 1번
		
		//작업1
		let name = clickTest1(obj)
		console.log(name) // undefined 리턴
		// 1. 비동기통신으로 인해 name이 return 되기 전에 console.log가 실행됨
		// 2. success에 구현한 함수에 return을 지정하면, success 함수의 결과를 리턴함.
		// - 해결법: ajax 밖에 외부변수를 선언한 다음, 통신 후 받아온 값을 저장하게 하여, ajax 함수 밖에서 return을 하도록함.
		
		
		/*
		$.ajax({
			//동기는 작업1이 다 끝날때까지 기다린 후 작업2가 실행
			//비동기는 작업1이 실행된 후, 끝날때까지 기다리지 않고 작업2가 실행
			async : true,//생략하면 true
			url : '<c:url value="/ajax/json/json"/>', 
			type : 'post', 
			data : JSON.stringify(obj), //객체를 json형태의 문자열로 변환
			//서버로 보내는 데이터의 타입. 위에 있는 data의 타입
			contentType : "application/json; charset=utf-8",
			//서버에서 화면으로 보내는 데이터의 타입. 아래에 있는 success의 data 타입
			dataType : "json", 
			success : function (data){
				// 서버에서 보낸 name과 회원 id, pw를 콘솔창에 출력하는 코드
				console.log(data.name)
				console.log(data.member.id)
				console.log(data.member.pw)
				// $(this) 2번
				// 1번 this와 2번 this는 같다? (x)
				// 2번 = ajax가 일어난 success 객체.
				
				return;
			}, 
			error : function(jqXHR, textStatus, errorThrown){
				
			}
		});
		*/
		//작업2
	});
</script>

<!-- btn2 script -->
<script type="text/javascript">
	$(".btn2").click(function(){
		let obj = {
			id: "abc",
			name: "홍길동",
			pw: "def"
		}
		$.ajax({
			async : true, //비동기 : true(비동기), false(동기)
			url : '<c:url value="/ajax/object/json"/>',
			data : obj, 
			dataType : "json", 
			success : function (data){
				console.log(data.age)
			}, 
			error : function(jqXHR, textStatus, errorThrown){

			}
		});
	})
</script>

<!-- btn4 script -->
<script type="text/javascript">
	let obj = {name : "홍길동"}
	$(".btn4").click(function(){
		$.ajax({
			async : true, //비동기 : true(비동기), false(동기)
			url : '<c:url value="/ajax/object/object"/>', 
			type : 'get', 
			data : obj,
			success : function (data){
				console.log(data);
			}, 
			error : function(jqXHR, textStatus, errorThrown){
		
			}
		});
	})

</script>

</body>
</html>
