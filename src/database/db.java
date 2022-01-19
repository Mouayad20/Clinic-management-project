package database;

import module.MediceneModule;
import module.PatientModule;
import module.VisitModule;

import java.sql.*;

public class db {
    //                     connection and the viribles                           \\
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost/barakat_clinic";

    static final String unicode = "?useUnicode=yes&characterEncoding=UTF-8";

    static final String USER = "root";

    static final String PASS = "";

    Connection conn = null;

    Statement stmt = null;

    ResultSet rs;

    PreparedStatement pstmt = null;

    public db() throws SQLException, ClassNotFoundException {
        Connection();
    }
    public void Connection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to database...");

        conn = DriverManager.getConnection(DB_URL+unicode, USER, PASS);

        if (conn == null)
        return;

        System.out.println("Creating statement...");

        stmt = conn.createStatement();
    }
//                                   patient functions                                       \\
    public void InsertPatient(PatientModule patientModule) throws SQLException {
        String quary = "INSERT INTO `patient` ( `name`, `father_name`, `mother_name`, `patient_id`, `birthday`, `mobilphone`, `job`, `description`,`warning`) VALUES (?,?,?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(quary);
        pstmt.setString(1,patientModule.getName());
        pstmt.setString(2,patientModule.getFather_name());
        pstmt.setString(3,patientModule.getMother_name());
        pstmt.setString(4,patientModule.getId_patient());
        pstmt.setString(5,patientModule.getBirthday());
        pstmt.setString(6,patientModule.getMobilephone());
        pstmt.setString(7,patientModule.getJob());
        pstmt.setString(8,patientModule.getDescreption());
        pstmt.setString(9,patientModule.getWarning());
        pstmt.executeUpdate();

    }
    public void UpdatePatient(PatientModule patientModule) throws SQLException {
        String quary = "UPDATE `patient` SET `name`=?,`father_name`=?,`mother_name`=?,`patient_id`=?,`birthday`=?,`mobilphone`=?,`job`=?,`description`=?,`warning`=? WHERE id=?";
        pstmt = conn.prepareStatement(quary);
        pstmt.setString(1,patientModule.getName());
        pstmt.setString(2,patientModule.getFather_name());
        pstmt.setString(3,patientModule.getMother_name());
        pstmt.setString(4,patientModule.getId_patient());
        pstmt.setString(5,patientModule.getBirthday());
        pstmt.setString(6,patientModule.getMobilephone());
        pstmt.setString(7,patientModule.getJob());
        pstmt.setString(8,patientModule.getDescreption());
        pstmt.setString(9,patientModule.getWarning());
        pstmt.setInt(10,patientModule.getId());
        pstmt.executeUpdate();
    }
    public void CreateTablePatient(String id) throws SQLException {
        String quary = "CREATE TABLe patient_"+id+"(id int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT, date date  NULL, description TEXT  NULL, medicene TEXT  NULL, notes TEXT  NULL);";
        stmt.execute(quary);
    }
    public PatientModule[] FetchPatientByName(String name) throws SQLException {
        String quary = "SELECT * FROM `patient` WHERE name like '%"+name+"%'";
        pstmt = conn.prepareStatement(quary,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String s = pstmt.toString();
        if (s.endsWith("'%%'"))
            return  GetPatientModule(null);
        rs = pstmt.executeQuery();
        return GetPatientModule(rs);
    }

    public PatientModule[] FetchPatinetPyId(String patint_id) throws SQLException {
        String quary = "SELECT * FROM `patient` WHERE patient_id like '%"+patint_id+"%'";
        pstmt = conn.prepareStatement(quary,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String s = pstmt.toString();
        if (s.endsWith("'%%'"))
            return  GetPatientModule(null);
        rs = pstmt.executeQuery();
        return GetPatientModule(rs);

    }
    public PatientModule[] FetchPatinetPydescription(String description) throws SQLException {
        String quary = "SELECT * FROM `patient` WHERE description like '%"+description+"%'";
        pstmt = conn.prepareStatement(quary,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String s = pstmt.toString();
        if (s.endsWith("'%%'"))
            return  GetPatientModule(null);
        rs = pstmt.executeQuery();
        return GetPatientModule(rs);

    }
    public String FetchPatientId(String name,String patient_id,String birthday) throws SQLException {
        String quary = "SELECT `id` FROM `patient` WHERE name=? and patient_id=? and birthday=?";
        pstmt = conn.prepareStatement(quary);
        pstmt.setString(1,name);
        pstmt.setString(2,patient_id);
        pstmt.setString(3,birthday);
        rs = pstmt.executeQuery();
        String id = new String();
        while (rs.next())
          id = rs.getString("id");
        return id;
    }
    private PatientModule[] GetPatientModule(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.last();
            PatientModule patientModule[] = new PatientModule[rs.getRow()];
            int i = 0;
            rs.beforeFirst();
            while (rs.next()) {
                patientModule[i] = new PatientModule();
                patientModule[i].setId(rs.getInt("id"));
                patientModule[i].setName(rs.getString("name"));
                patientModule[i].setFather_name(rs.getString("father_name"));
                patientModule[i].setMother_name(rs.getString("mother_name"));
                Integer patient_id = rs.getInt("patient_id");
                patientModule[i].setId_patient(patient_id.toString());
                patientModule[i].setBirthday(rs.getString("birthday"));
                patientModule[i].setMobilephone(rs.getString("mobilphone"));
                patientModule[i].setJob(rs.getString("job"));
                patientModule[i].setDescreption(rs.getString("description"));
                patientModule[i].setWarning(rs.getString("warning"));
                i++;
            }
            return patientModule;
        }
        else return null;
    }

    ////////////////////////// medicine functions \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public MediceneModule[] GetMediceneModuleFromDataBase() throws SQLException {
        String quary = "SELECT * FROM `medicine` WHERE 1 order by name";
        pstmt = conn.prepareStatement(quary,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs = pstmt.executeQuery();
        if (rs != null) {
            rs.last();
            MediceneModule mediceneModule[] = new MediceneModule[rs.getRow()];
            int i = 0;
            rs.beforeFirst();
            while (rs.next()) {
                mediceneModule[i] = new MediceneModule(rs.getString("name"),rs.getString("suffix"));
                i++;
            }
            return mediceneModule;

    }
        else
            return null;
}

    public void AddMedicene(MediceneModule mediceneModule) throws SQLException {
        String quary = "INSERT INTO `medicine` (`ID`, `name`, `suffix`) VALUES (NULL,?,?);";
        pstmt = conn.prepareStatement(quary);
        pstmt.setString(1,mediceneModule.getName());
        pstmt.setString(2,mediceneModule.getSuffix());
        pstmt.executeUpdate();

    }
    /////////////////////////// treatment functions \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public void AddVisit(VisitModule visitModule, String id) throws SQLException {
        String quary = "INSERT INTO `patient_"+id+"`( `date`, `description`, `medicene`,`notes`) VALUES (?,?,?,?)";
        pstmt = conn.prepareStatement(quary);
        pstmt.setString(1,visitModule.getDate());
        pstmt.setString(2,visitModule.getDescription());
        pstmt.setString(3,visitModule.getMedecine());
        pstmt.setString(4,visitModule.getNotes());
        pstmt.executeUpdate();

    }
    public VisitModule[] FetchVisitsSortedByDate(PatientModule patientModule) throws SQLException {
        String quary = "SELECT * FROM `patient_"+patientModule.getId()+"`ORDER BY date";
        pstmt = conn.prepareStatement(quary,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs = pstmt.executeQuery();
        return GetVisitModule(rs);
    }
     public  VisitModule[] FetchPatientBySpecificDate(PatientModule patientModule,String day,String month , String year) throws SQLException {
        String query = "SELECT * FROM `patient_"+patientModule.getId()+"` WHERE date LIKE '%"+year+"%-%"+month+"%-%"+day+"'";
        pstmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs = pstmt.executeQuery();
        return GetVisitModule(rs);
    }
    public VisitModule[] FetchVisitsByDescription(PatientModule patientModule , String description) throws SQLException {
        String query = "SELECT * FROM `patient_"+patientModule.getId()+"` WHERE description LIKE '%"+description+"%'";
        pstmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs = pstmt.executeQuery();
        return GetVisitModule(rs);
    }
    public VisitModule[] FetchVisitsByMedicene(PatientModule patientModule , String medicene) throws SQLException {
        String query = "SELECT * FROM `patient_"+patientModule.getId()+"` WHERE medicene LIKE '%"+medicene+"%'";
        pstmt = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs = pstmt.executeQuery();
        return GetVisitModule(rs);
    }
    private VisitModule[] GetVisitModule(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.last();
            VisitModule[] visitModule = new VisitModule[rs.getRow()];
            int i = 0;
            rs.beforeFirst();
            while (rs.next()) {
                visitModule[i] = new VisitModule(rs.getString("date"),rs.getString("description"),rs.getString("medicene"),rs.getString("notes"));
                i++;
            }
            return visitModule;
        }
        else
            return null;
    }
}
