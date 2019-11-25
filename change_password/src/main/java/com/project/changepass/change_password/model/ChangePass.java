package com.project.changepass.change_password.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="ChangePass")
@DynamicUpdate
public class ChangePass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="number")
private int number;
private String username;
private String old_pass;
private String new_pass;
private String confirm_pass;


public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getOld_pass() {
	return old_pass;
}
public void setOld_pass(String old_pass) {
	this.old_pass = old_pass;
}
public String getNew_pass() {
	return new_pass;
}
public void setNew_pass(String new_pass) {
	this.new_pass = new_pass;
}
public String getConfirm_pass() {
	return confirm_pass;
}
public void setConfirm_pass(String confirm_pass) {
	this.confirm_pass = confirm_pass;
}

@Override
public String toString() {
	return "ChangePass [number=" + number + ", username=" + username + ", old_pass=" + old_pass + ", new_pass="
			+ new_pass + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 31;
	result = prime * result + ((new_pass == null) ? 0 : new_pass.hashCode());
	result = prime * result + number;
	result = prime * result + ((old_pass == null) ? 0 : old_pass.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ChangePass other = (ChangePass) obj;
	if (new_pass == null) {
		if (other.new_pass != null)
			return false;
	} else if (!new_pass.equals(other.new_pass))
		return false;
	if (number != other.number)
		return false;
	if (old_pass == null) {
		if (other.old_pass != null)
			return false;
	} else if (!old_pass.equals(other.old_pass))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}



}
