package com.formation.TD.service;

import com.formation.TD.model.AppRole;
import com.formation.TD.model.AppUser;

public interface AccountService {

  AppUser saveUser(AppUser user);
  AppRole saveRole(final AppRole role);
  void addRoleToUser(final String username, final String roleName);
  AppUser findUserByUsername(final String username);

}
