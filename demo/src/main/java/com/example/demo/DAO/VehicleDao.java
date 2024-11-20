package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao extends JpaRepository<VehicleEntity,String> {
    @Query(value = "SELECT * FROM vehicle WHERE vehicleCode = (SELECT vehicleCode FROM vehicle ORDER BY CAST(SUBSTRING(vehicleCode, 9) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    VehicleEntity findLastRowNative();
}
