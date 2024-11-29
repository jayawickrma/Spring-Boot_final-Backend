package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.CropEntity;
import com.example.demo.Entity.IMPL.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipmentDao extends JpaRepository<EquipmentEntity,String> {
    @Query(value = "SELECT * FROM equipment WHERE equipment_code = (SELECT equipment_code FROM equipment ORDER BY CAST(SUBSTRING(equipment_code, 11) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    EquipmentEntity findLastRowNative();
    @Query(value = "SELECT * FROM equipment ORDER BY CAST(SUBSTRING(equipment_code, 11) AS UNSIGNED);",nativeQuery = true)
    @Override
    List<EquipmentEntity> findAll();
}
