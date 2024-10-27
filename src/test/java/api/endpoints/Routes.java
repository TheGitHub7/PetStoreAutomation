package api.endpoints;


//Swagger URI ---> https://petstore.swagger.io

/*
 Create user(Post) : https://petstore.swagger.io/v2/user
 Get user(Get) : https://petstore.swagger.io/v2/user/{username}
 Update user(Put) : https://petstore.swagger.io/v2/user/{username}
 Delete user(Delete) : https://petstore.swagger.io/v2/user/{username}
 
 */

public class Routes {
	
	
	public static String base_url = "https://petstore.swagger.io/v2/user";
	
	//User Module
	public static String post_url = base_url; // For creating a user
	public static String get_url = base_url + "/{username}"; // For getting a user
	public static String update_url = base_url + "/{username}"; // For updating a user
	public static String delete_url = base_url + "/{username}"; // For deleting a user

	
	//Store module
	//Pet module
	
	
	
	
	
	
	

}
