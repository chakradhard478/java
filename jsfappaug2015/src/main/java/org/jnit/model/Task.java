package org.jnit.model;

import java.util.ArrayList;
import java.util.List;

public class Task {
	private int taskId;
	private String taskName;
	private List<Reviewer> reviewers = new ArrayList<Reviewer>();

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public List<Reviewer> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<Reviewer> reviewers) {
		this.reviewers = reviewers;
	}

}
