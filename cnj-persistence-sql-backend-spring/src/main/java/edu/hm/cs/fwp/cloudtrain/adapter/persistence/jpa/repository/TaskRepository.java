package edu.hm.cs.fwp.cloudtrain.adapter.persistence.jpa.repository;

import edu.hm.cs.fwp.cloudtrain.core.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
