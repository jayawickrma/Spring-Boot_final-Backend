package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentDao extends JpaRepository<EquipmentEntity,String> {
}
