package com.sn.dev.backend.repository;

import com.sn.dev.backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
