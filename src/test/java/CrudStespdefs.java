import co.gorest.steps.UsersSteps;
import co.gorest.utils.PropertyReader;
import co.gorest.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.mockito.Matchers;

import java.util.HashMap;

import static org.mockito.Matchers.contains;

public class CrudStespdefs {
    static int userId;
    static String name=null;
    static ValidatableResponse response;
    static String token = PropertyReader.getInstance().getProperty("token");
    @Steps

    UsersSteps usersSteps;

    @Given("^URL is given$")
    public void urlIsGiven() {
    }

    @When("^I create user with name\"([^\"]*)\"gender\"([^\"]*)\"email\"([^\"]*)\"status\"([^\"]*)\"$")
    public void iCreateUserWithNameGenderEmailStatus(String name, String gender, String email, String status)  {
        name=name+ TestUtils.getRandomValue();
        email=TestUtils.getRandomValue()+email;
        response=  usersSteps.createUser(name,gender,email,status,token);

    }

    @Then("^I verify that user is created with\"([^\"]*)\"$")
    public void iVerifyThatUserIsCreatedWith(String name) {
        response.statusCode(201);
        userId=response.log().everything().extract().body().path("id");
        System.out.println(userId);
    }

    @And("^I update user with userId name\"([^\"]*)\" gender\"([^\"]*)\"email\"([^\"]*)\"status\"([^\"]*)\"$")
    public void iUpdateUserWithUserIdNameGenderEmailStatus(String name1, String gender, String email, String status)  {
        name=name1+ "_add";
        email = TestUtils.getRandomValue()+email;
        response = usersSteps.updateUser(name,gender,userId,email,status,token);
    }

    @And("^I check user is updated successfully$")
    public void iCheckUserIsUpdatedSuccessfully() {
        response.statusCode(200);
    }

    @And("^I delete user with userId$")
    public void iDeleteUserWithUserId() {
        response= usersSteps.deleteUser(userId,token).statusCode(202);
    }

    @Then("^I verify that user is deleted successfully$")
    public void iVerifyThatUserIsDeletedSuccessfully() {
        response=usersSteps.getUserByID(userId,token);
    }
    }

