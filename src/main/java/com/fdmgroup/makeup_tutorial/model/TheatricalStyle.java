package com.fdmgroup.makeup_tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TheatricalStyle extends MakeupStyle{
	
	@Column
	private String theme;

	public TheatricalStyle() {
		super();
	}

	public TheatricalStyle(String name, String description, String products, int completionTime, String tutorial,
			int rating, Artist artist, String theme) {
		super(name, description, products, completionTime, tutorial, rating, artist);
		this.theme = theme;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
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
		TheatricalStyle other = (TheatricalStyle) obj;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}
}
	
	