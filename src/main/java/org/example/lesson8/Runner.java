package org.example.lesson8;

import org.example.lesson6.homework.entity.Comment;
import org.example.lesson8.config.HibernateConfig;
import org.example.lesson8.entity.Company;
import org.example.lesson8.entity.Department;
import org.example.lesson8.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateConfig.createSessionFactory();
             Session session = sessionFactory.openSession()) {
            //initialize(session);
            CompanyDao companyDao = new CompanyDao();

            //Задача №1
            //List<Company> companies = companyDao.getCompanies(session);
            //System.out.println(companies);
            Company company = session.get(Company.class, 1);
            //Задача №2
//            List<Department> departments = companyDao.getDepartment(session, company);
//            System.out.println(departments);

            //Задача №3
//            List<Employee> employees = companyDao.getEmployeeWithCompany(session, company);
//            System.out.println(employees);

            //Задача №4
//            BigDecimal salary = new BigDecimal("15000.22");
//            List<Employee> employees = companyDao.getEmployeeWithSalaryGreaterThen(session, salary);
//            System.out.println(employees);

//            BigDecimal averageSalary = companyDao.getAverageSalary(session);
//            System.out.println(averageSalary);
//            Department department = session.get(Department.class, 1);
//            Employee employee = companyDao.getEmployee(session).orElse(
//                    new Employee("Mirko", new BigDecimal(100), department));
//            System.out.println(employee);

//            List<Object[]> objects = companyDao.getCountDepartmentsForCompany(session);
//            objects.stream().map(Arrays::toString).forEach(System.out::println);

            List<Employee> employees = companyDao.getTopFiveSalaryEmployee(session);
            System.out.println(employees);
        }
    }

    public static void initialize(Session session) {
        session.beginTransaction();
        List<Company> companies = List.of(new Company("Kola"), new Company("Amazon"));
        List<Department> departments = List.of(
                new Department("Finance", companies.get(0)),
                new Department("Sales", companies.get(0)),
                new Department("Finance", companies.get(1)),
                new Department("Sales", companies.get(1))
        );
        List<Employee> employees = List.of(
                new Employee("Petr", new BigDecimal(15_000), departments.get(0)),
                new Employee("Yuri", new BigDecimal(25_000), departments.get(1)),
                new Employee("Max", new BigDecimal(40_000), departments.get(2)),
                new Employee("Sonya", new BigDecimal(12_000), departments.get(3)),
                new Employee("Ivan", new BigDecimal(18_000), departments.get(0)),
                new Employee("Dima", new BigDecimal(55_000), departments.get(1)));

        companies.forEach(session::save);
        departments.forEach(session::save);
        employees.forEach(session::save);

        session.getTransaction().commit();
    }
}
