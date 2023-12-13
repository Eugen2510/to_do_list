package com.goit.eugene.to_do_list.repository;

import com.goit.eugene.to_do_list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
