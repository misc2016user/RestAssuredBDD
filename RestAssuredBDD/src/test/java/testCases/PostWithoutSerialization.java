package testCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
/* reuest payload
 * {"name":"kashif",
	"jobs":"sdt",
	"salary":3000,
	"course":[
    "java",
    "selenium"
    ]
	}
 * 
 * 
 * 
 */
public class PostWithoutSerialization {
	
	HashMap params= new HashMap();
	
    
	  @BeforeClass
	  public void setUpTestData() {
	  RestAssured.baseURI="https://reqres.in/api";
	  RestAssured.basePath="/users";
	  
	  ArrayList<String>courses= new ArrayList<String>();
	  courses.add("Java");
	  courses.add("Selenium");
	       
	  params.put("name", "Kashif");
	  params.put("job","SDET");
	  params.put("salary","1000");
	  params.put("courses", courses);
	  }
	
  @Test
  public void postWithoutSerialization() {
	  	given()
			.contentType("Application/json")
			.body(params)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201) 
			.body("name",equalTo("Kashif"))
			.body("job",equalTo("SDET"))
			.body("salary",equalTo("1000"))
			.log().all();  

	    }
}
