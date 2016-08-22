package com.training.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.DomainManagerOperations;




/**
 * 
 * 
 */
public class MainClass2 {

/**
 * 
 * 
 * @param args
 */
  public static void main(String[] args) {
    int key = 4;
    switch (key) {
      case 1: {
        Donor d  = new Donor(1, "abc", 4444, "abc@gmail.com");
        Donor d1 = new Donor(2, "cde", 2222, "cde@gmail.com");
        Donor d2 = new Donor(3, "fgh", 3333, "fgh@gmail.com");
        Donor d3 = new Donor(4, "jkl", 1111, "jkl@gmail.com");
        Donor d4 = new Donor(5, "jkl", 4444, "jkl@gmail.com");

        DonorDAO  dao = new DonorDAO();
        dao.add(d);
        dao.add(d1);
        dao.add(d2);
        dao.add(d3);
        dao.add(d4);
        Project p1 = new Project(1,"A", 1000, 0, 1000);
        Project p2 = new Project(2, "B", 1000, 500, 500 );
        Project p3 = new Project(3, "C", 1000, 500, 500 );

        ProjectImpl pi = new ProjectImpl();
        pi.addProject(p1);
        pi.addProject(p2);
        pi.addProject(p3);

				 ProjectDonor pd = new ProjectDonor();
				pd.addProjectDonor(p1, d1 , 100);
				pd.addProjectDonor(p1, d2, 100);
				pd.addProjectDonor(p2, d1, 100);
				pd.addProjectDonor(p2, d2, 100);
				pd.addProjectDonor(p3, d3 , 100);
				break;
		}

		case 2:
		{
			
		
				ProjectDonor pd1 = new ProjectDonor();
				pd1.find_donor(2);
				
				pd1.find_project(2);
				
				break;
		}
		case 3:
		{
			ProjectImpl pi = new ProjectImpl();
			Project pro = pi.find(1);
			System.out.println(pro);
			
			break;
		}
		case 4:
		{
			Project  pro;
			ProjectImpl pi = new ProjectImpl();
			System.out.println(pi.find(1));
			pro = pi.Edit_projectCost(1,1000);
			System.out.println();
			System.out.println("After updating Project Cost");
			System.out.println();
			System.out.println(pro);
			
			break;
			
		}
		case 5:
		{
			Scanner sc = new Scanner(System.in);
			String name = sc.next();
			Long donorCode = sc.nextLong();
			
			DonorDAO dao = new DonorDAO();
			dao.verify_user(name , donorCode);
			
			break;
		}
		default:
		{
			
			
		}
	}

}
}