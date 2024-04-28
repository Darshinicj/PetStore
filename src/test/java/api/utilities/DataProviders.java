package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Data")//this is defined with data provider annotation
	public String[][] getAllData() throws IOException//get all the data from excel sheet
	{
		//this method is responsible for generating and passing the data to another test method
		String path=System.getProperty("user.dir")+"//testData//UserData.xlsx";//we are  getting the file in the path 
		//here System.getProperty it gives the current project path
		XLUtility x1=new XLUtility(path);//we are creating the object for utility
		//Here we are referring XLUtility method
		int rownum=x1.getRowCount("Sheet1");//here we pass only sheet no.
		int colcount=x1.getCellCount("Sheet1",1);//here we need to pass sheet no. and rownum
		
		String apidata[][]=new String[rownum][colcount];//here we are creating 2-d array by passing rowno. and colno.
				
		
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=x1.getCellData("Sheet1",i,j);//this get the data from the sheet and assign the same to the array 
				}
		}
		return apidata;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException//get only username
	{
		String path=System.getProperty("user.dir")+"//testData//UserData.xlsx";
		XLUtility x1=new XLUtility(path);
		
		int rownum=x1.getRowCount("Sheet1");
		
		String apidata[]=new String[rownum];
		
	
		for(int i=1;i<rownum;i++)
		{
			apidata[i-1]=x1.getCellData("Sheet1",i,1);
		}
		return apidata;
	}
	

}
