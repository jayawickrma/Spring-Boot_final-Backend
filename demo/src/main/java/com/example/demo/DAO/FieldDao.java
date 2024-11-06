package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.fieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldDao extends JpaRepository<fieldEntity,String> {
}
