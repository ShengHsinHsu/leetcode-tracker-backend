package com.personal.assisent.Hub.repository;

import com.personal.assisent.Hub.entity.postgres.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecordRepository extends JpaRepository<Record, UUID> {
}
