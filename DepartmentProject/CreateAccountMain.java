package com.hcl.dept;

import java.util.List;

public class CreateAccountMain {
	public static void main(String[] args) {
		DepartmentDao dao=new DepartmentDao();
		List<Department> departmentlist=dao.showDepartment();
		for (Department department : departmentlist) {
			System.out.println("Deptno "+department.getDeptno());
			System.out.println("Deptname "+department.getDname());
			System.out.println("Loc "+department.getLoc());
			System.out.println("City "+department.getCity());
			System.out.println("Head "+department.getHead());
			System.out.println("-------------------------");
			
		}
		
		
	}

}
