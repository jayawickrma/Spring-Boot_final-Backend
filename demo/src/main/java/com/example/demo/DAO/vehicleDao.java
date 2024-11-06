package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface vehicleDao extends JpaRepository<VehicleEntity,String> {
}
