package co.gorest.steps;

import co.gorest.constants.EndPoints;
import co.gorest.model.PostsPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostsSteps {
    @Step("Create post for userId:{0},title:{1},body:{2}")
    public ValidatableResponse createPost(int userId, int user_id, String title, String body, String token){
        PostsPojo postsPojo = PostsPojo.getRequestBody(userId,title,body);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer"+token)
                .pathParam("userId",userId)
                .body(postsPojo)
                .when()
                .post(EndPoints.CREAT_POST)
                .then();
    }
    @Step("Get Post by postId:{0}")
    public ValidatableResponse getPostByID(int postID,String token){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer"+token)
                .pathParam("postID",postID)
                .when()
                .get(EndPoints.GET_POST_BY_ID)
                .then();
    }
    @Step("Update post By postId:{0}")
    public ValidatableResponse updatePost(int postID,int userId,String title,String body,String token){
        PostsPojo postsPojo = PostsPojo.getRequestBody(userId,title,body);
        return SerenityRest.given().log().all()
        .contentType(ContentType.JSON)
                .header("Authorization","Bearer"+token)
                .pathParam("userId",userId)
                .body(postsPojo)
                .when()
                .patch(EndPoints.UPDATE_POST_BY_ID)
                .then();
    }
    @Step("Delete post by postId:{0}")
    public ValidatableResponse deletePost(int usrID,String token){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer"+token)
                .pathParam("userID",usrID)
                .when()
                .delete(EndPoints.DELETE_POST_BY_ID)
                .then();
    }

}
