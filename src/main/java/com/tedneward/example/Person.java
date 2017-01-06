package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private int age, count = 0;
  private String name, ssn;
  private double salary;
  private boolean propertyChangeFired = false;

  public Person() {
    this("", 0, 0.0d);
  }

  public Person(String n, int a, double s) {
    this.name = n;
    this.age = a;
    this.salary = s;
    this.count++;
  }

  class AgeComparator implements Comparable <Person> {
    private Person p1, p2;

    public AgeComparator(Person p1, Person p2) {
      this.p1 = new Person(p1.name, p1.age, p1.salary);
      this.p2 = new Person(p2.name, p2.age, p2.salary);
    }

    public int compareTo(Person other) {
      return Integer.compare(p1.age, p2.age);
    }
  }

  public int compareTo(Person other) {
    return Double.compare(other.salary, this.salary);
  }

  public int count() {
    return this.count;
  }

  public boolean equals(Person other) {
    return this.name.equals(other.name) && this.age == other.age;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    if (age < 0) {
      throw new IllegalArgumentException();
    }
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    if (name.equals("")) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  public double getSalary() {
    return this.salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getSSN() {
    return this.ssn;
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
