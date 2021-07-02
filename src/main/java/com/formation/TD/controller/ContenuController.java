package com.formation.TD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/contenus")
@RequiredArgsConstructor
public class ContenuController {

  private final ContenuRepository contenuRepository;
  private final ArticleRepository articleRepository;

  @GetMapping("/all")
  public String getAllContenu(Model model) {
    model.addAttribute("listContenu", contenuRepository.findAll());
    return "listContenu";
  }

  @PostMapping("/create")
  public String createContenu(Model model, @RequestParam String titre,
                              @RequestParam String dateHeure,
                              @RequestParam String texte,
                              @RequestParam String auteur,
                              @RequestParam String url) {
    contenuRepository.save(new Contenu(titre, dateHeure, texte, auteur, url));
    model.addAttribute("listContenu", contenuRepository.findAll());
    return "listContenu";
  }

  @PostMapping("/delete")
  public String deleteContenu(Model model, @RequestParam Long id) {
    contenuRepository.deleteById(id);
    model.addAttribute("listContenu", contenuRepository.findAll());
    return "listContenu";
  }
}
