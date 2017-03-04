package com.ugottime;


public class User {
    private String name, surname, email, password, department;
    private String id;


    public User(String id, String name, String surname, String email, String password, String department)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.department = department;
    }

    public String getId(){
        return id;
    }
    public String getName (){
        return name;
    }
    public String getSurname (){
        return surname;
    }
    public String getEmail (){
        return email;
    }
    public String getPassword (){
        return password;
    }
    public String getDepartment (){
        return department;
    }


}
