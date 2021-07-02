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
public class Contenu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String titre;

  @Column(nullable = false)
  private String dateHeure;

  @Column(nullable = false)
  private String texte;

  @Column(nullable = false)
  private String auteur;

  @Column(nullable = false)
  private String url;

  @OneToOne(mappedBy = "contenu")
  private Article article;

  public Contenu(String titre, String dateHeure, String texte, String auteur, String url) {
    this.titre = titre;
    this.dateHeure = dateHeure;
    this.texte = texte;
    this.auteur = auteur;
    this.url = url;
  }
}
