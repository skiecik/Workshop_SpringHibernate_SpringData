package web.skietapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.skietapp.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

	List<Message> findAllBySenderIdOrderBySendDesc(long id);
	List<Message> findAllByRecieverIdOrderBySendDesc(long id);
}
