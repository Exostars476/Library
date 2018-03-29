package com.formation.infotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Member {

	@Id
	@GeneratedValue
	private int memberId;
	private String memberLastName;
	private String firstName;
	private String email;
	private String password;
	private String address;
	private String city;
	private String postalCode;
	private String phone;
	private int access;

	@OneToOne(mappedBy = "member")
	private Registration registration;

	public Member() {

	}

	public Member(String memberLastName, String email, String password, String address, String city, String postalCode, int access,
				  String phone, String firstName) {
		this.memberLastName = memberLastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.phone = phone;
		this.access = access;
	}

	public Member(String memberLastName, String firstName, String email, String password, String address, String city, String postalCode, String phone, int access, Registration registration) {
		this.memberLastName = memberLastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.phone = phone;
		this.access = access;
		this.registration = registration;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

    public int getMemberId() {
		return memberId;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
