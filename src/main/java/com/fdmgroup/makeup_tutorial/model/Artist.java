package com.fdmgroup.makeup_tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Artist")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_gen")
	@SequenceGenerator(name = "artist_gen", sequenceName = "ARTIST_SEQ", allocationSize = 1)
	private long artistId;

	@Column(nullable = false, length = 50)
	private String firstname;

	@Column(nullable = false, length = 50)
	private String lastname;

	@Enumerated(EnumType.STRING)
	StyleType styleType;

	@Column(nullable = false, length = 100, unique = true)
	private String email;

	@Column(nullable = false, length = 50)
	private String password;

	@Column(length = 100)
	private String socialmedia;

	public Artist() {
		super();
	}

	public Artist(String firstname, String lastname, StyleType styleType, String email, String password,
			String socialmedia) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.styleType = styleType;
		this.email = email;
		this.password = password;
		this.socialmedia = socialmedia;

	}

	public String getFullName() {
		return this.firstname + " " + this.lastname;
	}

	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
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

	public StyleType getStyleType() {
		return styleType;
	}

	public void setStyleType(StyleType styleType) {
		this.styleType = styleType;
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

	public String getSocialmedia() {
		return socialmedia;
	}

	public void setSocialmedia(String socialmedia) {
		this.socialmedia = socialmedia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (artistId ^ (artistId >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((socialmedia == null) ? 0 : socialmedia.hashCode());
		result = prime * result + ((styleType == null) ? 0 : styleType.hashCode());
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
		Artist other = (Artist) obj;
		if (artistId != other.artistId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (socialmedia == null) {
			if (other.socialmedia != null)
				return false;
		} else if (!socialmedia.equals(other.socialmedia))
			return false;
		if (styleType != other.styleType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", firstname=" + firstname + ", lastname=" + lastname + ", styleType="
				+ styleType + ", email=" + email + ", password=" + password + ", socialmedia=" + socialmedia + "]";
	}
}
