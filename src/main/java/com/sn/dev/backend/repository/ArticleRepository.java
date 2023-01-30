package com.sn.dev.backend.repository;

import com.sn.dev.backend.model.Article;
import com.sn.dev.backend.model.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
