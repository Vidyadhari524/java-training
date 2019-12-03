package com.hcl.dept;

	import java.util.Scanner;


	public class AddDepartmentMain {
		public static void main(String[] args) {
			DepartmentDao dao=new DepartmentDao();
			//System.out.println(dao.generateDepartment());
			Department department=new Department();
			int deptno=dao.generateDepartment();
			department.setDeptno(deptno);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Dname ");
			department.setDname(sc.nextLine());
			System.out.println("Enter Location ");
			department.setLoc(sc.nextLine());
			System.out.println("Enter City ");
			department.setCity(sc.nextLine());
			System.out.println("Enter the head");
			department.setHead(sc.nextLine());
			System.out.println(dao.addDepartment(department));
		}
	}



