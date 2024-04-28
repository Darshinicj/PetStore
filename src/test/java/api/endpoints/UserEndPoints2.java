package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//this is to read the data from property file
public class UserEndPoints2 {

	//we need to create additional method which will load properties file
	//In java, we have resource bundle by using that we can load property file and read it
	
	//method created for getting url's from property file
	static ResourceBundle getURL()
	 {
		 ResourceBundle routes= ResourceBundle.getBundle("routes");//Load the property file//name of the properties file 
	     return routes;
	 }
	 
	 
	 public static Response CreateUser(User payload){
		 //This is the implementation of CreateUserEndpoint
	    	
		//here we need to call the post url's 
		String post_url = getURL().getString("post_url");
		
	    Response response = given()
	    	  .contentType(ContentType.JSON)
	    	  .accept(ContentType.JSON)
	    	  .body(payload)
	    	  
	    	.when()
	    	 .post(post_url);
	        return response;
	 }	
	    
	    public static Response readUser(String userName)
	    {
	    	String get_url=getURL().getString("get_url");
	    	
	    Response response = given()
		     .pathParam("username",userName)
		    	  
		    	.when()
		    	 .get(get_url);
		    
		    return response;
	    }
	    
	    public static Response updateUser(String userName, User payload)
	    {
	    	String update_url=getURL().getString("update_url");
		    Response response = given()
			     .contentType(ContentType.JSON)
		    	  .accept(ContentType.JSON)
		    	  .pathParam("username",userName) 
		    	    .body(payload)
		    	    
			    	.when()
			    	 .put(update_url);
		
			    
			    return response;
		    }
	    

	    public static Response deleteUser(String userName)
	    {
	    	String delete_url=getURL().getString("delete_url");
	    Response response = given()
		     .pathParam("username",userName)
		    	  
		    	.when()
		    	 .delete(delete_url);
		    
		    return response;
	    }
		    
}
