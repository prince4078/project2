package com.sparx.blogapplication.payloads;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {
	private int userId;

	@NotEmpty(message="name cannot be empty ")
	@Size(min=3,max=30,message="the name provided must be between 3 and 30")
	@Pattern(regexp="^[a-zA-Z]+$",message="name Must Contain only Alphabets ")
	@Schema(
		    description = "Name of the user", 
		    name = "name", 
		    type = "string", 
		    example = "Prince")
	private String name ;
	@Email(message="email address is not valid ")
	@Schema(
		    description = "Email Address  of the user", 
		    name = "email", 
		    type = "string", 
		    example = "Prince@gmail.com")
	private String email;
	@NotEmpty(message="password must not be empty ")
	@Size(min=6,max=20,message="password be must be between 6 to 20 character")
	@Schema(
		    description = "describe about the user ", 
		    name = "about", 
		    type = "string", 
		    example = "He is a Normal User or He is admin User ")
	private String password;
	@NotEmpty
	private String about;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(int userId, String name, String email, String password, String about) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
}
