package br.com.pvv.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pvv.hw.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);

}
