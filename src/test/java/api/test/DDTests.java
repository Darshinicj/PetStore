package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests//DataDrivenTests
{
//Here we are creating two data driven test
	//first we are creating multiple user by sending post request, here we are using 1st data provider method
	//Second thing we are using only username in the data provider method and we are going to delete the user, Here we are using 2nd data provider method
   
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostuser(String UserId,String UserName,String FirstName, String LastName, String Email,String Password)//same order as in the excel sheet
    {
		//this is the post request which will read the data from the excel
    	User userPayload=new User();
    	
    	userPayload.setId(Integer.parseInt(UserId));
    	userPayload.setUsername(UserName);
    	userPayload.setFirstname(FirstName);
    	userPayload.setLastname(LastName);
    	userPayload.setEmail(Email);
    	userPayload.setPassword(Password);
   
    	
    	Response response=UserEndPoints.CreateUser(userPayload);
		/*response.then().log().all(); here log is not required which will create so much of data*///we are printing all the log here
		Assert.assertEquals(response.getStatusCode(),200);
    	
    }
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)//Here we need refer dataprovider usernameand it is Under Dataproviderclass
	public void testDeleteUserByName(String UserNames)
	{
		   Response response=UserEndPoints.deleteUser(UserNames);
			Assert.assertEquals(response.getStatusCode(),200);
	}

}
