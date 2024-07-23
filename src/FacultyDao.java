import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacultyDao {

    Connection con=null;

    public FacultyDao() throws SQLException {
      con=  ConnectionProvider.getConnection();
    }

    public void insert(FacultyBean facultyBean) {


        System.out.println(con);

        try {
            String insertQuery = "INSERT INTO faculty(Fname, Fremarks,createAt) VALUES(?,?,?)";

            //facultyBean.setFacultyName("Pharacy");
            PreparedStatement stmt = con.prepareStatement(insertQuery);
            stmt.setString(1,facultyBean.getFacultyName());
            stmt.setString(2,facultyBean.getFacultyRemarks());
            stmt.setString(3,facultyBean.getCreateAt().toString());

            int i = stmt.executeUpdate();
            if(i>=1){
                System.out.println("INSERTED SUCCESSFULLY@");
            }else{
                System.out.println("Failed to Insert");
            }
        }catch (Exception ee){
            ee.printStackTrace();
        }

    }
    public void getAll(FacultyBean facultyBean){

        String query = "SELECT * FROM faculty";
    }


}
