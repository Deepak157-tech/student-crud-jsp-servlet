package com.emp;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    public static int insert(Employee e){
        int status=0;
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
            "INSERT INTO employees(emp_name,department,salary) VALUES(?,?,?)");

            ps.setString(1,e.getEmpName());
            ps.setString(2,e.getDepartment());
            ps.setDouble(3,e.getSalary());

            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex){ex.printStackTrace();}
        return status;
    }

    public static List<Employee> getAll(){
        List<Employee> list=new ArrayList<>();
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM employees");
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Employee e=new Employee();
                e.setEmpId(rs.getInt(1));
                e.setEmpName(rs.getString(2));
                e.setDepartment(rs.getString(3));
                e.setSalary(rs.getDouble(4));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return list;
    }

    public static int delete(int id){
        int status=0;
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
            "DELETE FROM employees WHERE emp_id=?");

            ps.setInt(1,id);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return status;
    }

	public static void update1(Employee e) {
		// TODO Auto-generated method stub
		
	}

	public static void update(Employee e) {
		// TODO Auto-generated method stub
		
	}
}