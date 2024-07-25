import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacultyDao {

    Connection con = null;

    public FacultyDao(Connection con) throws SQLException {
        this.con = con;
    }

    public void insert(FacultyBean facultyBean) {
        try {
            String insertQuery = "INSERT INTO faculty(Fname, Fremarks,createAt) VALUES(?,?,?)";

            //facultyBean.setFacultyName("Pharacy");
            PreparedStatement stmt = con.prepareStatement(insertQuery);
            stmt.setString(1, facultyBean.getFacultyName());
            stmt.setString(2, facultyBean.getFacultyRemarks());
            stmt.setString(3, facultyBean.getCreateAt().toString());

            int i = stmt.executeUpdate();
            if (i >= 1) {
                System.out.println("INSERTED SUCCESSFULLY@");
            } else {
                System.out.println("Failed to Insert");
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }


    public FacultyBean searchById(int facultyId) throws SQLException {
        FacultyBean facultyBean = new FacultyBean();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT* FROM faculty WHERE Fid = ?");
            stmt.setInt(1, facultyId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                facultyBean.setFacultyName(rs.getString("fname"));
                facultyBean.setFacultyRemarks(rs.getString("Fremarks"));
                facultyBean.setId(rs.getInt("Fid"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return facultyBean;
    }


    public boolean update(FacultyBean facultyBean) throws Exception {

        PreparedStatement stmt = con.prepareStatement("UPDATE faculty SET fname = ?, Fremarks = ? WHERE Fid = ?");
        stmt.setString(1, facultyBean.getFacultyName());
        stmt.setString(2, facultyBean.getFacultyRemarks());
        stmt.setInt(3, facultyBean.getId());

        int fb = stmt.executeUpdate();
        if (fb > 0) {
            return true;
        } else {
            return false;
        }


    }
    //first of all peli check krryo k data kya aaayga
    //    data aaye collection of Faculty manah list of faculties..
    //thek hain na q k get all

    public ArrayList<FacultyBean> getAll() {
        //hummiye ek arraylist ka objec banana prryga wahan data hum set krrygy thek
        ArrayList<FacultyBean> facultyBeans = new ArrayList<>();
        //        q k method return listoffacultybean  krrry rha hai

        try {
            String query = "SELECT * FROM faculty";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                FacultyBean f = new FacultyBean();
                f.setFacultyRemarks(resultSet.getString("Fremarks"));
                f.setFacultyName(resultSet.getString("Fname"));
//               f.setCreateAt(resultSet.getDate("createAt"));
                f.setId(resultSet.getInt("Fid"));
                //ab yeh faculty hum list m add krrna hai
                facultyBeans.add(f);

            }

//            yeh hymmi resultset dyee ga
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facultyBeans;
    }

    public int delete(int facultyId) {

        try {
            String query = "DELETE FROM faculty WHERE Fid = ?";

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, facultyId);

             return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }
}




