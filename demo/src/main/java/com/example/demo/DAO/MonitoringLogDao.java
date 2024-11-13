package com.example.demo.DAO;

import com.example.demo.Entity.IMPL.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoringLogDao extends JpaRepository <LogEntity,String> {
}
