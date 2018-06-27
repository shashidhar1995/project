package com.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity            
@Table(name="User_reg")    
public class User implements Serializable {
                            
        
private Long id;               
private String name;                     
private String lastName;
private long phone;
private String email;
private String country;     
private String password;
         public User() {}
             
    
public User(String name, String lastName,long phone, String email,  String password,String country) {
this.name = name;
this.phone =phone;
this.password=password; 
this.lastName = lastName;
this.email = email;      
this.country = country;

}
@Id
@GenericGenerator(name="gen1",strategy="sequence")
@GeneratedValue(generator="gen1")
@Column(name="userid")
@Type(type="long")
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
@Column(name="name")
@Type(type="string")
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Column(name="lastname")
@Type(type="string")
public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

@Column(name="phoneno")
@Type(type="long")
public long getPhone() {
	return phone;
}

public void setPhone(long phone) {
	this.phone = phone;
}

@Column(name="gmail")
@Type(type="string")
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
@Column(name="password")
@Type(type="string")
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
@Column(name="country")
@Type(type="string")
public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}


}