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

  static class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
      return Integer.compare(p1.age, p2.age);
    }
  }

  public static List<Person> getNewardFamily() {
    List<Person> family = new ArrayList<>();
    family.add(new Person("Ted", 41, 250000));
    family.add(new Person("Charlotte", 43, 150000));
    family.add(new Person("Michael", 22, 10000));
    family.add(new Person("Matthew", 15, 0));
    return family;
  }

  public int compareTo(Person other) {
    return Double.compare(other.salary, this.salary);
  }

  public int count() {
    return this.count;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || !(other instanceof Person)) {
      return false;
    } else {
      Person p = (Person) other;
      return this.name.equals(p.name) && this.age == p.age;
    }
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
    if (name == null) {
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

  public String toString() {
    return "[Person name:" + this.name + " age:" + this.age + " salary:" + this.salary + "]";
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
