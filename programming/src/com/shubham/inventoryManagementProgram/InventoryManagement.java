package com.shubham.inventoryManagementProgram;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class InventoryManagement {
public static void main(String[] args) throws Exception {
	/*first we are reading data from JSON file*/
    FileReader file=new FileReader("C:/Users/User/Desktop/final/programming/src/com/shubham/inventoryManagementProgram/inventoryDetails.json");
	
    JSONParser jsonparser=new JSONParser();
	Object object=jsonparser.parse(file);
	
	/*TypeCasting object to JSON Object*/
	JSONObject rootObject=(JSONObject)object;
	
	/*Creating InventoryValues Class Object */
	InventoryValues inventoryValues=new InventoryValues();
	
	/*Creating InventoryUtility Class Object*/
	InventoryUtility inventoryUtility=new InventoryUtility();
	
	/*This method will show options to the user*/
	inventoryUtility.listOfInventories(rootObject,inventoryValues);
	
	/*This method is used for Updating the JSONFile*/
	inventoryUtility.printRootObject(rootObject);
	
    }
}