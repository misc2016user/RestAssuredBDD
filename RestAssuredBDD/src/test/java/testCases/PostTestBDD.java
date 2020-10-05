package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssuredBDD.utilities.RestUtils;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class PostTestBDD {
  	  
	//Reading testdata from Restutils
    String name=RestUtils.getRandomName();
    String salary=RestUtils.getRandomSalary();
    String job=RestUtils.getRandomJob();
    HashMap<String,String>params= new HashMap<String,String>();
    
	  @BeforeClass
	  public void setUpTestData() {
	  RestAssured.baseURI="https://reqres.in/api";
	  RestAssured.basePath="/users";
	       
	  params.put("name", "Kashif"+name);
	  params.put("job","SDET"+ job);
	  params.put("salary", salary);
	  }
	  
	  @Test
	  public void postTestBDD() {
	  given()
	  		.contentType("Application/json")
	  		.body(params)
	  		
	  .when()
	  		.post()
	  .then()
	  		.statusCode(201) 
	  		.body("name",equalTo("Kashif"+name))
	  		.body("job",equalTo("SDET"+job))
	  		.body("salary",equalTo(salary));  
	  
  }
}
