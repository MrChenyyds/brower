package org.demo.brower.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class PasswordCheckResult {
    public static final int PASSWORD_WEAK = 0;

    public static final int PASSWORD_DIFF = 1;

    public static final int PASSWORD_OK= 2;

    public static final int PASSWORD_WRONG= 3;

    public static final int PASSWORD_SHORT= 4;
}
