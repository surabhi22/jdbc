package com.training.utils;

import java.util.List;

public class Project {
	
	private int projectId ;
	private String projectName;
	private long projectCost;
	private long amountCollected;
	private long pendingAmount;
	
		
	public Project() {
		super();
	
	}

	public Project(int projectId , String projectName, long projectCost, long amountCollected, long pendingAmount) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectCost = projectCost;
		this.amountCollected = amountCollected;
		this.pendingAmount = pendingAmount;
	}
	
	
	 List<Donor> list_donor;
	
	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * @param list_donor the list_donor to set
	 */
	public void setList_donor(List<Donor> list_donor) {
		this.list_donor = list_donor;
	}


	public String getProjectName() {
		return projectName;
	}

	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
	public long getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(long projectCost) {
		this.projectCost = projectCost;
	}

	public long getAmountCollected() {
		return amountCollected;
	}

	
	public void setAmountCollected(long amountCollected) {
		this.amountCollected = amountCollected;
	}

	
	public long getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(long pendingAmount) {
		this.pendingAmount = pendingAmount;
	}


	public List getList_donor() {
		return list_donor;
	}

	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		System.out.println("projectName \t projectCost \t amountCollected \t pendingAmount");
		buffer = buffer.append(projectName).append("\t \t ").append(projectCost).append("\t \t").append(amountCollected).append(" \t\t\t").append(pendingAmount);
				
		return buffer.toString();
	}


	
	

}
