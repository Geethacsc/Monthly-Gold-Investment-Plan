package com.finance.monthly_gold_investment.dto;

import java.sql.Timestamp;

public class UserRoleResponse {

	private Long id;
	private Long userId;
	private Long roleId;
	private Timestamp assignedAt;
	private String assignedBy;
	private String assignmentSource;
	private Timestamp expiresAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Timestamp getAssignedAt() {
		return assignedAt;
	}

	public void setAssignedAt(Timestamp assignedAt) {
		this.assignedAt = assignedAt;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getAssignmentSource() {
		return assignmentSource;
	}

	public void setAssignmentSource(String assignmentSource) {
		this.assignmentSource = assignmentSource;
	}

	public Timestamp getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Timestamp expiresAt) {
		this.expiresAt = expiresAt;
	}

	// getters & setters

}
