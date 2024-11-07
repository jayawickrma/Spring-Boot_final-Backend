package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao extends JpaRepository<VehicleEntity,String> {
}
