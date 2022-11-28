package org.demo.brower.service;

import org.demo.brower.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Override
    public List<Article> getArticleList(int pageNumber) {
        return null;
    }
}
