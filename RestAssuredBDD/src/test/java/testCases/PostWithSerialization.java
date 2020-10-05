package testCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PostWithSerialization {
  @Test(priority=1)
  public void postWithSerialization() {
	  PostWithSerialization_Helper obj = new PostWithSerialization_Helper();
	  
	  obj.setname("fatima");
	  obj.setjob("teacher");
	  
	  ArrayList<String> subjects= new ArrayList<String>();
	  subjects.add("Jva");
	  subjects.add("selenium");
	  
	  obj.setCourses(subjects);
	  
	  
	  given()
		.contentType("Application/json")
		.body(obj)
	.when()
		.post("https://reqres.in/api/users")
	.then()
		.statusCode(201) 
		.assertThat().body("name",equalTo("fatima"))
		.assertThat().body("job",equalTo("teacher"))
		.assertThat().body("courses",hasItems("Jva"))
		.log().all();  

	  
  }
  
  @Test(priority=2)
  public void getWithDeSerialization() {
	  //I DONT HAVE A GOOD API WHICH WILL CREATE RECORD ON POST , SO THIS TEST WILL FAIL
	  PostWithSerialization_Helper obj2=
		get("https://reqres.in/api/users/2").as(PostWithSerialization_Helper.class);
	  
	  Assert.assertEquals(obj2.name, "fatima");
				
  }
  
  
}
