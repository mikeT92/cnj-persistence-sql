package edu.hm.cs.fwp.cloudtrain.core.boundary;

import edu.hm.cs.fwp.cloudtrain.adapter.persistence.jpa.repository.GenericRepository;
import edu.hm.cs.fwp.cloudtrain.core.entity.Task;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * Simple {@code Boundary} that manages {@code Task} entities.
 */
@Stateless
@RolesAllowed("CLOUDTRAIN_USER")
public class TaskManagement {

    @Inject
    private GenericRepository repository;

    @NotNull
    public UUID addTask(@NotNull @Valid Task newTask) {
        newTask.setId(UUID.randomUUID());
        this.repository.addEntity(newTask);
        return newTask.getId();
    }

    public void modifyTask(@NotNull @Valid Task modifiedTask) {
        this.repository.setEntity(modifiedTask);
    }

    public Task getTaskById(@NotNull UUID taskId) {
        return this.repository.getEntityById(Task.class, taskId);
    }

    public void removeTask(@NotNull UUID taskId) {
        this.repository.removeEntityById(Task.class, taskId);
    }

    public List<Task> getAllTasks() {
        return this.repository.queryEntities(Task.class, Task.QUERY_ALL, null);
    }
}
