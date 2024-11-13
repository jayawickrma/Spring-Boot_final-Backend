package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDao extends JpaRepository<UserEntity,String> {
}
