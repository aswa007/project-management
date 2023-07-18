package com.edstem.book.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book_details")
public class Book {

	protected Book() {

	}

	@Id

	@GeneratedValue(strategy = GenerationType.TABLE)

	private Integer id;

	private String title;

	private String author;

	private long isbn;

	private LocalDate publicationDate;

	public Book(Integer id, String title, String author, long isbn, LocalDate publicationDate) {

		super();

		this.id = id;

		this.title = title;

		this.author = author;

		this.isbn = isbn;

		this.publicationDate = publicationDate;

	}

	public Integer getId() {

		return id;

	}

	public void setId(Integer id) {

		this.id = id;

	}

	public String getTitle() {

		return title;

	}

	public void setTitle(String title) {

		this.title = title;

	}

	public String getAuthor() {

		return author;

	}

	public void setAuthor(String author) {

		this.author = author;

	}

	public long getIsbn() {

		return isbn;

	}

	public void setIsbn(long isbn) {

		this.isbn = isbn;

	}

	public LocalDate getPublicationDate() {

		return publicationDate;

	}

	public void setPublicationDate(LocalDate publicationDate) {

		this.publicationDate = publicationDate;

	}

	@Override

	public String toString() {

		return "Book{" +

				"id=" + id +

				", title='" + title + '\'' +

				", author='" + author + '\'' +

				", isbn=" + isbn +

				", publicationDate=" + publicationDate +

				'}';

	}

}