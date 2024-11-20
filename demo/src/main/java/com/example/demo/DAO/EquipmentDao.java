package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EquipmentDao extends JpaRepository<EquipmentEntity,String> {
    @Query(value = "SELECT * FROM equipment WHERE equipment_code = (SELECT equipment_code FROM equipment ORDER BY CAST(SUBSTRING(equipment_code, 5) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    EquipmentEntity findLastRowNative();
}
