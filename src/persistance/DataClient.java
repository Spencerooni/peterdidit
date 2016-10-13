package persistance;

/**
 * Created by conort on 13/10/2016.
 */
public class DataClient {
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        try {
            em.getAllEmployees().stream().forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
