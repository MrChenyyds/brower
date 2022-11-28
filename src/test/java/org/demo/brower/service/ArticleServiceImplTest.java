package org.demo.brower.service;

import org.demo.brower.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    ArticleService service;

    @Test
    void getArticleList() {
        String s="spring";
        List<Article> articleList = service.getArticleList(s);
        System.out.println(articleList);

    }
}