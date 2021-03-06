package com.shubham.addressBook;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONObject;

public class AddressBookUtility {
	/*This function displays the name of persons available in address book*/
	public void displayName(JSONObject rootObject)
	{
		Set<String> name=rootObject.keySet();
		
		/*Using Iterator Interface For iteration*/
		Iterator iterator=name.iterator();
		
		/*Condition if JSONObject is Empty*/
		if(iterator.hasNext()==false)
		{
			System.out.println("Address Book Empty");
			return;
		}
	    	int index=1;
	    /*Iterating Set for User to Show the available person names*/
	    while(iterator.hasNext())
		{
			System.out.println(index+"---"+iterator.next());
			index+=1;
		}
	    
	}

	/*This function is used to add person details in the address book*/
	public  void addPerson(JSONObject rootObject,PersonDetails personDetails,BufferedReader br) throws NumberFormatException, IOException
	{
		
		/*Initializing PersonDetails Class Object*/        
		System.out.println("Enter first name");
		personDetails.setFirstName(br.readLine());
		System.out.println("Enter last name");
		personDetails.setLastName(br.readLine());
		System.out.println("Enter address");
		personDetails.setAddress(br.readLine());
		System.out.println("Enter city");
		personDetails.setCity(br.readLine());
		System.out.println("Enter State");
		personDetails.setState(br.readLine());
		System.out.println("Enter zip number");
		personDetails.setZip(br.readLine());
		System.out.println("Enter Mobile Number");
		personDetails.setPhoneNumber(br.readLine());
		
		/*Putting all values in JSONObject*/
		JSONObject newObject=new JSONObject();
		newObject.put("firstname", personDetails.getFirstName());
		newObject.put("lastname",personDetails.getLastName());
		newObject.put("address",personDetails.getAddress());
		newObject.put("city",personDetails.getCity());
		newObject.put("state",personDetails.getState());
		newObject.put("zip",personDetails.getZip());
		newObject.put("phoneNumber",personDetails.getPhoneNumber());
		
		/*Putting all values in rootObject JSONObject*/
		rootObject.put(personDetails.getFirstName()+personDetails.getLastName(),newObject);
		
	}

	/*This function will print the root object in old or new address book*/
	public void printRootObject(JSONObject rootObject,int option) throws IOException
	{
		if(option==9)
		{
			FileWriter file =new FileWriter("C:/Users/User/Desktop/final/programming/src/com/shubham/addressBook/addressBook.JSON");
		    file.write(rootObject.toJSONString());
		    file.close();
		}
		else
			if(option==10)
		{
		    FileWriter newFile =new FileWriter("C:/Users/User/Desktop/final/programming/src/com/shubham/addressBook/newAddressBook.JSON");
		    newFile.write(rootObject.toJSONString());
		    newFile.close();
		}
	}

	/*This function will update the details in JSONObject rootObject*/
	public void updateAddressBook(JSONObject rootObject,BufferedReader br) throws IOException
	{
		System.out.println("Enter the name of person you want to update");
		String fullName=br.readLine();
		System.out.println("Enter name you want to update");
		String name=br.readLine();
		System.out.println("Enter details you want to update");
		String updatedName=br.readLine();
		
		/*Updated JSONObject*/
		JSONObject object=(JSONObject) rootObject.get(fullName);
		object.put(name, updatedName);
		
		/*Putting the updated Object in root Object*/
		rootObject.put(fullName, object);
	}

	/*This function will delete the details of a person that user enters*/
	public void deleteDetails(JSONObject rootObject,BufferedReader br) throws IOException
	{
		System.out.println("Enter the name of person you want to delete");
		String nameOfPerson=br.readLine();
		rootObject.remove(nameOfPerson);
		System.out.println(rootObject.toJSONString());
	}

