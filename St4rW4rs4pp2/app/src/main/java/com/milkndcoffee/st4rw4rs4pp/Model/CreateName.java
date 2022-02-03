package com.milkndcoffee.st4rw4rs4pp.Model;

public class CreateName {

    private String mFirstName;
    private String mLastName;
    private String mMaidenName;
    private String mCity;

    public CreateName(String firstName, String lastName, String maidenName, String city){
        setFirstName(firstName);
        setLastName(lastName);
        setMaidenName(maidenName);
        setCity(city);
    }

    //Setters
    public void setFirstName(String firstName){
        mFirstName = firstName;
    }
    public void setLastName(String lastName){
        mLastName = lastName;
    }
    public void setMaidenName(String maidenName){
        mMaidenName = maidenName;
    }
    public void setCity(String city){
        mCity = city;
    }

    //Return St4r W4rs Name
    public String getNewName(){
        String mNewName = mFirstName.substring(0, 2) + mLastName.substring(0, 3) + " " + mMaidenName.substring(0, 2) + mCity.substring(0, 3);
        return mNewName;
    }

}
