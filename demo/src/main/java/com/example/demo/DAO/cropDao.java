package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.cropEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cropDao extends JpaRepository<cropEntity,String> {
}
