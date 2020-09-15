package com.fdmgroup.makeup_tutorial.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class MakeupStyle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "makeupstyle_gen")
	@SequenceGenerator(name = "makeupstyle_gen", sequenceName = "MAKEUPSTYLE_SEQ", allocationSize = 1)
	private long makeupStyleId;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 100)
	private String description;

	@Column(nullable = false)
	private String products;

	@Column
	private int completionTime;

	@Column(nullable = false)
	private String tutorial;

	@Column
	private int rating;

	@ManyToOne
	@JoinColumn(name = "artistId")
	private Artist artist;

	public MakeupStyle(String name, String description, String products, int completionTime, String tutorial,
			int rating, Artist artist) {
		super();
		this.name = name;
		this.description = description;
		this.products = products;
		this.completionTime = completionTime;
		this.tutorial = tutorial;
		this.rating = rating;
		this.artist = artist;
	}

	public MakeupStyle() {
		super();
	}

	public long getMakeupStyleId() {
		return makeupStyleId;
	}

	public void setMakeupStyleId(long makeupStyleId) {
		this.makeupStyleId = makeupStyleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public int getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(int completionTime) {
		this.completionTime = completionTime;
	}

	public String getTutorial() {
		return tutorial;
	}

	public void setTutorial(String tutorial) {
		this.tutorial = tutorial;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + completionTime;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (makeupStyleId ^ (makeupStyleId >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + rating;
		result = prime * result + ((tutorial == null) ? 0 : tutorial.hashCode());
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
		MakeupStyle other = (MakeupStyle) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (completionTime != other.completionTime)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (makeupStyleId != other.makeupStyleId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (rating != other.rating)
			return false;
		if (tutorial == null) {
			if (other.tutorial != null)
				return false;
		} else if (!tutorial.equals(other.tutorial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MakeupStyle [makeupStyleId=" + makeupStyleId + ", name=" + name + ", description=" + description
				+ ", products=" + products + ", completionTime=" + completionTime + ", tutorial=" + tutorial
				+ ", rating=" + rating + ", artist=" + artist + "]";
	}

}
