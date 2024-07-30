package dao;

import been.DepartmentBean;
import been.FacultyBean;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeptDao {

    private Connection connection;

    public DeptDao(Connection connection) {
        this.connection = connection;
    }

    private int addDept(DepartmentBean departmentBean)throws Exception{
        FacultyDao facultyDao = new FacultyDao(connection);
        FacultyBean facultyBean = facultyDao.searchById(departmentBean.getFacId());
        if(facultyBean!=null){
            String query = "INSERT into department(deptName , deptRemarks, facId) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, departmentBean.getDeptName());
            preparedStatement.setString(2, departmentBean.getDeptRemarks());
            preparedStatement.setInt(3, departmentBean.getFacId());
           return preparedStatement.executeUpdate();
        }else{
            throw new Exception("Faculty does not exist....");
        }

    }
}

