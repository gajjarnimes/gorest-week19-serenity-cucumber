package co.gorest.steps;

import co.gorest.constants.EndPoints;
import co.gorest.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;


public class UsersSteps {
    @Step("Creating user with name:{0},email:{1},gender:{2},status:{3}")
    public ValidatableResponse createUser(String name, String email, String gender, String status, String token) {
        UserPojo userPojo = UserPojo.getRequestBody(name, gender, email, status);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(userPojo)
                .when()
                .post(EndPoints.CREATE_USER)
                .then();
    }

    @Step("Get user info by userId:{0}")
    public ValidatableResponse getUserByID(int userID, String token) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .pathParam("userID", userID)
                .when()
                .get(EndPoints.GET_USER_BY_ID)
                .then();
    }

    @Step("Update user details with name:{0},gender:{1},userid:{2},email:{3},status:{4}")
    public ValidatableResponse updateUser(String name, String gender, int userID, String email, String status, String token) {
        UserPojo userPojo = UserPojo.getRequestBody(name, gender, email, status);
        return SerenityRest.given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer" + token)
                .pathParam("userID", userID)
                .body(userPojo)
                .when()
                .patch(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }

    @Step("Delete User with userId:{0}")
    public ValidatableResponse deleteUser(int userID, String token) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .pathParam("userID", userID)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }
}

