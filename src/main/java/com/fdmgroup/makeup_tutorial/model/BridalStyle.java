package com.fdmgroup.makeup_tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BridalStyle extends MakeupStyle{

	@Column
	private String colourScheme;

	public BridalStyle(String name, String description, String products, int completionTime, String tutorial,
			int rating, Artist artist, String colourScheme) {
		super(name, description, products, completionTime, tutorial, rating, artist);
		this.colourScheme = colourScheme;
	}

	public BridalStyle() {
		super();
	}

	public String getColourScheme() {
		return colourScheme;
	}

	public void setColourScheme(String colourScheme) {
		this.colourScheme = colourScheme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((colourScheme == null) ? 0 : colourScheme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BridalStyle other = (BridalStyle) obj;
		if (colourScheme == null) {
			if (other.colourScheme != null)
				return false;
		} else if (!colourScheme.equals(other.colourScheme))
			return false;
		return true;
	}

	

}
