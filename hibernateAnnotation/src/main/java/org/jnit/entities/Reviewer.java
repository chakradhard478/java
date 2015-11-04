package org.jnit.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reviewer")
public class Reviewer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "reviewer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewerId;

	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "reviewer_task", joinColumns = { @JoinColumn(name = "reviewer_id") }, inverseJoinColumns = { @JoinColumn(name = "task_id") })
	private Set<Task> tasks = new HashSet<>();

	public int getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
