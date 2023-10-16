package project.coffee.repository.login;

import java.util.HashMap;


public interface Login {
    HashMap<String,String> findPwById();

    String findNicknameById(String mid);

}
