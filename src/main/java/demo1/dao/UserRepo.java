package demo1.dao;

import demo1.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepo extends PagingAndSortingRepository<User,Long> {
     User findByUsername(String username);
     List<User> findAll();
}
