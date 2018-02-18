package com.bassam.java.designpattern.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyObserver implements PropertyChangeListener{

	public MyObserver(MyModel myModel) {
	myModel.addChangeListener(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		 System.out.println("Changed property: " + event.getPropertyName() + " [old -> "
		            + event.getOldValue() + "] | [new -> " + event.getNewValue() +"]");
		
	}

}
