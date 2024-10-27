package api.endpoints;

import io.restassured.http.ContentType;


import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.User;

//UserEndPoints.java
//Created for perform (CRUD) Create, Read, Update, Delete requests the user API

/*
 The typical HTTP methods used for CRUD operations are:
   Create: POST (to create a new resource)
   Read: GET (to retrieve a resource)
   Update: PUT (to update an existing resource)
   Delete: DELETE (to remove a resource)
 */


public class UserEndPoints {
	
	public static Response createUser(User payload)
	{
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
		Response response = given()
				.pathParam("username", userName)
		.when()
		    .get(Routes.get_url);
		return response;
	
	}
	
	public static Response updateUser(String userName, User payload)
	{
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username", userName)
		   .body(payload)
		.when()
		    .put(Routes.update_url);
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
