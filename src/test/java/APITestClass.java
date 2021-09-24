import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class APITestClass {

    @Test
    public void test() {
        given().get("https://jsonplaceholder.typicode.com/users").then().assertThat().body("size()", equalTo(10));
    }
}
