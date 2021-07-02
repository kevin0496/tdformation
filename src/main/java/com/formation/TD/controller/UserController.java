package com.formation.TD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formation.TD.model.AppUser;
import com.formation.TD.repository.AppUserRepository;
import com.formation.TD.service.AccountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final AppUserRepository appUserRepository;
  private final AccountService accountService;

  @GetMapping("/all")
  public String getAllUsers(Model model) {
    model.addAttribute("listUsers", appUserRepository.findAll());
    return "listUsers";
  }

  @PostMapping("/create")
  public String createUser(Model model, @RequestParam String username, @RequestParam String password) {
    accountService.saveUser(new AppUser(username, password));
    accountService.addRoleToUser(username, "ROLE_EDITOR");
    model.addAttribute("listUsers", appUserRepository.findAll());
    return "listUsers";
  }

  @PostMapping("/delete")
  public String deleteUser(Model model, @RequestParam Long id) {
    appUserRepository.deleteById(id);
    model.addAttribute("listUsers", appUserRepository.findAll());
    return "listUsers";
  }
}
