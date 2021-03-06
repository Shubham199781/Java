package com.shubham.inventoryManagementProgram;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InventoryUtility {
	
	/*This method will show the list of inventories available for user*/
	public  void listOfInventories(JSONObject rootObject,InventoryValues inventoryValues ) throws IOException
	{
		Scanner s=new Scanner(System.in);
		System.out.println("The Inventories Available Are:");
		System.out.println("1)"+"---"+"Rice");
		System.out.println("2)"+"---"+"Wheat");
		System.out.println("3)"+"---"+"Pulses");
		
		System.out.println("Press 0 if you want to add or Press 9 if want to Purchase");
		int a=s.nextInt();
		if(a==0||a==9)
		{
			addOrPurchase(a,rootObject, inventoryValues);
		}
		else
		{
			System.out.println("Entered option is wrong");
		}
	}
	
	/*This method will add or update the value of inventories according to users choice*/
	public void addOrPurchase(int a,JSONObject rootObject,InventoryValues inventoryValues) throws IOException
	{
		Scanner s=new Scanner(System.in);
		if(a==0)
		{
			/*here we created an object of InventoryValues class*/
			System.out.println("Enter name of inventory you want to add:");
			String nameOfInventory=s.next();
			System.out.println("Enter name of"+" "+nameOfInventory);
			inventoryValues.setName(s.next());
			System.out.println("Enter weight of"+" "+inventoryValues.getName());
			inventoryValues.setWeight(s.next());
			System.out.println("Enter price of"+" "+inventoryValues.getName());
			inventoryValues.setPrice(s.nextInt());
			
			/*calling method for creating a new JSONObject*/
			createNewObject(rootObject, inventoryValues, nameOfInventory);
		}
		else
			if(a==9)
			{
				System.out.println("Enter name of inventory you want to purchase:");
				String nameOfInventory=s.next();
				System.out.println("Options you are having in"+" "+nameOfInventory);
				System.out.println(rootObject.get(nameOfInventory));
				System.out.println("Enter the name of rice you want to purchase");
				String typeOfInventory=s.next();
				System.out.println("Enter the amount of rice you want to purchase");
				int amount=s.nextInt();
				
				/*calling method for updating a new JSONObject */
				updateObject(nameOfInventory, typeOfInventory, amount, rootObject);
			}
	}

	/*This method will create new Object when user will opt for adding new inventories*/
	public  void createNewObject(JSONObject rootObject,InventoryValues inventoryValues,String nameOfInventory)
	{
		/*here we created a new JSONObject*/
		JSONObject newObject=new JSONObject();
		newObject.put("name", inventoryValues.getName());
		newObject.put("weight",inventoryValues.getWeight());
		newObject.put("price", inventoryValues.getPrice());
		
		JSONArray rootArray=(JSONArray)rootObject.get(nameOfInventory);
		/*here we are adding the new JSONObject into our rootArray*/
		rootArray.add(newObject);
	    
	}
    
	/*This method will print updated JSONObject in the specified location*/
	public  void printRootObject(JSONObject rootObject) throws IOException
	{
		FileWriter file=new FileWriter("C:/Users/User/Desktop/final/programming/src/com/shubham/inventoryManagementProgram/inventoryDetails.json");
		file.write(rootObject.toJSONString());
		file.close();
		System.out.println("Details Are Written Succesfully In JSON file");
	}
	
	/*This method will update the Object when user chooses to purchase inventory from available inventory*/
	public  void updateObject(String nameOfInventory,String typeOfInventory,int amount,JSONObject rootObject) throws IOException
	{
		JSONArray objectArray=(JSONArray)rootObject.get(nameOfInventory);
		
		/*loop for traversing JSONArray*/
		for(int i=0;i<objectArray.size();i++)
		{
			JSONObject object=(JSONObject) objectArray.get(i);
			if(((String) object.get("name")).equals(typeOfInventory))
			{
				String availableWeight=(String) object.get("weight");
				int actualWeight=Integer.parseInt(availableWeight);
				if(actualWeight>=amount)
				{
					int updatedWeight=actualWeight-amount;
					object.put("weight", updatedWeight+"");
					break;
				}
			}
			else
			{
				System.out.println("Inventory Sold Out");
			}
		}
		
		/*Calling method for printing updated JSONObject*/
		printRootObject(rootObject);
	}
}
