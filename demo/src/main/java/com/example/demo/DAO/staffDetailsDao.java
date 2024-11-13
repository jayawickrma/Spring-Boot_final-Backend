package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.staffDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface staffDetailsDao extends JpaRepository<staffDetailsEntity,String> {
}
