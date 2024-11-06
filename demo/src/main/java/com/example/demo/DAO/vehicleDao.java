package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.vehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface vehicleDao extends JpaRepository<vehicleEntity,String> {
}
