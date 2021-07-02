package com.formation.TD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.TD.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

  AppUser findByUsername(final String username);
}
