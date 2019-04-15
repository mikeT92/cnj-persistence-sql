package edu.hm.cs.fwp.cloudtrain.core.boundary;

import edu.hm.cs.fwp.cloudtrain.adapter.persistence.GenericRepository;
import edu.hm.cs.fwp.cloudtrain.core.entity.Message;
import edu.hm.cs.fwp.cloudtrain.core.entity.Task;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
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
}
