package project.coffee.service.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.coffee.domain.dto.login.CustomerLoginRequest;
import project.coffee.repository.login.Login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    Login loginRepository;

    public boolean checkLogin(
            CustomerLoginRequest customerLoginRequest,
            String m_id, String m_pw,
            HttpSession session,
            HttpServletResponse response
    ) {
        boolean isLogin = false;

        if (!m_id.equals("") && !m_pw.equals("")) {
            if (loginRepository.findPwById().get(m_id) != null &&
                    loginRepository.findPwById().get(m_id).equals(m_pw)) {
                System.out.println("-----------------------");
                session.setAttribute("UID", m_id);
                session.setAttribute("UPW", m_pw);
                Cookie idCookie = new Cookie("USER", String.valueOf(m_id));
                idCookie.setMaxAge(3600 * 24);
                response.addCookie(idCookie);
                isLogin = true;
            }
        }
        return isLogin;
    }
}
