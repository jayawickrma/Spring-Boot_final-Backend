package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringLogDao extends JpaRepository <LogEntity,String> {
    @Query(value = "SELECT * FROM monitoringLogServices WHERE logCode = (SELECT logCode FROM vehicle ORDER BY CAST(SUBSTRING(logCode, 6) AS UNSIGNED) DESC LIMIT 1);", nativeQuery = true)
    LogEntity findLastRowNative();
}
