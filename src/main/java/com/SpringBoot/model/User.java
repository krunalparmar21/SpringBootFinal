package com.SpringBoot.model;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	private String lastname;

	@Column(nullable = false)
	private String dob;

	@Column(length = 10)
	private String mobileno;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String passwordConfirm;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private String hobby;

	private int status;
	
	@Transient
	private MultipartFile image;
	
	@Lob
	@Column(name="image")
	private String imageBase64;

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	List<Address> address;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Address> getAddress() {
		return address;
	}
	

	public User(int id, String firstname, String lastname, String dob, String mobileno, String email, String password,
			String passwordConfirm, String gender, String hobby, int status) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.mobileno = mobileno;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.gender = gender;
		this.hobby = hobby;
		this.status = status;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		try {
			this.imageBase64 = Base64.getEncoder().encodeToString(image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob + ", mobileno="
				+ mobileno + ", email=" + email + ", password=" + password + ", passwordConfirm=" + passwordConfirm
				+ ", gender=" + gender + ", hobby=" + hobby + ", status=" + status + ", address=" + address + "]";
	}

	
}
