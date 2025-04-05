package com.academy;

import com.academy.model.dao.AddressDao;
import com.academy.model.dao.EmployeeDao;
import com.academy.model.dao.impl.AddressDaoImpl;
import com.academy.model.dao.impl.EmployeeDaoFileSystem;
import com.academy.model.dao.impl.EmployeeDaoImpl;
import com.academy.model.entity.Employee;
import com.academy.model.entity.Login;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.cj.jdbc.Driver");


//        Connection con = DataSource.getInstance().getConnection();

//        con.setAutoCommit(false);
//
//        try {
//            PreparedStatement ps = con.prepareStatement("update employee set account=? where id=?");
//
//            ps.setInt(1,
//                      0);
//            ps.setInt(2,
//                      1);
//            ps.executeUpdate();

//            if (true)
//                throw new RuntimeException();

//            ps.setInt(1,
//                      1000);
//            ps.setInt(2,
//                      2);
//            ps.executeUpdate();
//
//            con.commit();
//
//        } catch (Exception e) {
//            con.rollback();
//        }

//        String request = "10";
//
//        Statement stmt = con.createStatement();
//        //ResultSet rs = stmt.executeQuery("select * from employee where id = " + request);
//        PreparedStatement ps = con.prepareStatement("select * from employee");
//
//        ResultSet rs = ps.executeQuery();
//
//        List<Employee> employees = new ArrayList<>();
//
//        while (rs.next()) {
//            Employee employee = new Employee();
//            employee.setId(rs.getInt("id"));
//            employee.setName(rs.getString("name"));
//            employee.setSalary(rs.getInt("salary"));
//
//            employees.add(employee);
//            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
//        }

//        int result = stmt.executeUpdate("delete from login where id= " + id);
//
//        System.out.println(result);

//        rs.close();
//        ps.close();

//        CallableStatement callableStatement = con.prepareCall("{call employeecount(?)}");
//        callableStatement.registerOutParameter(1, Types.INTEGER);
//
//        callableStatement.execute();
//
//        System.out.println(callableStatement.getInt(1));

//        con.close();

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

        List<Employee> employees = employeeDao.findAll();

        Login login = new Login();
        login.setLogin("admin");
        login.setPassword("admin");

        Employee employee1 = Employee.builder()
                .name("Test234")
                .job("Engineer")
                .salary(5000)
                .login(login)
                .build();

        employeeDao.save(employee1);
//
//
//
//        EmployeeDao employeeDao2 = new EmployeeDaoFileSystem();
//
//        List<Employee> employees2 = employeeDao2.findAll();

//        AddressDao addressDao = new AddressDaoImpl();

//        addressDao.findAll();
    }
}
