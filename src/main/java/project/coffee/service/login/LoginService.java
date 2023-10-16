package project.coffee.service.login;

import project.coffee.domain.dto.login.CustomerLoginRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface LoginService {
    public boolean checkLogin(CustomerLoginRequest customerLoginRequest
            , String m_id, String m_pw
            , HttpSession session
            , HttpServletResponse response
    );
}
