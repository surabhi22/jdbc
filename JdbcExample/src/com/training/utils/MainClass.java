package com.training.utils;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(MySQLConnection.getMyOracleConnection());
		
		DonorDAO  dao = new DonorDAO();
		
		int key = 1;
		
		switch (key) {
		case 1:
			int rowAdded= dao.add(new Donor(2, "suru", 22222, "suru@gmail.com"));
			System.out.println("Row[s] added = "+rowAdded);
			break;
		case 2:
			int row= dao.update(11111);
			System.out.println("Row[s] updated = "+row);
			break;
		case 3: 
			Donor donor = dao.find(2);
			System.out.println("found = "+donor.getDonorName());
		default:
			break;
		}
	}

}
