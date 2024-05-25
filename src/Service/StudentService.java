package Service;

import Model.Student;

public interface StudentService {
    public Student insert(Student student);
    public Student update(Student student);
    public Student delete(Student student);
    public Student search(Student student);
}
