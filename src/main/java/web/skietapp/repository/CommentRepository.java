package web.skietapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.skietapp.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findAllBySkieetId(long id);
	List<Comment> findFirst5BySkieetIdOrderByCreatedDesc(long id);
}
