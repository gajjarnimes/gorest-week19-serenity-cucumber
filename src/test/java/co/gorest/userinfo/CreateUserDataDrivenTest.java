package co.gorest.userinfo;

import co.gorest.testbase.TestBase;
import co.gorest.steps.UsersSteps;
import co.gorest.utils.PropertyReader;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
//@Concurrent(threads = "4x")
@UseTestDataFrom("src/test/java/resources/testdata/userinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateUserDataDrivenTest extends TestBase {

    static String token = PropertyReader.getInstance().getProperty("token");

    private String name;
    private String email;
    private String gender;
    private String status;

    @Steps
    UsersSteps usersSteps;

    @Title("Data Driven Test for adding multiple users to the application")
    @Test
    public void createMultipleUser() {
        usersSteps.createUser(name, email, gender, status,token).statusCode(201);


    }

}
