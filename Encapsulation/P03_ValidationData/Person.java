package Encapsulation.P03_ValidationData;

import java.text.DecimalFormat;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() <= 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(),
                new DecimalFormat("#.0###").format(salary));
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {
            setSalary(getSalary() + (getSalary() * bonus / 200));
        } else {
            setSalary(getSalary() + (getSalary() * bonus / 100));
        }
    }
}
