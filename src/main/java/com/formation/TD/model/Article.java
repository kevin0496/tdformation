package com.formation.TD.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String titre;

  @Column(nullable = false)
  private String url;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "contenu_id")
  private Contenu contenu;

  public Article(String titre, String url) {
    this.titre = titre;
    this.url = url;
  }
}
