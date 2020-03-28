package com.company;

public class Person {

    private String name;
    private String surname;
    private String phoneNumber;


    Person(String phoneNumber, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode(){
        return Integer.parseInt(phoneNumber.substring(2,11));
    }

    @Override
    public boolean equals(Object o){
        final Person p = (Person) o;
        return this.name.equals(p.name) && this.surname.equals(p.surname) && this.phoneNumber.equals(p.phoneNumber);

    }

    @Override
    public String toString() {
        return "\n\nName: " + getName() + "\nSurname: " + getSurname() + "\nPhone number: " + getPhoneNumber();
    }

}
