package org.demo.brower.service;

import org.demo.brower.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    List<Article> getArticleList(int pageNumber);
}
