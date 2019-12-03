package com.hcl.dept;


	import java.util.Scanner;

	public class SearchDepartmentMain {
		public static void main(String[] args) {
			int deptno;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Department no: ");
			deptno=sc.nextInt();
			DepartmentDao dao=new DepartmentDao();
			Department dept=dao.searchDepartment(deptno);
			if(dept!=null) {
				System.out.println("DName: "+dept.getDname());
				System.out.println("City: "+dept.getCity());
				System.out.println("Loc "+dept.getLoc());
				System.out.println("Head: "+dept.getHead());
			}
			else {
				System.out.println("Record not found....");
			}
		}
	}



