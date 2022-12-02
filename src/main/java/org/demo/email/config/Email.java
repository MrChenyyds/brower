package org.demo.email.config;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Data
@Component
public class Email {
    @Setter
    @Getter
    private String[] user;

    @Setter
    @Getter
    private String subject;

    @Setter
    @Getter
    private String content;
}
