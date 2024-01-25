package com.example.userapp.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // req: 톰캣 입장에서 버퍼드롸이터, resp: 톰캣 입장에서 버퍼드리더 에 연결됨
        resp.setHeader("Content-Type", "text/html; charset=utf-8"); // 웹에서 한글 안 깨지게, 지금은 서블릿마다 들어가! 나중에 프론트컨트롤러 만들어서 공통 로직에 넣는다.
        // 1단계: 파싱(엑스폼 데이터 형태로 오는데 키=벨류 형태로 온다. 그걸 파싱)
        // username=ssar&password=1234&email=ssar@nate.com

//        BufferedReader br = req.getReader();
//
//        String requestBody = ""; // 와일문이 돌면 리퀘스트 바디 안에 username=ssar&password=1234&email=ssar@nate.com 요런 데이터가 들어옴
//
//        while (true) {
//            String line = br.readLine();
//            if (line == null) break;
//            requestBody = requestBody + line;
//        }
//        System.out.println(requestBody); // 요기까지가 데이터 읽은 것!! 아직 파싱 안 함.

        // 위의 파싱 과정을 쉽게 하기!!(톰캣)
        String username = req.getParameter("username"); // 요 한 줄에 끝남!!, "" 안에 있는 것이 input 태그의 name과 동일해야 함.
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("email: " + email);

//        BufferedReader br = req.getReader();
//        br.readLine(); // 여기에 이거 안 됨. 왜냐면 위에서 버퍼가 소비되어서.

        // 2. 유효성 검사(1000줄 됨)
        if (username.length() < 3 || username.length() > 10) {

            resp.getWriter().println("<h1>username의 글자수가 3~10자 사이여야 합니다.</h1>");
        }

        // 3. DB 연결(DAO에 보내기 전에 디비에 먼저 연결을 해야 한다.)

        // 4. DAO의 insert 메서드를 호출

        // 5. 메인 페이지 그리기(비효율적)

        // 6. 리다이렉트: 메인 페이지를 그리지 않고 메인을 호출한다. 상태코드가 300번대가 나옴. 300번대의 상태코드는 헤더에 키값으로 로케이션을 들고 오는데. 그러면 자동으로 어? 응답이 302네? 헤더의 로케이션(키값)을 읽어서 그 로케이션의 밸류로 보내줘야지.
        resp.sendRedirect("/main"); // 이 코드를 쓰지 않아도 상태코드에 302를 넣고 헤더에 로케이션을 넣어주면 사용할 수 있음. 밑에서 해보자

//        resp.setStatus(302);
//        resp.setHeader("Location", "/main");
//        resp.setHeader("clock", "12pm");

    }
}
