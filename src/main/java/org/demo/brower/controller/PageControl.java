package org.demo.brower.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.demo.brower.pojo.Article;
import org.demo.brower.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PageControl {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/")
    public String getHomePage(HttpServletRequest request) {
        return "home";
    }

    @PostMapping(value="/search_result")
    public String getResultPage(Model model,@RequestBody String search_content){
        List<Article> articleList=articleService.getArticleList(search_content);
        model.addAttribute("articleList",articleList);
        return "search_result";
    }


}