	/*This function will delete specific detail of a person that user Enters*/
	public void deleteSpecificDetails(JSONObject rootObject,BufferedReader br) throws IOException
	{
		System.out.println("Enter the name of person whose details you want to change");
		String nameOfPerson=br.readLine();
		System.out.println("Enter which detail you want to delete");
		String nameOfDetail=br.readLine();
		
		/*logic to remove the particular detail from person name*/
		JSONObject object=(JSONObject) rootObject.get(nameOfPerson);
		object.remove(nameOfDetail);
		rootObject.put(nameOfDetail, object);
	}

	/*This function gives address details in Mailing Label Format*/
	public void addressDetails(JSONObject rootObject,BufferedReader br) throws IOException
	{
	   System.out.println("Enter person name whose address you want to know");
	   String personName=br.readLine();
	   JSONObject object=(JSONObject)rootObject.get(personName);
	   String address=(String)object.get("address");
	   String arr[]=address.split(" ");
	   
	   /*loop for printing in Mailing Label Format*/
	   for(int i=0;i<arr.length;i++)
	   {
		   System.out.println("  "+arr[i]);
	   }
	}

	/*This function gives the specified details that user wants of a person*/
	public void genericDetails(JSONObject rootObject,BufferedReader br) throws IOException
	{
		System.out.println("Enter the person name:");
		String nameOfPerson=br.readLine();
		JSONObject object=(JSONObject)rootObject.get(nameOfPerson);
		Set<String> key=object.keySet();
		String keys="";
		
		/*options after entering person name*/
		Iterator iterator=key.iterator();
		while(iterator.hasNext())
		{
			keys=keys+iterator.next()+" ";
		}
		
		String keyArray[]=keys.split(" ");
		
		/*display options to choose with*/
		int index=1;
		for(int i=0;i<keyArray.length;i++)
		{
			System.out.println("  "+index+"--"+keyArray[i]);
			index+=1;
		}
		
		/*display logic*/
		System.out.println("Enter details you want to know");
		String details=br.readLine();
		String value=(String) object.get(details);
		String detailArray[]=value.split(" ");
		
		for(int i=0;i<detailArray.length;i++)
		{
			System.out.println("  "+detailArray[i]);
		}
	}

	/*Function to print the whole address book in mailing format*/
	public void printWholeAddressBook(JSONObject rootObject)
	{
		Set<String> key=rootObject.keySet();
		
		Iterator iterator=key.iterator();
		int index=1;
		while(iterator.hasNext())
		{
			String nameOfPerson=(String)iterator.next();
			System.out.println(index+"--"+nameOfPerson);
			JSONObject object=(JSONObject)rootObject.get(nameOfPerson);
			
			Set<String> innerKeys=object.keySet();
			Iterator innerIterator=innerKeys.iterator();
			int innerIndex=1;
			while(innerIterator.hasNext())
			{
				String innerKey=(String) innerIterator.next();
				System.out.println("  "+(char)(96+innerIndex)+"--"+innerKey);
				String innerValue=(String) object.get(innerKey);
				String arr[]=innerValue.split(" ");
				for(int i=0;i<arr.length;i++)
				{
					System.out.println("       "+arr[i]);
				}
				innerIndex+=1;
			}
			index+=1;
		}
	}
	
	/*Function to display user choices available*/
	public void displayChoices()
	{
		System.out.println("Select function you want to do:");
		System.out.println();
		System.out.println("1"+"--"+"display name");
		System.out.println("2"+"--"+"add new person details");
		System.out.println("3"+"--"+"delete address of person");
		System.out.println("4"+"--"+"delete specific details");
		System.out.println("5"+"--"+"show address details");
		System.out.println("6"+"--"+"show specific details");
		System.out.println("7"+"--"+"show whole address book");
		System.out.println("8"+"--"+"update details in address book");
		System.out.println("9"+"--"+"save address book");
		System.out.println("10"+"--"+"save in new address book");
		System.out.println("11"+"--"+"exit");
	}
}
