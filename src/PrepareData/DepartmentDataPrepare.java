package PrepareData;

import Model.Person;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.util.List;

public class DepartmentDataPrepare {
    BufferedReader br = DataUtil.br;
    public void displayPersonFromDeparments(List<Person> persons){
        for(Person person : persons){
            System.out.println("id " + person.getId() + " name " + person.getName());
        }
    }
}
