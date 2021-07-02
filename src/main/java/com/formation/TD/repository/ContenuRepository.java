package com.formation.TD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.TD.model.Contenu;

public interface ContenuRepository extends JpaRepository<Contenu, Long> {
}
