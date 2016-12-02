package model;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

public class PersonManager {

	public void update(Person person) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karthicraj","mysql","mysql");
		PreparedStatement preparedStatement = connection.prepareStatement("update person set name = ? where id = ?");
		preparedStatement.setString(1, person.getName());
		preparedStatement.setLong(2, person.getId());
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
		
	}
	
	public ArrayList<Person> select() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karthicraj","mysql","mysql");
		PreparedStatement preparedStatement = connection.prepareStatement("select * from person ");
		ArrayList<Person> personArrayList = new ArrayList<>();
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			Person person = new Person();
			person.setName(resultSet.getString("name"));
			person.setId(resultSet.getLong("id"));
			personArrayList.add(person);
		}
		
		preparedStatement.close();
		connection.close();
		return personArrayList;
	}
}
