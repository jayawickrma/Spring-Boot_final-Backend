package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.MonitoringLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoringLogDao extends JpaRepository <MonitoringLogEntity,String> {
}
