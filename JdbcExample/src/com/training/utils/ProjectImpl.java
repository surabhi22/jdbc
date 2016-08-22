package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectImpl implements IProject{

	List<Project> list ;
	private Connection con = null;
	
	public ProjectImpl() {
		super();
		list = new ArrayList();
		con = MySQLConnection.getMyOracleConnection();
		
		// TODO Auto-generated constructor stub
	}

	
	public ProjectImpl(List<Project> list) {
		super();
		this.list = list;
	}


	@Override
	public int addProject(Project object) {
		int rowAdded = 0;
		
		try{
			
			String sql = "insert into Project values(?,?,?,?,?)";
			
			PreparedStatement pstm = con.prepareStatement(sql);
			
			pstm.setLong(1, object.getProjectId());
			
			pstm.setString(2, object.getProjectName());
			pstm.setLong(3, object.getProjectCost());
			pstm.setLong(4, object.getAmountCollected());
			pstm.setLong(5, object.getPendingAmount());
			
			rowAdded = pstm.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rowAdded;
		}

	@Override
	public boolean[] addProjects(Project... prjlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDonor(String ProjectName, Project pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Project Edit_projectCost(int projectId , long addAmount) {
	
		Project pro=null;
		String projectName;
		long projectCost;
		long amountCollected;
		long pendingAmount;
		
		String sql = "select * from Project where ProjectId =" +projectId;
		try{
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet r = pstm.executeQuery();
			
			while(r.next()){
				projectName = r.getString("projectName");
				projectCost = r.getLong("projectCost")+ addAmount;
				amountCollected=r.getLong("amountCollected") ;
				pendingAmount=projectCost -r.getLong("amountCollected") ;
				
				String sql1 = "update Project set projectCost=?, amountPending=? where projectId="+projectId;
				pstm = con.prepareStatement(sql1);
				pstm.setLong(1,projectCost );
				pstm.setLong(2,pendingAmount );
				pstm.executeQuery();
				
				pro = new Project(projectId, projectName, projectCost, amountCollected, pendingAmount);
			}
			
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		return pro;
	}
	
	@Override
	public Project find(int projectId) {
		// TODO Auto-generated method stub
		
	
		String sql = "select * from Project where ProjectId =" +projectId;
		
		String projectName;
		long projectCost;
		long amountCollected;
		long pendingAmount;
		Project pro=null;
		
		try{
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet r = pstm.executeQuery();
		
		while(r.next()){
			projectName = r.getString("projectName");
			projectCost = r.getLong("projectCost");
			amountCollected=r.getLong("amountCollected");
			pendingAmount=r.getLong("amountPending");
			
			pro = new Project(projectId, projectName, projectCost, amountCollected, pendingAmount);
		}
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
		return pro;
		
	}
	
	
}
