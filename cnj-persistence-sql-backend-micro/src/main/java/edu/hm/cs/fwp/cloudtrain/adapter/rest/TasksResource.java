package edu.hm.cs.fwp.cloudtrain.adapter.rest;

import edu.hm.cs.fwp.cloudtrain.core.boundary.TaskManagement;
import edu.hm.cs.fwp.cloudtrain.core.entity.Task;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * REST endpoint managing {@link Task} entities.
 * <p>
 * Handles only the mapping of a REST invocation to a Java method invocation;
 * all transactional business logic is encapsulated in a {@code Boundary} this resource class delegates to.
 * </p>
 */
@RequestScoped
@Path("v1/tasks")
public class TasksResource {

    @Inject
    private TaskManagement boundary;

    @GET
    public Response getAllTasks() {
        Response result;
        List<Task> found = this.boundary.getAllTasks();
        result = Response.ok(found).build();
        return result;
    }

    @GET
    @Path("{taskId}")
    public Response getTask(@PathParam("taskId") UUID taskId) {
        Response result;
        Task found = this.boundary.getTaskById(taskId);
        if (found != null) {
            result = Response.ok(found).build();
        } else {
            result = Response.status(Response.Status.NOT_FOUND).build();
        }
        return result;
    }

    @POST
    public Response addTask(Task task) {
        Response result;
        UUID taskId = this.boundary.addTask(task);
        URI location = UriBuilder.fromResource(getClass()).path("{taskId}").build(taskId);
        result = Response.created(location).build();
        return result;
    }

    @PUT
    @Path("{taskId}")
    public Response modifyTask(@PathParam("taskId") UUID taskId, Task task) {
        Response result;
        this.boundary.modifyTask(task);
        result = Response.noContent().build();
        return result;
    }

    @DELETE
    @Path("{taskId}")
    public Response removeTask(@PathParam("taskId") UUID taskId) {
        Response result;
        this.boundary.removeTask(taskId);
        result = Response.noContent().build();
        return result;
    }
}
