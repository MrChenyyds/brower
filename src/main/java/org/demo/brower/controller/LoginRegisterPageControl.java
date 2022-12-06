package org.demo.brower.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.demo.brower.pojo.Article;
import org.demo.brower.pojo.ComfirmEmailResult;
import org.demo.brower.pojo.PasswordCheckResult;
import org.demo.brower.pojo.RegisterUser;
import org.demo.brower.service.ArticleService;
import org.demo.brower.service.UserLoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginRegisterPageControl {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserLoginRegisterService userLoginRegisterService;

    @GetMapping(value = "/home")
    public String getHomePage(HttpServletRequest request) {
        return "home";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(HttpServletRequest request) {
        return "login";
    }

    @GetMapping(value = "/register")
    public String getRegisterPage(Model model, HttpServletRequest request) {
        RegisterUser user = new RegisterUser();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value = "/getcode")
    public void getRegisterCode(HttpServletRequest request, @RequestParam("userEmail") String userEmail) {
        String code = userLoginRegisterService.getRegisterCode(userEmail);
        userLoginRegisterService.sendRegisterCodeByEmail(code, userEmail);
        return;
    }

    @PostMapping(value = "/registerConfirm")
    public void confirmCode(Model model, HttpServletRequest request, @RequestParam("user") RegisterUser user) {
        byte confirmCodeResult = userLoginRegisterService.confirmCode(user.getCode(), user.getUserEmail());
        boolean addToMysqlresult= userLoginRegisterService.addUserToMysql(user);
        byte passwordResult =  userLoginRegisterService.checkPassword(user.getUserPassword(), user.getUserPasswordAgain());
        switch (confirmCodeResult) {
            case ComfirmEmailResult.DIFFERENT:
                model.addAttribute("fault", "your code is incorrect!!!!");
                break;
            case ComfirmEmailResult.TIMEOUT:
                model.addAttribute("fault", "time out,please try again!!!");
                break;
            default:
                model.addAttribute("fault", "");

        }
        if (addToMysqlresult) {
            model.addAttribute("warn", "database error,register fail!!!!");
        }
        else{
            model.addAttribute("warn", "");

        }
        switch (passwordResult) {
            case PasswordCheckResult.PASSWORD_DIFF:
                model.addAttribute("error", "your password is different!!!");
                break;
            case PasswordCheckResult.PASSWORD_WEAK:
                model.addAttribute("error", "your password is weak!!!");
                break;
            case PasswordCheckResult.PASSWORD_SHORT:
                model.addAttribute("error", "your password is short!!!");
                break;
            case PasswordCheckResult.PASSWORD_WRONG:
                model.addAttribute("error", "your password contain 空格或汉字!!!");
                break;
            default:
                model.addAttribute("error", "");
        }
        return;
    }

}