package web.skietapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.skietapp.model.Skieet;

public interface SkieetRepository extends JpaRepository<Skieet, Long> {

	List<Skieet> findAllByUserId(long id);
	List<Skieet> findAllByUserUserName(String name);
}
