package com.bassam.java.designpattern.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class MyModel {

	public static final String FIRSTNAME = "firstName";
	public static final String LASTNAME = "lastName";

	private List<Person> persons = new ArrayList<>();
	private List<PropertyChangeListener> listener = new ArrayList<>();

	// we have hard code here
	public MyModel() {
		persons.add(new Person("heba", "anders"));
		persons.add(new Person("Bassam", "Aldalati"));
	}

	public List<Person> getPersons() {
		return persons;
	}

	private void notifyListeners(Object object, String property, String oldValue, String newValue) {
		for (PropertyChangeListener name : listener) {
			name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		}
	}

	public void addChangeListener(PropertyChangeListener newListener) {
		listener.add(newListener);
	}

	public class Person {
		private String firstNmae;
		private String lastName;

		public Person(String firstNmae, String lastName) {
			this.firstNmae = firstNmae;
			this.lastName = lastName;
		}

		public String getFirstNmae() {
			return firstNmae;
		}

		public void setFirstNmae(String firstNmae) {
			notifyListeners(this, FIRSTNAME, this.firstNmae, this.firstNmae = firstNmae);
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			notifyListeners(this, LASTNAME, this.lastName, this.lastName = lastName);
		}

	}

}
