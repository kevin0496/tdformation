package com.formation.TD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formation.TD.model.AppRole;
import com.formation.TD.model.AppUser;
import com.formation.TD.service.AccountService;

@SpringBootApplication
public class TdApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(TdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new AppUser("admin", "1234"));
		accountService.saveUser(new AppUser("user", "1234"));

		accountService.saveRole(new AppRole( "ROLE_ADMIN"));
		accountService.saveRole(new AppRole( "ROLE_EDITOR"));

		accountService.addRoleToUser("admin", "ROLE_ADMIN");
		accountService.addRoleToUser("user", "ROLE_EDITOR");
	}
}
