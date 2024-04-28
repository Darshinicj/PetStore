package api.endpoints;

/*
Swagger URI ---> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/username
Update user (Put) :https://petstore.swagger.io/v2/user/username
Delete user (Delete) : https://petstore.swagger.io/v2/user/username
*/
public class Routes {

	
	//Routes contains only url's

	  public static String	base_url="https://petstore.swagger.io/v2";
	  //Public: we can access anywhere in the project
	  //Static: we can access directly by using the class name without using the object
	  //since url's is a string type
	  
	  //User Module
	  public static String post_url=base_url+"/user";
	  public static String get_url=base_url+"/user/{username}";
	  public static String update_url=base_url+"/user/{username}";
	  public static String delete_url=base_url+"/user/{username}";
	  
	  //Store Module
	  
	           //Here u will create Store module url's
	/*  public static String Storpost_url=base_url+"/store/placeOrder";
	  public static String Storget_url=base_url+"/store/getInventory";
	  public static String Stordelete_url=base_url+"/store/deleteOrder";*/
	  //Pet Module
	  
	           //Here u will create pet module url's
	/*  public static String petpost_url=base_url+"/pet/addPet";
			  public static String petget_url=base_url+"/pet/getPetById";
			  public static String petupdate_url=base_url+"/pet/getPetById";
			  public static String petdelete_url=base_url+"/pet/deletePet";*/
	  
}
