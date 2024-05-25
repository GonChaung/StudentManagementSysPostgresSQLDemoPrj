package Service;

import Model.Teacher;

public interface TeacherService {
    public Teacher insert(Teacher teacher);
    public Teacher delete(Teacher teacher);
    public Teacher update(Teacher teacher);
    public Teacher search(Teacher teacher);
}
