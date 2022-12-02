package org.demo.brower.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.demo.brower.pojo.RegisterUser;
import org.springframework.stereotype.Service;

import java.util.HashMap;


public interface UserLoginRegisterService {

    String getRegisterCode(String username);

    void sendRegisterCodeByEmail(String code, String email);

    byte confirmCode(String code, String email);

    byte checkPassword(String password, String passwordAgain);

    boolean addUserToMysql(RegisterUser user);

}
