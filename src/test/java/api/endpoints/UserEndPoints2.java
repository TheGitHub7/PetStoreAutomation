package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;


//UserEndPoints.java
//Create for perform Create, Read, Update, Delete requests the user API.
public class UserEndPoints2 {
	
	
	//Method created for getting URL's from properties file
	static ResourceBundle getURL()
	{
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");//Load properties file
		
		return routes;
		
	}
	
	
	public static Response createUser(User payload)
	{
		String post_url=getURL().getString("post_url");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(Routes.post_url);
		
		
		return response;
		
	}
	
	public static Response readUser(String userName)
	{
		String get_url=getURL().getString("get_url");
		Response response =  given()
		.pathParam("username",userName)
		.when()
		.get(Routes.get_url);
		return response;
		
	}
	
	public static Response updateUser(String userName, User payload)
	{
		
		String update_url = getURL().getString("update_url");
		
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(Routes.post_url);
		return response;
		
	}
	
	public static Response deleteUser(String userName)
	{
		Response response = given()
				.pathParam("username", userName)
		   .when()
		    .delete(Routes.delete_url);
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
