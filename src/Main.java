import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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


        FacultyDao facultyDao = new FacultyDao(ConnectionProvider.getConnection());
        if(fs== 1){

            System.out.println("Enter Faculty Name");
            String facultyName =ob.next();


            System.out.println("Enter Faculty Remarks");
            String facultyRemarks = ob.next();

            FacultyBean facultyBean = new FacultyBean();

            facultyBean.setFacultyName(facultyName);
            facultyBean.setFacultyRemarks(facultyRemarks);
            facultyBean.setCreateAt(new Date());


            facultyDao.insert(facultyBean);

         } else if (fs==2) {
                System.out.println("Enter Fid");
                int id=ob.nextInt();

                            FacultyBean fb = facultyDao.searchById(id);
                if (fb == null){
                    System.out.println("Faculty does not exist given id:"+id);
                }
                else {
                    System.out.println(fb);

                    System.out.println("change column record");

                    System.out.println("Enter Fname");
                    String name = ob.next();
                    System.out.println("Enter Fremarks");
                    String remarks = ob.next();

                    fb.setFacultyName(name);
                    fb.setFacultyRemarks(remarks);

                //    update(fb);
                    try {
                        boolean update = facultyDao.update(fb);
                        if(update){
                            System.out.println("Data Updated  Successfully!");
                        }else{
                            System.out.println("Data could not be updated ");
                        }
                    }catch (Exception ee){
                        ee.printStackTrace();
                    }
                }
        }  else if(fs==5){

            ArrayList<FacultyBean> listoffac=facultyDao.getAll();
            for (FacultyBean f: listoffac) {
System.out.println("---------------------------------------------------");
                System.out.println(f.getId());
                System.out.println(f.getFacultyName());
                System.out.println(f.getFacultyRemarks());
                System.out.println("---------------------------------------------------");

            }
        }
    }
}