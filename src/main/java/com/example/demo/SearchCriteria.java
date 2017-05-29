package com.example.demo;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SearchCriteria implements Serializable {
	@Size(min = 2)
	private String keyword;
	@Email
	private String email;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@AssertTrue(message = "keyword or email is required")
	@JsonIgnore
	public boolean isKeyWordOrEmail() {
		return !StringUtils.isEmpty(this.keyword) || !StringUtils.isEmpty(this.email);
	}

	@Override
	public String toString() {
		return "SearchCriteria{" + "keyword='" + keyword + '\'' + ", email='" + email
				+ '\'' + '}';
	}
}
