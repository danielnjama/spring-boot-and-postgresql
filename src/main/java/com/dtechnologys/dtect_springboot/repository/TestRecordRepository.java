package com.dtechnologys.dtect_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dtechnologys.dtect_springboot.model.TestRecord;

public interface TestRecordRepository extends JpaRepository<TestRecord, Long> {
}