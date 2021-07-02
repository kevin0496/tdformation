package com.formation.TD.configuration;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.formation.TD.model.AppUser;

public class UserDetailsImpl implements UserDetails {
  private final Long id;

  private final String username;

  private final String password;

  private final Collection<? extends GrantedAuthority> roles;

  public UserDetailsImpl(final Long id, final String username, final String password,
                         final Collection<? extends GrantedAuthority> roles) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

  public static UserDetailsImpl build(final AppUser user) {
    List<GrantedAuthority> roles = user.getRoles().stream()
      .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
      .collect(Collectors.toList());
    return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), roles);
  }

  public Long getId() {
    return id;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
