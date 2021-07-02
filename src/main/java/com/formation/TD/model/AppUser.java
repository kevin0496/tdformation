package com.formation.TD.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(nullable = false)
  private String username;

  @NotNull
  @Column(nullable = false)
  private String password;

  @ManyToMany(fetch= FetchType.EAGER)
  private Collection<AppRole> roles = new ArrayList<>();

  public AppUser(@NotNull String username, @NotNull String password) {
    this.username = username;
    this.password = password;
  }
}
