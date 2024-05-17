package DB_test;
import Controller.StudentController;
import static Utils.DataUtil.br;
public class StudentRegistrationApp {
    public static void main(String[] args) throws Exception{
        String work = "yes";
        StudentController studentController = new StudentController();
        while(work.equals("yes")){
            studentController.studentRegister();
            System.out.println("Do you want to continue? (yes/no) ?");
            work = br.readLine();
        }
    }
}
