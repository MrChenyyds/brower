package org.demo.brower.service;

import org.demo.brower.pojo.Article;
import org.demo.middle.MiddleProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    MiddleProcess  middleProcess;

    @Override
    public List<Article> getArticleList(String content) {

        return null;
    }
}
