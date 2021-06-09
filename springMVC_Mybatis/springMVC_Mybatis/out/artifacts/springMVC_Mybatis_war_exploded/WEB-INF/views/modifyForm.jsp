<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form class="container"  action="/member/update" method="post">
  <div class="form-group">
    <label for="id">아이디</label>
    <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력하세요" readonly value="${member.id}">
  </div>
  <div class="form-group">
    <label for="name">이름</label>
    <input type="text" class="form-control" name="name" id="name" placeholder="이름를 입력하세요" value="${member.name}">
  </div>
  <div class="form-group">
    <label for="tel">전화번호</label>
    <input type="text" class="form-control" name="tel" id="tel" placeholder="전화번호를 입력하세요" value="${member.tel}">
  </div>

  <button type="submit" class="btn btn-default">제출</button>
</form>
</body>
</html>