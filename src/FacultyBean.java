import java.util.Date;

public class FacultyBean {
    private int id;
    private String facultyName;
    private String facultyRemarks;
    private Date createAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FacultyBean{" +
                "id=" + id +
                ", facultyName='" + facultyName + '\'' +
                ", facultyRemarks='" + facultyRemarks + '\'' +
                ", createAt=" + createAt +
                '}';
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyRemarks() {
        return facultyRemarks;
    }

    public void setFacultyRemarks(String facultyRemarks) {
        this.facultyRemarks = facultyRemarks;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}

