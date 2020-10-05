package testCases;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class GetTestBDD {
	/* given()
	 * 		set cookies, add auth, add params, set header, info etc
	 * when()
	 * 		get, post, put, delete
	 * then()
	 * 		validate status code, extract response, ectract headers, cookies, response body etc
	 * 
	 */
		
  @Test
  public void getTestBDD() {
	 
	  given()
	  .when()
	  	.get("https://reqres.in/api/users")
	  .then()
	  	.statusCode(200);
  }
}
