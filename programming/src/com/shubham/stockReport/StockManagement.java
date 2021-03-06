package com.shubham.stockReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockManagement {
public static void main(String[] args) throws IOException, ParseException {
	
	/*Reading File Using FileReader*/
	FileReader file=new FileReader("C:/Users/User/Desktop/final/programming/src/com/shubham/stockReport/companyStocks.JSON");
	
	JSONParser parser=new JSONParser();
	Object object=parser.parse(file);
	
	/*We will use this JSONObject rootObject*/
	JSONObject rootObject=(JSONObject)object;
	
	/*Created Buffered Reader Object*/
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	/*Creating Object of StockValues Class*/
	StockValues stockValue=new StockValues();
	
	/*Creating Object of CostumerDetails Class*/
	CostumerDetails costumerDetails =new CostumerDetails();
	
	/*objects for finding present or todays date*/
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date today = Calendar.getInstance().getTime();
	
	FileReader newfile=new FileReader("C:/Users/User/Desktop/final/programming/src/com/shubham/stockReport/stockReport.JSON");
	JSONParser newParser=new JSONParser();
	Object newObject=newParser.parse(newfile);
	
	/*We will create a JSONObject rootObject for purchased Stocks*/
	JSONObject rootPurchaseObject=(JSONObject)newObject;
	
	/*We will create a Object of StockUtility Class*/
	StockUtility stockUtility=new StockUtility();
	
	stockUtility.generateChoices(br, rootObject, stockValue, dateFormat, today, rootPurchaseObject, costumerDetails);
}

}
