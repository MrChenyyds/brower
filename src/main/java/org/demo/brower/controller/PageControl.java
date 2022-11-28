package org.demo.brower.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.demo.brower.pojo.Article;
import org.demo.brower.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageControl {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/home")
    public String getHomePage(HttpServletRequest request) {
        return "home";
    }

    @GetMapping(value = "/search_result/page/{pageNumber}")
    public String getArticles(Model model, @PathVariable("pageNumber") Integer pageNumber) {
        List<Article> articleList=articleService.getArticleList(pageNumber);
        model.addAttribute("articleList",articleList);
        return "search_result";
    }

}
