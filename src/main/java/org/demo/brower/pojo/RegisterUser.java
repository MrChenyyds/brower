package org.demo.brower.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RegisterUser {

    private  String userName;

    private String userEmail;

    private String userPassword;

    private String userPasswordAgain;

    private String code;
}
