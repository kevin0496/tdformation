package com.formation.TD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.TD.model.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

  AppRole findByRoleName(final String roleName);
}
