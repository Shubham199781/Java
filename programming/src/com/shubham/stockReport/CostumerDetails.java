package com.shubham.stockReport;

public class CostumerDetails {
private String fullName;
private int age;
private long phoneNumber;
private String currentDate;

public String getCurrentDate() {
	return currentDate;
}
public void setCurrentDate(String currentDate) {
	this.currentDate = currentDate;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}

}