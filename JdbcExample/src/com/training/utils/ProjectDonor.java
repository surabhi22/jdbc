package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class ProjectDonor {

	
	Project p;
	Donor d ;
	private long amtDonated; 
	private Connection con = null;
	
	List<Donor> list_donor;
	List<Project> list_project;
	
	
	public ProjectDonor() {
		super();
		con = MySQLConnection.getMyOracleConnection();
		
	}

	public ProjectDonor(Project p, Donor d, long amtDonated) {
		super();
		con = MySQLConnection.getMyOracleConnection();
		this.amtDonated=amtDonated;
		this.p = p;
		this.d = d;
	}

	public Project getP() {
		return p;
	}
	
	public void setP(Project p) {
		this.p = p;
	}
	
	public Donor getD() {
		return d;
	}
	
	public void setD(Donor d) {
		this.d = d;
	}
	
	public long getAmtDonated() {
		return amtDonated;
	}

	public void setAmtDonated(long amtDonated) {
		this.amtDonated = amtDonated;
	}

	public int addProjectDonor(Project p, Donor d, long amtDonated) {
		int rowAdded = 0;	long newAmtDonated ;
		int projectId = p.getProjectId();
		
		long newamountCollected;
		if(p.getPendingAmount() >= amtDonated)
		{
			newAmtDonated =  amtDonated;
						
		}
		else{
			newAmtDonated =  p.getPendingAmount();
		}

		try{
			
			String sql = "insert into DonorProject values(?,?,?)";
			
			PreparedStatement pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, p.getProjectId());
			pstm.setLong(2, d.getDonorCode());
			pstm.setLong(3, newAmtDonated);
			
			rowAdded = pstm.executeUpdate();
			
			String sql1 = "update Project set amountCollected=?, amountPending=? where projectId ="+projectId ;
			pstm = con.prepareStatement(sql1);
			
			pstm.setLong(1, (p.getAmountCollected()+newAmtDonated) );
			pstm.setLong(2, (p.getPendingAmount()-newAmtDonated) );
			pstm.executeQuery();

			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	
		p.setAmountCollected(p.getAmountCollected()+newAmtDonated);
		p.setPendingAmount( p.getPendingAmount() - newAmtDonated);
		return rowAdded;
	}
	

	
	public void find_donor(int projectId)
	{
		
		try{
			
		ProjectDonor pd = new ProjectDonor();
		
		String sql = "select p.projectName , pd.donorCode , d.DonorName from Project p, DonorProject pd, Donor d where pd.donorCode=d.donorCode AND p.projectId=pd.projectId AND pd.projectId="+projectId;
		
		PreparedStatement pstm = con.prepareStatement(sql);
		//rowAdded = pstm.executeUpdate();
		ResultSet r = pstm.executeQuery();
		System.out.println("ProjectNAme \t DonorName \t DonorCode");
		while(r.next())
		{
			System.out.println(r.getString(1) +"\t\t " +r.getString(3) +"\t\t " +r.getString(2));
			//System.out.println();
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
			
	}
	
	public void find_project(long DonorCode)
	{
		
		try{
			

			ProjectDonor pd = new ProjectDonor();
			
			String sql = "select d.donorName , p.projectName, p.projectId from DonorProject pd, Donor d, project p where pd.projectId=p.projectId AND pd.donorCode=d.donorCode AND pd.donorCode="+DonorCode;
			
			PreparedStatement pstm = con.prepareStatement(sql);
			//rowAdded = pstm.executeUpdate();
			ResultSet r = pstm.executeQuery();
		
			System.out.println();
			System.out.println("DonorName \t ProjectNAme \t ProjectId");
			while(r.next())
			{
				System.out.println(r.getString(1) +"\t\t " +r.getString(2) +"\t\t " +r.getString(3));
				//System.out.println();
				
			}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	
		
	}
}
