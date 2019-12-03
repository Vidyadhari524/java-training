package com.hcl.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDao {
	Connection connection;
	PreparedStatement pst;
	public String deleteDepartment(int deptno) {
		connection=DaoConnection.getConnection();
		Department dept=searchDepartment(deptno);
		String result="";
		if(dept!=null) {
			String cmd=" Delete From Department where Deptno=? ";
			try {
				pst=connection.prepareStatement(cmd);
				pst.setInt(1, deptno);
				pst.executeUpdate();
				result="Record Deleted...";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else {
			result="Record not found...";
		}
		return result;
	}
	public Department searchDepartment(int deptno) {
		connection=DaoConnection.getConnection();
		String cmd=" select *from Department where Deptno=? ";
		Department department=null;
		try {
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, deptno);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				department=new Department();
				department.setDname(rs.getString("Dname"));
				department.setCity(rs.getString("City"));
				department.setLoc(rs.getString("Loc"));
				department.setHead(rs.getString("Head"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department;
	}
	public String addDepartment(Department department) {
		connection=DaoConnection.getConnection();
		String cmd=" insert into Department(deptno,dname,loc,city,head) "
				+" values(?,?,?,?,?) ";
		String result="";
		try {
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, department.getDeptno());
			pst.setString(2, department.getDname());
			pst.setString(3, department.getLoc());
			pst.setString(4, department.getCity());
			pst.setString(5, department.getHead());
			pst.executeUpdate();
			result="Department Record Added...";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=e.getMessage();
		}
		return result;
	}
	public int generateDepartment() {
		connection=DaoConnection.getConnection();
		String cmd=" select case when max(deptno) is NULL THEN 1 "
					+ " ELSE Max(deptno)+1 END deptno From department ";
		int deptno=0;
		try {
			pst=connection.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			rs.next();
			deptno=rs.getInt("deptno");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptno;
	}

	public List<Department> showDepartment() {
		connection=DaoConnection.getConnection();
		String cmd=" select * from department ";
		Department department=null;
		List<Department> departmentList=new ArrayList<>();
		try {
			pst=connection.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				department=new Department();
				department.setDeptno(rs.getInt("deptno"));
				department.setDname(rs.getString("dname"));
				department.setLoc(rs.getString("loc"));
				department.setCity(rs.getString("city"));
				department.setHead(rs.getString("head"));
				departmentList.add(department);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departmentList;
		
		
	}
}
