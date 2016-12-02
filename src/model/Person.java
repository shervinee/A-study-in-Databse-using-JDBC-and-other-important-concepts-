package model;

public class Person {
 private long id;
 private static long rowNum;
 private String name;
 
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public static long getRowNum() {
	return rowNum++;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
 
}
