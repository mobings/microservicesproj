package com.movie.App.model;

import javax.persistence.*;

@Entity
@Table(name = "Movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "released")
	private boolean released;

	public Movie() {

	}

	public Movie(String title, String description, boolean released) {
		this.title = title;
		this.description = description;
		this.released = released;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isReleased() {
		return released;
	}

	public void setReleased(boolean isreleased) {
		this.released = isreleased;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", desc=" + description + ", released=" + released + "]";
	}

}
