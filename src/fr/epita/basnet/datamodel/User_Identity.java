package fr.epita.basnet.datamodel;

/**
 * this is identity model class 
 * @author basnet
 *
 */
public class User_Identity {
	
private String name;
private long number;
private String email;
private int age;
private int id;
/**
 * this is the constructor 
 * @param name
 * @param number
 * @param email
 * @param age
 * @param id
 */

public User_Identity(String name, long number, String email, int age, int id) {
	super();
	this.name = name;
	this.number = number;
	this.email = email;
	this.age = age;
	this.id = id;
}
/**
 * get the name
 * @return name
 */
public String getName() {
	return name;
}
/**
 * this method is to set the name
 * @param name
 */
public void setName(String name) {
	this.name = name;
}
public long getNumber() {
	return number;
}
public void setNumber(long number) {
	this.number = number;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
