package Service.Impl;

import Dao.EmployeeDao;
import Model.Employee;
import Service.EmployeeService;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    BufferedReader br = DataUtil.br;
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        this.employeeDao = new EmployeeDao();
    }
    @Override
    public Employee search(Employee employee){
        Employee search = this.employeeDao.searchEmployee(employee);
        return search;
    }
    @Override
    public Employee insert(Employee employee) {
        Employee insert = this.employeeDao.insertEmployee(employee);
        return insert;
    }

    @Override
    public Employee delete(Employee employee) {
        Employee deleted = this.employeeDao.deleteEmployee(employee);
        return deleted;
    }

    @Override
    public Employee update(Employee employee)  {
        Employee update = this.employeeDao.employeeUpdate(employee);
        return update;
    }

    public List<Employee> getAllEmployees() throws SQLException, IOException {
        return this.employeeDao.getAllEmployees();
    }

    public List<Employee> searchEmployeeByDepartment(int typeId) throws SQLException, IOException {
        return this.employeeDao.getEmployeesByDepartment(typeId);
    }
}
