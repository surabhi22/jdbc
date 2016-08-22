package com.training.utils;

import java.util.List;

public interface IProject {
	
	public int addProject(Project obj);
	public boolean[] addProjects(Project...prjlist);
	public void addDonor(String ProjectName , Project pro);
	public Project Edit_projectCost(int projectId , long addAmount);
	public Project find(int projectId) ;
	

	
}
