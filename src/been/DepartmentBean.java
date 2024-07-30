package been;

public class DepartmentBean {
    private int deptId;
    private String deptName;
    private String deptRemarks;
    private int facId;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptRemarks() {
        return deptRemarks;
    }

    public void setDeptRemarks(String deptRemarks) {
        this.deptRemarks = deptRemarks;
    }

    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }
}
