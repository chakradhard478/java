package org.jnit.composite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="author")
public class Author {
	@Id
	private AuthorId authorId;
	private String middleName;
	private String isbn;
	
	@Version//optimistic locking column
	private Integer versionId;

	public AuthorId getAuthorId() {
		return authorId;
	}

	public void setAuthorId(AuthorId authorId) {
		this.authorId = authorId;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
//	@Version
//	public Date updatedDate;
//
//	public Date getUpdatedDate() {
//		return updatedDate;
//	}
//
//	public void setUpdatedDate(Date updatedDate) {
//		this.updatedDate = updatedDate;
//	}
	

}
