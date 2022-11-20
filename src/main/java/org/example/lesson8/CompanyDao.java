package org.example.lesson8;

import org.example.lesson8.entity.Company;
import org.example.lesson8.entity.Department;
import org.example.lesson8.entity.Employee;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class CompanyDao {

    public List<Company> getCompanies(Session session) {
        return session.createQuery("from Company", Company.class).list();
    }

    public List<Department> getDepartment(Session session, Company company) {
        return session.createQuery("from Department d where d.company = :company", Department.class)
                .setParameter("company", company)
                .list();
    }

//    3. Вывести на экран всех работников определенной компании
    public List<Employee> getEmployeeWithCompany(Session session, Company company) {
        return session.createQuery("from Employee e where e.department.company = :company", Employee.class)
                .setParameter("company", company)
                .list();
    }

//    4. Вывести сотрудников с зарплатой больше определенной
    public List<Employee> getEmployeeWithSalaryGreaterThen(Session session, BigDecimal salary) {
        return session.createQuery("from Employee e where e.salary > :salary", Employee.class)
                .setParameter("salary", salary)
                .list();
    }

    public BigDecimal getAverageSalary(Session session) {
        return new BigDecimal(session.createQuery("select avg(e.salary) from Employee e", Double.class)
                .uniqueResult());
    }

    public Optional<Employee> getEmployee(Session session) {
        return session.createQuery("from Employee e where e.id = 100", Employee.class)
                .uniqueResultOptional();
    }

//    Вывести количество департаментов для каждой компании
    public List<Object[]> getCountDepartmentsForCompany(Session session) {
        return session.createQuery("select d.company.name, sum(1) from Department d group by d.company.name",
                Object[].class).list();
    }

//    7. Вывести 5 сотрудников с самой большой зарплатой
    public List<Employee> getTopFiveSalaryEmployee(Session session) {
        return session.createQuery("from Employee e order by e.salary desc", Employee.class)
                .setMaxResults(5)
                .list();
    }
}
