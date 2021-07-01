package com.dgm.employeemanage.dao;

import com.dgm.employeemanage.pojo.Department;
import com.dgm.employeemanage.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee>employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();
        employees.put(101,new Employee(1001,"AA","A123456@qq.com",1,new Department(101,"教学部")));
        employees.put(101,new Employee(1002,"BB","B123456@qq.com",0,new Department(102,"市场部")));
        employees.put(101,new Employee(1003,"CC","C123456@qq.com",1,new Department(103,"教研部")));
        employees.put(101,new Employee(1004,"DD","D123456@qq.com",0,new Department(104,"运营部")));
        employees.put(101,new Employee(1005,"EE","E123456@qq.com",1,new Department(105,"后勤部")));
    }

    private static Integer initid = 1006;

    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initid++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee>getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
