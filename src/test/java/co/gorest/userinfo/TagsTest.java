package co.gorest.userinfo;

import co.gorest.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)

public class TagsTest extends TestBase {
    @WithTag("userfeature:NEGATIVE")
    @Title("Provide a 404 status code when Authentication failed to access resource")
    @Test
    public void invalidMethod(){
        SerenityRest.rest().given()
                .header("Authorization","Bearer 4b23cf2956abd9c30acd1ed39e644dd4716c8a85c1a6acde3b4f5070bd79f4b3")
                .when()
                .patch("/users")
                .then()
                .statusCode(404)
                .log().all();
    }
    @WithTags({
            @WithTag("userfeature:SMOKE"),
            @WithTag("userfeature.POSITIVE")
    })
    @Title("This test will verify if a status code 200 is returned for GET request")
    @Test
    public void verifyIFTheStatusCodeIs200(){
        SerenityRest.rest().given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }
    @WithTag("userfeature:NEGATIVE")
    @Title("This test will show an error code 0f 404 when user tries to access invalid resource")
    @Test
    public void InValidResource(){
        SerenityRest.rest().given()
                .when()
                .get("/users11")
                .then()
                .statusCode(404)
                .log().all();
    }

}
