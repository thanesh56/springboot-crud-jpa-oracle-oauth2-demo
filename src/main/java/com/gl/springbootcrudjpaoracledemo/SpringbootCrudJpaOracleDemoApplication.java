package com.gl.springbootcrudjpaoracledemo;

import com.gl.springbootcrudjpaoracledemo.dao.ClientDao;
import com.gl.springbootcrudjpaoracledemo.model.Client;
import com.gl.springbootcrudjpaoracledemo.model.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;


@SpringBootApplication
public class SpringbootCrudJpaOracleDemoApplication {

	@Bean
	public CommandLineRunner setupDefaultUser(ClientDao clientDao) {
		return args -> {
			clientDao.saveClient(new Client(
					"user", //username
					"user", //password
					Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles
					true//Active
			));
		};
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudJpaOracleDemoApplication.class, args);
	}

}
