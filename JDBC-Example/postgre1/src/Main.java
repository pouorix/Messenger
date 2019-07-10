/**
 * Created by Kiarash23 in 6/2/2019
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Person person = new Person("farbod_sh","farbod12345", 22);
        PersonDB personDB = new PersonDB();
//        personDB.addPerson(person);
//        personDB.changePass(person,"123456789");
//        System.out.println(personDB.getPerson("kiarash23"));
        personDB.getPersons();
        personDB.deletePerson("kiarash23");
    }
}
