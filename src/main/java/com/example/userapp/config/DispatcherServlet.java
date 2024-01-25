package com.example.userapp.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//FrontController: 모든 컨트롤러 앞에 있다. 이 파일이 있으니까 board, user 패키지는 없다고 여겨라!!!
@WebServlet("*.do") // /* 하면 리다이렉션이 안 됨. 일단 우리가 잘 모르니까 */do로 하자!!
public class DispatcherServlet extends HttpServlet {

    // /user.do
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 공통로직
        System.out.println("common logic~~~~~");
        resp.setHeader("Content-Type", "text/html; charset=utf-8");

        // 2. 분기
        String uri = req.getRequestURI(); // 포트변호 뒤에 있는 /user.do 애를 파싱해줌.!!
        System.out.println(uri);

        // WEB-INF 패키지에 파일들을 넣은 이유! 모든 요청이 오면 디스패쳐로 가라고 강제성을 부여하기 위해서. 컨트롤러를 통해서만 뷰를 찾을 수 있다.(CV방식)
        if(uri.equals("/join-form.do")){
//            resp.sendRedirect("/WEB-INF/user/join-form.jsp"); // /WEB-INF는 보안폴더라서 이렇게 쓰면 접근 안 됨. 샌드리다이렉트도 호출이 두 번 일어나는 것이기 때문에 외부요청이라 때문에 불러지지 않음. 리다이렉트는 요청을 두 번 하는 것이기 때문에 리퀘스트 리스폰스 두 번 만들어짐. 초면이니까(스테이트리스). 최초에 요청한 데이터 없음!!!!!!!! 그렇기 때문에 안에 들어가서 요청 요청 (? 이걸 뭘로 말할지 모르겠음.)
            // 프론트 컨트롤러 방식을 사용하면 아파치가 뭘 하는지 관심을 가질 필요도 없다. 톰캣을 지나서 프론트 컨트롤러가 요청을 다 받으니까.
            req.getRequestDispatcher("/WEB-INF/user/join-form.jsp").forward(req, resp); // 이렇게 하면 요청을 받고 내부적으로 요청을 또 하기 때문에 res, resp가(??) 새로 만들어지지 않는다. // 외부에서 보안폴더에 절대 바로 접근할 수 없기 때문에 디스패쳐로 가서 한다.
            System.out.println("조인폼2");
        }else if(uri.equals("/join.do")){
            //resp.sendRedirect("/WEB-INF/user/join.jsp");
            req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
            System.out.println("조인1");
        }else if(uri.equals("/main.do")){
            //resp.sendRedirect("/WEB-INF/board/main.jsp");
            req.getRequestDispatcher("/WEB-INF/board/main.jsp").forward(req, resp);
            System.out.println("메인1");
        }else{
            resp.setStatus(404);
            resp.getWriter().println("잘못된 페이지를 요청하셨어요");
        }
    }
}