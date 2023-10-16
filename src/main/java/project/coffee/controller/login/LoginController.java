package project.coffee.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.coffee.domain.dto.login.CustomerLoginRequest;
import project.coffee.service.login.LoginService;

import javax.servlet.http.*;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String defaultpath(HttpSession session) {
        return "login";
    }

    @PostMapping("/doLogin")
    public String login(
            HttpSession session,
            HttpServletResponse response,
            HttpServletRequest request,
            CustomerLoginRequest customerLoginRequest
    ) {
        String m_id = request.getParameter("userid");
        String m_pw = request.getParameter("passwd");
        if (loginService.checkLogin(customerLoginRequest, m_id, m_pw, session, response)) {
            System.out.println("-------------------------------");
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session
            , HttpServletResponse response
            , HttpServletRequest request
    ) {
        session = request.getSession(true);
        if (session != null && !session.isNew()) {
            session.removeAttribute("UID");
            session.removeAttribute("UPW");
        }
        //세션객체를 서버에서 제거함
        Cookie myCookie = new Cookie("USER", null);
        myCookie.setMaxAge(0); // 쿠키의 expiration 타임을 0으로 하여 없앤다.
        myCookie.setPath("/"); // 모든 경로에서 삭제 됬음을 알린다.
        response.addCookie(myCookie);
        return "redirect:/";
    }
}
