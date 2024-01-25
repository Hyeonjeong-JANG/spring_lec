<%-- 조인은 리다이렉트 할 것이기 때문에 화면이 필요 없다.  insert, delete, update는 그래. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    response.setHeader("Content-Type", "text/html; charset=utf-8"); // 웹에서 한글 안 깨지게, 지금은 서블릿마다 들어가! 나중에 프론트컨트롤러 만들어서 공통 로직에 넣는다.
    // 1단계: 파싱
    String username = request.getParameter("username"); // 요 한 줄에 끝남!!, "" 안에 있는 것이 input 태그의 name과 동일해야 함.
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    System.out.println("username: " + username);
    System.out.println("password: " + password);
    System.out.println("email: " + email);

    // 2. 유효성 검사(1000줄 됨)
    if (username.length() < 3 || username.length() > 10) {

        response.getWriter().println("<h1>username의 글자수가 3~10자 사이여야 합니다.</h1>");
        return;
    }

    // 3. DB 연결(DAO에 보내기 전에 디비에 먼저 연결을 해야 한다.)

    // 4. DAO의 insert 메서드를 호출

    // 5. 메인 페이지 그리기(비효율적)

    // 6. 리다이렉트: 메인 페이지를 그리지 않고 메인을 호출한다. 상태코드가 300번대가 나옴. 300번대의 상태코드는 헤더에 키값으로 로케이션을 들고 오는데. 그러면 자동으로 어? 응답이 302네? 헤더의 로케이션(키값)을 읽어서 그 로케이션의 밸류로 보내줘야지.
//    response.sendRedirect("/main.do"); // 이 코드를 쓰지 않아도 상태코드에 302를 넣고 헤더에 로케이션을 넣어주면 사용할 수 있음. 밑에서 해보자
    response.setStatus(302);
    response.setHeader("Location", "/main.do");
//    response.setHeader("clock", "12pm");
%>