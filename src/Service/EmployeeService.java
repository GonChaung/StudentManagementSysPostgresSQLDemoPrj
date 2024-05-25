package Service;

import Model.Employee;

public interface EmployeeService {
    public Employee insert(Employee employee);
    public Employee update(Employee employee);
    public Employee delete(Employee employee);
    public Employee search(Employee employee);
}
