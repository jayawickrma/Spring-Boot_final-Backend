package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cropDao extends JpaRepository<CropEntity,String> {
}
