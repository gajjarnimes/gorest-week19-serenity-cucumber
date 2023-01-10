package co.gorest;

import co.gorest.steps.PostsSteps;
import co.gorest.testbase.TestBase;
import co.gorest.utils.PropertyReader;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
@UseTestDataFrom("src/test/java/resources/testdata/postinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class PostDataDrivenTest extends TestBase {

    static String token = PropertyReader.getInstance().getProperty("token");

    private int id;
    private int user_id;
    private String title;
    private String body;

    @Steps
    PostsSteps postsSteps;
    @Title("Data Driven Test for adding multiple post to the application")
    @Test
    public void createMultiplePost(){
        postsSteps.createPost(id,user_id,title,body,token).statusCode(201);
    }


}
