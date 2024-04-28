package api.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class Usertests {
	
	Faker faker;
	User userPayload;
	
	public Logger logger;//created the variable for log
	
	@BeforeClass
	public void setupData()
	//First, We need to setup the data by using pojo before sending the postUser
	{
		//Here by using Faker we have setup the data which include id, username,email and so on
		faker = new Faker();
		userPayload= new User();	
		//Here API is not automatically generating id but we are creating id using this faker library
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
	    logger= LogManager.getLogger(this.getClass());
	    logger.debug("debugging..........");
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("************ Creating user***********");//logging some info to the log file
		//In post user we have call  the Created user method from user endpoints by passing the payload
		Response response=UserEndPoints.CreateUser(userPayload);
		response.then().log().all();//we are printing all the log here
		Assert.assertEquals(response.getStatusCode(),200);//we have added assertion and we have add only status so we can add more no. of other validation like json response, json data validation and so on.
	   
		logger.info("**************user is created**********");
	
	}
   
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("************ Reading user Info ***********");                                                                                                                                    
        Response response=UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	
		logger.info("************ user info is displayed ***********");
	}
	
	
	@Test(priority=2)
	public void testUpdateUserByName()
	{
		
		logger.info("************ Updating the user***********");
		//Update data using payload
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		
		
		
		Response response=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		/*response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);*/
		//this can also done as following
		
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		logger.info("************ user  updated ***********");
		//Checking after data update
		
		Response responseAfterUpdate=UserEndPoints.readUser(this.userPayload.getUsername());
        
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		
		
	}
	
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info("************Deleting user***********");
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("************ user deleted***********");
	}
	
	
}
