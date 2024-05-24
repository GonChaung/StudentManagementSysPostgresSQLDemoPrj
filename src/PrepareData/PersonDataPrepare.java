package PrepareData;

import Model.Person;
import Utils.DataUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

public class PersonDataPrepare {
    BufferedReader br = DataUtil.br;
    public PersonDataPrepare() {}
    public Person preparePersonDataForRegistration(Person person) throws IOException, SQLException {
        System.out.println("Name : " ) ;
        person.setName(br.readLine());
        System.out.println("Phone : ");
        person.setPhone(br.readLine());
        System.out.println("Email : ");
        person.setEmail(br.readLine());
        System.out.println("Age : ");
        person.setAge(br.readLine());
        System.out.println("Gender : ");
        person.setGender(br.readLine());
        return person;
    }
    public Person preparePersonDataForUpdate(Person person) throws IOException, SQLException {
        System.out.println("Type ID : ");
        person.setId(Integer.parseInt(br.readLine()));
        System.out.println("Type name : ");
        person.setName( br.readLine());
        System.out.println("Type phone : ");
        person.setPhone( br.readLine());
        System.out.println("Type email : ");
        person.setEmail(br.readLine());
        System.out.println("Age : ");
        person.setAge(br.readLine());
        System.out.println("Gender : ");
        person.setGender(br.readLine());
        return person;
    }
}
