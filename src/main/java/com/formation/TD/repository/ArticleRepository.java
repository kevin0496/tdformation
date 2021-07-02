package com.formation.TD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.TD.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
