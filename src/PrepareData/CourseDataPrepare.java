package PrepareData;

import Dao.MajorDao;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class CourseDataPrepare {
    BufferedReader br = DataUtil.br;
    private MajorDao majorDao;
    public CourseDataPrepare() {
        majorDao = new MajorDao();
    }
    public List<String> courseDataPrepare() {
        String[] coursesForRegister = new String[8];
        System.out.println("What would you like to register?");
        try {
            String input = br.readLine();
            coursesForRegister = input.split(",");
            for (String part : coursesForRegister) {
                System.out.println(part);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of(coursesForRegister);
    }
}
