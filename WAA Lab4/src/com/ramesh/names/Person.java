package com.ramesh.names;

public class Person {

int key;
String firstName;
String lastName;
public Person(){
	
}

public Person(int key, String firstName, String lastName){
	key=this.key;
	firstName=this.firstName;
	lastName=this.lastName;
}
//generating getters and setters

public int getKey() {
	return key;
}

public void setKey(int key) {
	this.key = key;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}




}
