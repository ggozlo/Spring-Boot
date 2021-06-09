<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <thead>
            <th>아이디</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>기타</th>
        </thead>
        <tbody >
        <c:forEach var="member" items="${list}">
            <tr >
            <td>${member.id}</td>
            <td>${member.name}</td>
            <td>${member.tel}</td>
                <td>
                    <a href="/member/delete/${member.id}">
                        <button class="btn btn-primary">삭제</button>
                    </a>
                    <a href="/member/update/${member.id}">
                        <button class="btn btn-primary">수정</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/member">
        <button class="btn btn-primary">입력하기</button>
    </a>
    <form class="form-inline" action="/member/search" method="get">
        <div class="form-group">
            <label for="searchName">Name</label>
            <input type="text" class="form-control" id="searchName" name="searchName" placeholder="검색어를 입력">
        </div>
        <button type="submit" class="btn btn-default">검색</button>
    </form>
</div>
</body>
</html>