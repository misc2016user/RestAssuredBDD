package testCases;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class ResponseValidationsBDD {
	/* given()
	 * 		set cookies, add auth, add params, set header, info etc
	 * when()
	 * 		get, post, put, delete
	 * then()
	 * 		validate status code, extract response, ectract headers, cookies, response body etc
	 * 
	 */
		
  @Test
  public void statusCodevalidation() {
	 
	  given()
	  .when()
	  	.get("https://reqres.in")
	  .then()
	  	.statusCode(200)
	  	.log().all();
  }
  
  @Test
  public void testMultipleContents() {
	 
	  given()
	  .when()
	  	.get("https://reqres.in/api/users")
	  .then()
	  	.body("data.first_name",hasItems("George","Janet"))
	  	.log().all();
  }
  
  @Test
  public void testSpecificContent() {
	 
	  given()
	  .when()
	  	.get("https://reqres.in/api/users/1")
	  .then()
	  	.body("ad.company",equalTo("StatusCode Weekly"))
	  	.log().all();
  }
  
  @Test
  public void includeParams() {
	 
	  given()
	  	 .header("myheader","header value")
	  	 .param("my params","para")
	  .when()
	  	.get("https://reqres.in/api/users/1")
	  .then()
	  	.body("ad.company",equalTo("StatusCode Weekly"))
	  	.log().all();
  }
  
}
