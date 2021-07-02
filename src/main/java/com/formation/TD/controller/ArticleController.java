package com.formation.TD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formation.TD.exception.ResourceNotFoundException;
import com.formation.TD.model.Article;
import com.formation.TD.model.Contenu;
import com.formation.TD.repository.ArticleRepository;
import com.formation.TD.repository.ContenuRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

  private final ArticleRepository articleRepository;
  private final ContenuRepository contenuRepository;

  @GetMapping("/all")
  public String getAllArticles(Model model) {
    model.addAttribute("listArticles", articleRepository.findAll());
    return "listArticles";
  }

  @GetMapping("/{id}")
  public String getArticle(Model model, @PathVariable(value = "id") Long id) {
    Article article = articleRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("article", "id", id));
    model.addAttribute("article", article.toString());
    return "article";
  }

  @PostMapping("/create")
  public String createArticle(Model model, @RequestParam String titre, @RequestParam String url) {
    articleRepository.save(new Article(titre, url));
    model.addAttribute("listArticles", articleRepository.findAll());
    return "listArticles";
  }

  @PostMapping("/associate")
  public String associate(Model model, @RequestParam Long idC, @RequestParam Long idA) {
    Article article = articleRepository.findById(idA)
      .orElseThrow(() -> new ResourceNotFoundException("article", "id", idA));
    Contenu contenu = contenuRepository.findById(idC)
      .orElseThrow(() -> new ResourceNotFoundException("contenu", "id", idC));

    article.setContenu(contenu);
    articleRepository.save(article);

    model.addAttribute("listArticles", articleRepository.findAll());
    return "listArticles";
  }

  @PostMapping("/delete")
  public String deleteArticle(Model model, @RequestParam Long id) {
    articleRepository.deleteById(id);
    model.addAttribute("listArticles", articleRepository.findAll());
    return "listArticles";
  }
}
