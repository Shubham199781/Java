package com.shubham.addressBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddressBookManagement {
public static void main(String[] args) throws IOException, ParseException {
	
	/*FileReader is used to read the JSONFile*/
	FileReader file=new FileReader("C:/Users/User/Desktop/final/programming/src/com/shubham/addressBook/addressBook.JSON");
	JSONParser parser=new JSONParser();
	
	/*Converting into Object*/
	Object object=parser.parse(file);
    JSONObject rootObject=(JSONObject)object;
    
    /*Creating an Object of PersonDetails Class*/
    PersonDetails personDetails=new PersonDetails();
   
    /*Created BufferReader Object to take input from the user*/
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    /*Created AddressBookUtility Class Object*/
    AddressBookUtility addressBook=new AddressBookUtility();
    
    System.out.println("Welcome To The Address Book");
    while(true)
    { 
    addressBook.displayChoices();
    System.out.println();
    System.out.println("Select number you want to choose");
    int choice=Integer.parseInt(br.readLine());
    
     switch(choice)
     {
    
     case 1: addressBook.displayName(rootObject);
             break;
     case 2:addressBook.addPerson(rootObject, personDetails,br);
            break;
     case 3:addressBook.deleteDetails(rootObject, br);
            break;
     case 4:addressBook.deleteSpecificDetails(rootObject, br);
            break;
     case 5:addressBook.addressDetails(rootObject, br);
            break;
     case 6:addressBook.genericDetails(rootObject, br);
            break;
     case 7:addressBook.printWholeAddressBook(rootObject);
            break;
     case 8:addressBook.updateAddressBook(rootObject, br);
            break;
     case 9:addressBook.printRootObject(rootObject, 9);
            break;
     case 10:addressBook.printRootObject(rootObject, 10);  
            break;
     case 11:return;
     
     default:System.out.println("Entered number is wrong");
             break;
     }
    }
}

}
