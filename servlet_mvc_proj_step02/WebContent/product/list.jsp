<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 폼</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	
	<div id="wrap" align="center">
		<h1>상품 리스트 - 관리자 페이지</h1>
		<table class="list">
			<tr>
			<td colspan="6" style="border:white; text-align: right">
			<a href="ds?command=write">상품 등록</a>
			</td>
			</tr>
			<tr><th>번호</th><th>이름</th><th>가격</th><th>수정</th><th>삭제</th><th>회원</th>
			<c:forEach var="product" items="${productList }">
			<tr class="record">
				<td>${product.code }</td>
				<td style="color:red"><a href="ds?command=detail&code=${product.code }">${product.name }</a></td>
				<td>${product.price }</td>
				<td><a href="ds?command=update&code=${product.code }">상품 수정</a>
				<td><a href="ds?command=delete&code=${product.code }">상품 삭제</a>
				<td>${product.m_id }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>