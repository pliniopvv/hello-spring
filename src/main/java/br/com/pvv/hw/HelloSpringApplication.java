
package br.com.pvv.hw;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pvv.hw.entity.User;
import br.com.pvv.hw.repository.UserRepository;

@SpringBootApplication
public class HelloSpringApplication {
	
	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
		User a = new User(101, "javatechie", "minhasenha", "eum@email.com");
		User b = new User(102, "otouser", "otasenha", "e2@email.com");
		User c = new User(103, "maisumuser", "dnovo", "uminteiro@email.com");
		User d = new User(104, "againuser", "agorarai", "topatuds@email.com");
		User e = new User(104, "gangss", "12345", "topatuds@email.com");
		List<User> users = Stream.of(a,b,c,e,d).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
