package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;

  public Person() {
    this("", 0, 0.0d);
  }

  public Person(String n, int a, double s) {
    this.name = n;
    this.age = a;
    this.salary = s;
  }

  public void setSSN(String value) {
    String old = this.ssn;
    this.ssn = value;

    this.pcs.firePropertyChange("ssn", old, value);
    this.propertyChangeFired = true;
  }

  public boolean getPropertyChangeFired() {
    return this.propertyChangeFired;
  }

  public double calculateBonus() {
    return this.salary * 1.10;
  }

  public String becomeJudge() {
    return "The Honorable " + this.name;
  }

  public int timeWarp() {
    return this.age + 10;
  }

  public String tostring() {
    return "{{FIXME}}";
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    this.pcs.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    this.pcs.removePropertyChangeListener(listener);
  }
}
