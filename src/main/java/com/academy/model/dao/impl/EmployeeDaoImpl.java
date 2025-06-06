package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.EmployeeDao;
import com.academy.model.entity.Employee;
import com.academy.model.entity.Login;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

public class EmployeeDaoImpl extends DefaultDaoImpl<Employee, Integer> implements EmployeeDao {

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

//    public void save(Employee employee) {
//        EntityManager entityManager = DataSource.getInstance().getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(employee);
//        entityManager.getTransaction().commit();
//

//        try {
//            Connection connection = DataSource.getInstance().getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee(name, job, salary) values(?,?,?)");
//            preparedStatement.setString(1, employee.getName());
//            preparedStatement.setString(2, employee.getJob());
//            preparedStatement.setInt(3, employee.getSalary());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public void update(Employee employee) {
//        try {
//            Connection connection = DataSource.getInstance().getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareStatement("update employee set name = ?, job = ?, salary = ? where id = ?");
//            preparedStatement.setString(1, employee.getName());
//            preparedStatement.setString(2, employee.getJob());
//            preparedStatement.setInt(3, employee.getSalary());
//            preparedStatement.setInt(4, employee.getId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void delete(Employee employee) {
//        EntityManager entityManager = DataSource.getInstance().getEntityManager();
//        entityManager.getTransaction().begin();
//
//        entityManager.remove(employee);
//
//        entityManager.getTransaction().commit();
//
//        try {
//            Connection connection = DataSource.getInstance().getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id = ?");
//            preparedStatement.setInt(1, employee.getId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public Employee findById(Integer id) {
//        try {
//            Connection connection = DataSource.getInstance().getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id = ?");
//            preparedStatement.setInt(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            List<Employee> employees = new ArrayList<>();
//
//            while (resultSet.next()) {
//                Employee employee = new Employee();
//                employee.setId(resultSet.getInt("id"));
//                employee.setName(resultSet.getString("name"));
//                employee.setPhone(resultSet.getString("phone"));
//                employee.setSalary(resultSet.getInt("salary"));
//                employee.setAccount(resultSet.getInt("account"));
//
//                employees.add(employee);
//
//            }
//
//            return employees.getFirst();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        return null;
//    }

    public List<Employee> findAllData(){
        EntityManager entityManager = DataSource.getInstance().getEntityManager();

        Query query = entityManager.createQuery("from Employee as E");

        List<Employee> employees = query.getResultList();

        return employees;
    }

    public List<Employee> findAll() {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();

        Query query = entityManager.createQuery("from Employee");

        return query.getResultList();

//        try {
//            Connection connection = DataSource.getInstance().getConnection();
//
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("SELECT * FROM employee e left join login l on e.loginId = l.id");
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            List<Employee> employees = new ArrayList<>();
//
//            while (resultSet.next()) {
//                Employee employee = new Employee();
//                employee.setId(resultSet.getInt("id"));
//                employee.setName(resultSet.getString("name"));
//                employee.setPhone(resultSet.getString("phone"));
//                employee.setSalary(resultSet.getInt("salary"));
//                employee.setAccount(resultSet.getInt("account"));
//
//                Integer loginId = resultSet.getInt("loginId");
//
//                if (loginId != 0) {
//                    Login login = new Login();
//                    login.setId(loginId);
//                    login.setLogin(resultSet.getString("login"));
//                    login.setPassword(resultSet.getString("password"));
//
//                    employee.setLogin(login);
//                }
//
//                employees.add(employee);
//
//            }
//
//            return employees;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public Employee load(Integer id) {
        Session session = DataSource.getInstance().getSession();
        Employee employee = session.load(Employee.class, id);

        return employee;
    }

    public Employee get(Integer id) {
        Session session = DataSource.getInstance().getSession();
        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    public List<Employee> findByName(String name) {
        return null;
    }

    @Override
    public List<String> getNames() {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();

        Query query = entityManager.createQuery("select name from Employee");

        return query.getResultList();
    }

    @Override
    public List<Employee> getNameAndSalary() {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();

        Query query = entityManager.createQuery("select e.name, e.salary from Employee as e");

        return query.getResultList();
    }

    @Override
    public List<String> getLogins() {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();

        Query query = entityManager.createQuery("select e.login.login from Employee as e");
        return query.getResultList();
    }

    @Override
    public List<Employee> getSalary(Integer salary) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();

        Query query = entityManager.createQuery("from Employee where salary >= ?1 order by salary desc");
        query.setParameter(1, salary);
        query.setFirstResult(5);
        query.setMaxResults(7);
        return query.getResultList();
    }

    @Override
    public List<Object> getSalaryByJobs() {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();

        Query query = entityManager.createQuery("select max(salary), job from Employee group by trim(job)");

        return query.getResultList();
    }

    @Override
    public void updateSalary(Integer id, Integer salary) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("update Employee set salary = :salary where id = :id");
        query.setParameter("salary", salary);
        query.setParameter("id", id);

        query.executeUpdate();

        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteEmployee(Integer id) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("delete from Employee where id = :id");
        query.setParameter("id", id);

        query.executeUpdate();

        entityManager.getTransaction().commit();
    }

    @Override
    public void createEmployee(String name, Integer salary) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("insert into Employee (name, salary) values (:name, :salary)");
        query.setParameter("name", name);
        query.setParameter("salary", salary);

        query.executeUpdate();

        entityManager.getTransaction().commit();


    }


}