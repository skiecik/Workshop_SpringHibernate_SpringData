package web.skietapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.skietapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
