package com.eswar.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Table(name = "Book_Record")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Builder
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	
	@NonNull
	private String name;
	
	@NonNull
	private String summary;
	
	private String rating;

		
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", summary=" + summary + ", rating=" + rating + "]";
	}

	public Book() {
		
		// TODO Auto-generated constructor stub
	}

	public Book(Long bookId, @NonNull String name, @NonNull String summary, String rating) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.summary = summary;
		this.rating = rating;
	}
	
	
	

}
