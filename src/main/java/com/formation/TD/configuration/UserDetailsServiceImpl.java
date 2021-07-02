package com.formation.TD.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formation.TD.model.AppUser;
import com.formation.TD.repository.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final AppUserRepository appUserRepository;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    AppUser user = appUserRepository.findByUsername(login);
    return UserDetailsImpl.build(user);
  }
}
