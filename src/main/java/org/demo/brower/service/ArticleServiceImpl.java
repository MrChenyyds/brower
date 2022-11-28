package org.demo.brower.service;

import jakarta.annotation.Resource;
import org.demo.brower.pojo.Article;
import org.demo.middle.MiddleProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Article> getArticleList(String content) {

        String sql = "SELECT  * FROM articles WHERE title LIKE  concat('%', ?, '%')" ;

        List<Article>articleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Article.class),content);

        return articleList;
    }
}
