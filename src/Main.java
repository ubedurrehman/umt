import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner ob = null;
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionProvider.getConnection();
        System.out.println(connection);



        ob = new Scanner(System.in);

        System.out.println("Welcome to UMT ");
        System.out.println("1. Faculty ");
        System.out.println("2. Department ");
        System.out.println("3. Program ");
        System.out.println("4. Batch");
        System.out.println("5. Exit");
        System.out.println("Please Select Your Choice");
        int select  = ob.nextInt();

        if (select == 1){
            factuly();
        }

    }


    static void factuly() throws SQLException {
        System.out.println("Welcome to Faculty ");
        System.out.println("1. Add Faculty");
        System.out.println("2. Update  Faculty");
        System.out.println("4. Delete Faculty");
        System.out.println("5.  View Faculty");
        System.out.println("EXIT");
        System.out.println("Enter Choice...");
        int fs = ob.nextInt();



        if(fs== 1){

            System.out.println("Enter Faculty Name");
            String facultyName =ob.next();


            System.out.println("Enter Faculty Remarks");
            String facultyRemarks = ob.next();

            FacultyBean facultyBean = new FacultyBean();

            facultyBean.setFacultyName(facultyName);
            facultyBean.setFacultyRemarks(facultyRemarks);
            facultyBean.setCreateAt(new Date());


            FacultyDao facultyDao = new FacultyDao();
            facultyDao.insert(facultyBean);
         }
    }
}