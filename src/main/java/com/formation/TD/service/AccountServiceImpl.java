package com.formation.TD.service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.formation.TD.model.AppRole;
import com.formation.TD.model.AppUser;
import com.formation.TD.repository.AppRoleRepository;
import com.formation.TD.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final PasswordEncoder passwordEncoder;
  private final AppUserRepository appUserRepository;
  private final AppRoleRepository appRoleRepository;

  @Override
  public AppUser saveUser(AppUser user) {
    String pwd = passwordEncoder.encode(user.getPassword());
    user.setPassword(pwd);
    return appUserRepository.save(user);
  }

  @Override
  public AppRole saveRole(AppRole role) {
    return appRoleRepository.save(role);
  }

  @Override
  public void addRoleToUser(String username, String roleName) {
    AppRole role = appRoleRepository.findByRoleName(roleName);
    AppUser user = appUserRepository.findByUsername(username);
    user.getRoles().add(role);
  }

  @Override
  public AppUser findUserByUsername(String username) {
    return appUserRepository.findByUsername(username);
  }
}
