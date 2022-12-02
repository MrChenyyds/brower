package org.demo.brower.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Component
public class RegisterUser {

    private  String userName;

    private String userEmail;

    private String userPassword;

    private String userPasswordAgain;

    private String code;
}
