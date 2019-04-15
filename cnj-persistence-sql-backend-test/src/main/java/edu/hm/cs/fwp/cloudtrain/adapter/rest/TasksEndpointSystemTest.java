package edu.hm.cs.fwp.cloudtrain.adapter.rest;

import edu.hm.cs.fwp.cloud.common.test.adapter.rest.RestAssuredSystemTestFixture;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.startsWith;

/**
 * System test that verifies that the REST endpoint works as expected.
 * <p>
 * Assumes that a remote server hosting the REST endpoint is up and running.
 * </p>
 */
public class TasksEndpointSystemTest {

    private static final RestAssuredSystemTestFixture fixture = new RestAssuredSystemTestFixture();

    private final List<String> trashBin = new ArrayList<>();

    @BeforeAll
    public static void onBeforeClass() {
        fixture.onBefore();
    }

    @AfterAll
    public static void onAfterClass() {
        fixture.onAfter();
    }

    @AfterEach
    public void onAfter() {
        for (String current : this.trashBin) {
            try {
                given().auth().oauth2(fixture.getAccessToken()).delete(current);
            } catch (Exception ex) {
                // we don't care and continue
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void postWithValidTaskReturns201AndLocation() {
        Response postResponse = given().auth().oauth2(fixture.getAccessToken())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(createTask().toString())
                .post("api/v1/tasks")
                .andReturn();
        String location = postResponse.header("location");
        if (location != null) {
            this.trashBin.add(location);
        }
        postResponse.then().assertThat()
                .statusCode(201);
    }

    private JsonObject createTask() {
        return Json.createObjectBuilder()
                .add("subject", "test")
                .add("description", "this is a test instance")
                .add("category", "NEW_FEATURE")
                .add("priority", "MEDIUM")
                .add("affectedProjectId", "fwpss2019")
                .add("affectedApplicationId", "cnj-persistence-sql")
                .build();
    }
}
