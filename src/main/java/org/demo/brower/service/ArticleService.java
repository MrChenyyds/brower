package org.demo.brower.service;

import org.demo.brower.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {

    List<Article> getArticleList(String content);
}
