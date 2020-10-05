package testCases;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class XML_Validation_BDD {
	/* given()
	 * 		set cookies, add auth, add params, set header, info etc
	 * when()
	 * 		get, post, put, delete
	 * then()
	 * 		validate status code, extract response, ectract headers, cookies, response body etc
	 * 
	 */
		
  @Test
  public void xmlSingleValidation() {
	 
	  given()
	  .when()
	  	.get("thomas-bayer.com/sqlrest/CUSTOMER/10/")
	  .then()
	  	.body("CUSTOMER.LASTNAME",equalTo("Fuller"));
  }
  
  @Test
  public void xmlMultipleValidations() {
	 
	  given()
	  .when()
	  	.get("thomas-bayer.com/sqlrest/CUSTOMER/10/")
	  .then()
	  	.body("CUSTOMER.LASTNAME",equalTo("Fuller"))
	  	.body("CUSTOMER.FIRSTNAME",equalTo("Sue"))
	  	.body("CUSTOMER.ID",equalTo("10"));
  }
  
  
  @Test
  public void xmlMultipleValidationsInOneGo() {
	 //USE FUNCTION text()
	  given()
	  .when()
	  	.get("thomas-bayer.com/sqlrest/CUSTOMER/10/")
	  .then()
	  	.body("CUSTOMER.text()",equalTo("10SueFuller135 Upland Pl.Dallas"));
  }
  
  @Test
  public void xpathValidation1() {
	 //USE FUNCTION text()
	  given()
	  .when()
	  	.get("http://thomas-bayer.com/sqlrest/INVOICE")
	  .then()
	  	.body(hasXpath("/INVOICEList/INVOICE[text()='30')]"));
  }	
  
}
