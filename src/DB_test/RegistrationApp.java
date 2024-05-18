package DB_test;
import Controller.StudentController;
import Controller.TeacherController;

import static Utils.DataUtil.br;

public class RegistrationApp {
    public static void main(String[] args) throws Exception{
        String work = "yes";
        StudentController sc = new StudentController();
        TeacherController tc = new TeacherController();
        /*while(work.equals("yes")){
            System.out.println(" For student or teacher ?");
            String choice = br.readLine();
            switch(choice){
                case "student" : sc.studentRegister();
                break;
                case "teacher" : tc.teacherRegister();
            }
            System.out.println("Do you want to continue? (yes/no) ?");
            work = br.readLine();
        }

         */
        // sc.studentRegister();
        tc.teacherRegister();
    }
}
