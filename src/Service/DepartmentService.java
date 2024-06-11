package Service;

import Dao.DepartmentDao;
import Model.Person;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    private DepartmentDao departmentDao;

    public DepartmentService() {
        this.departmentDao = new DepartmentDao();
    }

//    public List<Person> getAllPerson() throws SQLException {
//        List<Person> persons = this.departmentDao.getAllPersonByDepartmentId();
//        return persons;
//    }
}
