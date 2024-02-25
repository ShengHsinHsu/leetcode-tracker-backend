package com.personal.assisent.Hub.repository;

import com.personal.assisent.Hub.entity.postgres.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}
