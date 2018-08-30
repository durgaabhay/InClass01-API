package handler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Person;
import util.PersonDB;

public class AddPersonHandler extends HttpServlet {
	
	static Person addPerson;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");
		System.out.println("Hi.. inside the handler");
		addPerson = new Person();
		
		String name = request.getParameter("fullName");
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String weight = request.getParameter("weight");
		
		addPerson = prepareUser(name,userId,password,age,weight);
		int success = insertIntoDB(addPerson);
		if(success == 0) {
			//success
		}else {
			//failure
		}
	}
	

	private int insertIntoDB(Person person) {
		int result = -1;
		try {
			result = PersonDB.insert(person);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	private Person prepareUser(String name, String userId, String password, String age, String weight) {
		Person newPerson = new Person();
		newPerson.setUserName(name);
		newPerson.setUserId(userId);
		newPerson.setPassword(password);
		newPerson.setAge(Integer.parseInt(age));
		newPerson.setWeight(Double.parseDouble(weight));
		return newPerson;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
