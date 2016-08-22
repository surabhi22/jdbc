package com.training.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DonorDAO implements MyDAO<Donor>{

	
	private Connection con = null;
	
	
	public DonorDAO() {
		super();
		// TODO Auto-generated constructor stub
		con = MySQLConnection.getMyOracleConnection();
	}

	public DonorDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(Donor object) {
		// TODO Auto-generated method stub
		int rowAdded = 0;
		
		try{
			
			String sql = "insert into Donor values(?,?,?,?)";
			
			PreparedStatement pstm = con.prepareStatement(sql);
			
			pstm.setLong(1, object.getDonorCode());
			pstm.setLong(3, object.getHandPhone());
			pstm.setString(2, object.getDonorName());
			pstm.setString(4, object.getEmail());
			
			rowAdded = pstm.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rowAdded;
	}

	@Override
	public int delete(long DonorCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(long newPhoneNumber) {
		// TODO Auto-generated method stub
		int rowAdded = 0;
		
		try{
			
			String sql = "update  Donor set email=? where handPhone="+newPhoneNumber ;
			
			PreparedStatement pstm = con.prepareStatement(sql);
			String email = "suru@gmail.com";
			pstm.setString(1,email );
			 
//			pstm.setLong(1, object.getDonorCode());
//			pstm.setLong(3, object.getHandPhone());
//			pstm.setString(2, object.getDonorName());
		
			rowAdded = pstm.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rowAdded;
		
	}

	@Override
	public Donor find(long DonorCode) {
		// TODO Auto-generated method stub
		
		Donor donor = new Donor();
		String sql = "select * from Donor where donorCode =" +DonorCode;
		
		try{
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet r = pstm.executeQuery();
		while(r.next()){
		donor.setDonorName(r.getString("donorName"));
		donor.setHandPhone(r.getLong("handphone"));
		donor.setEmail(r.getString("email"));
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return donor;
		
//	      Donor donor = new Donor();
//
//		try{
//	      CallableStatement st = 
//	    	      con.prepareCall("{call proc1(?,?,?,?)}");
//	      
//	      st.setLong(1, 2);
//	      
//	      st.registerOutParameter(2,java.sql.Types.VARCHAR);
//	      st.registerOutParameter(3,java.sql.Types.NUMERIC);
//	      st.registerOutParameter(4,java.sql.Types.VARCHAR);
//
//	      st.execute();
//	      donor.setDonorName(st.getString(2));
//		donor.setHandPhone(st.getLong(3));
//		donor.setEmail(st.getString(4));
//		
//		    System.out.println("donor Name: "+st.getString(2));
//	      System.out.println("handphone No: "+st.getLong(3));
//
//
//
//		}catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return donor;
	}

	@Override
	public List<Donor> findAll(Donor t) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void verify_user(String name , Long donorCode)
	{
		int found=0;
		String sql =  "select donorName , donorCode from Donor ";
		try{
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet r = pstm.executeQuery();
			while(r.next()){

					if(name.equals(r.getString("donorName")) && donorCode.equals(r.getLong("donorCode")))
					{
						found=1;
						break;
						
					}
			}
			if(found==1)
				System.out.println("valid user");
			else
				System.out.println("invalid user");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
	}
}
