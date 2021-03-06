package com.shubham.stockReport;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StockUtility {

/*This function will add new Stock values*/
public void addStock(JSONObject rootObject,String Id,BufferedReader br,StockValues stockValue) throws IOException
{
	String actualId="Shubham Pandey";
	String companyName;
	if(actualId.equals(Id))
	{
		System.out.println("Enter the following details");
		System.out.println();
		System.out.println("Enter Company Name");
		companyName=br.readLine();
		System.out.println("Enter Stock Name");
		stockValue.setStockNames(br.readLine());
		System.out.println("Enter Number Of Shares");
		stockValue.setNumberOfShares(br.readLine());
		System.out.println("Enter Share Price");
		stockValue.setSharePrice(br.readLine());
	}
	else
	{
		System.out.println("Authentication Failed");
		return;
	}
	JSONObject newObject=new JSONObject();
	newObject.put("stockNames", stockValue.getStockNames());
	newObject.put("numberOfShares", stockValue.getNumberOfShares());
	newObject.put("sharePrice", stockValue.getSharePrice());
	rootObject.put(companyName,newObject);
	
}

/*This function will manage all the transaction records*/
public void purchaseStock(JSONObject rootObject,BufferedReader br,CostumerDetails costumerDetails,DateFormat dateFormat,Date today,JSONObject rootPurchaseObject) throws IOException
{
	System.out.println("Enter Company Stock you want to purchase");
	String companyName=br.readLine();
	
	/*Calling a function asking for Costumer Details*/
	costumerDetails(br, costumerDetails, dateFormat, today);
	
	/*Getting the specified Object for the Entered Company*/
	JSONObject object=(JSONObject) rootObject.get(companyName);
	System.out.println("How much stock you want to purchase");
	String stockNumber=br.readLine();
	String actualStockNumber=(String)object.get("numberOfShares");
	
	/*root object updated after stock is purchased*/
	if(Integer.parseInt(actualStockNumber)>=Integer.parseInt(stockNumber))
	{
		int updatedStock=Integer.parseInt(actualStockNumber)-Integer.parseInt(stockNumber);
		object.put("numberOfShares",updatedStock+"");
	}
	else
		System.out.println("Stocks Sold Out Wait For The Next Updation");
	
	/*logic is to create new JSONObject for purchased stock details*/
	JSONObject newObject=new JSONObject();
	newObject.put("name", costumerDetails.getFullName());
	newObject.put("age", costumerDetails.getAge());
	newObject.put("phoneNumber", costumerDetails.getPhoneNumber());
	newObject.put("nameOfCompany", companyName);
	newObject.put("numberOfStock", stockNumber);
	
	JSONArray array=new JSONArray();
	array.add(newObject);
	
	/*Putting all into our new JSONObject rootPurchaseObject*/
	rootPurchaseObject.put(costumerDetails.getCurrentDate(), array);
	
}

/*This function will ask for Costumer Details*/
public void costumerDetails(BufferedReader br,CostumerDetails costumerDetails,DateFormat dateFormat,Date today) throws IOException
{
	System.out.println("Enter your full name:");
	costumerDetails.setFullName(br.readLine());
	System.out.println("Enter your age");
	costumerDetails.setAge(Integer.parseInt(br.readLine()));
	System.out.println("Enter your phone Number");
	costumerDetails.setPhoneNumber(Long.parseLong(br.readLine()));
	String currentDate = dateFormat.format(today);
	costumerDetails.setCurrentDate(currentDate);
}

/*This function will generate purchase dates and time*/
public void generatePurchaseList(JSONObject rootObject,JSONObject rootPurchaseObject,BufferedReader br) throws IOException
{
	System.out.println("Enter what you want");
	String demand=br.readLine();
	
	if(demand.equals("date"))
	{
		System.out.println("The following purchase stock dates");
		Set<String> keys=rootPurchaseObject.keySet();
		Iterator iterator=keys.iterator();
		while(iterator.hasNext())
		{
			System.out.println("  "+iterator.next());
		}
	}
}

/*This function updates both stock report*/
public void writeDetails(JSONObject rootObject,JSONObject rootPurchaseObject) throws IOException
{
	FileWriter updateFile=new FileWriter("C:/Users/User/Desktop/final/programming/src/com/shubham/stockReport/companyStocks.JSON");
	updateFile.write(rootObject.toJSONString());
	updateFile.close();
	
	FileWriter purchaseFile=new FileWriter("C:/Users/User/Desktop/final/programming/src/com/shubham/stockReport/stockReport.JSON");
	purchaseFile.write(rootPurchaseObject.toJSONString());
	purchaseFile.close();
}

/*This function will create choices for the user*/
public void generateChoices(BufferedReader br,JSONObject rootObject,StockValues stockValue,DateFormat dateFormat,Date today,JSONObject rootPurchaseObject,CostumerDetails costumerDetails) throws NumberFormatException, IOException
{
	System.out.println("Welcome Costumers, Here Are Your Choices");
	System.out.println();
	while(true)
	{
	 makeChoices();
	 int a=Integer.parseInt(br.readLine());
	 switch(a)
	 {
	 case 1:System.out.println("Enter your authentication user name");
	        String Id=br.readLine();
	        addStock(rootObject, Id, br, stockValue);
	        break;
	 case 2:purchaseStock(rootObject, br, costumerDetails, dateFormat, today, rootPurchaseObject);    
	        break;
	 case 3:generatePurchaseList(rootObject, rootPurchaseObject, br);    
	        break;
	 case 4:writeDetails(rootObject, rootPurchaseObject);
	        break;
	 case 5:System.out.println("Thanks for showing your interest");
		    return;
	 default:System.out.println("Entered Wrong Value");
	 }
	}
}

/*This function will provide costumer to choose*/
public void makeChoices()
{
	System.out.println("1"+"--"+"addStock");
	System.out.println("2"+"--"+"purchaseStock");
	System.out.println("3"+"--"+"generate Purchase List");
	System.out.println("4"+"--"+"save");
	System.out.println("5"+"--"+"exit");
}
}
