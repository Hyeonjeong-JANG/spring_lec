<%@ page import="java.time.LocalDateTime" %><%-- 컨텐트 타입 설정 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--이런거 밑에 있는 애들을 서버에서 요리조리해서 렌더링한다. SSR--%>
<%
    System.out.println("조인폼1");
    LocalDateTime now = LocalDateTime.now();
%>
<%--<%=now%>화면에 뿌리고 싶으면 =을 해준다. --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원가입 페이지<%=now%>
</h1>

<hr>
<form action="/join.do" method="post">
    <input type="text" placeholder="username" name="username">
    <input type="text" placeholder="password" name="password">
    <input type="text" placeholder="email" name="email">
    <button>회원가입</button>
</form>
</body>
</html>