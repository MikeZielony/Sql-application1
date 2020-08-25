package SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseInit {
    private Connection c;
    protected Statement stm;

    public void initializeDb(String statement) {
        connectToSQL();
        try {
            stm.executeUpdate(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    protected void closeConnection() {
        try {
            stm.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void connectToSQL() {
        try {
            String url = "jdbc:postgresql://ec2-54-195-247-108.eu-west-1.compute.amazonaws.com/d1gpea0p8fdql6";
            String user = "thepdxsfidjnkp";
            String password = "7f1ef87176a417c53be5b14ce40dd4035f71b7179567f991575500edfa9d3f52";
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, password);
            c.setAutoCommit(true);
            stm = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getMentorsTwoNames() {
        List<String> mentorNames = new ArrayList<>();
        try {
            connectToSQL();
            ResultSet rs = stm.executeQuery("SELECT * FROM mentors");
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                mentorNames.add(firstName + " " + lastName);
            }
            rs.close();
            closeConnection();
            return mentorNames;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<String> getMentorsNickames() {
        List<String> mentorNames = new ArrayList<>();
        try {
            connectToSQL();
            ResultSet rs = stm.executeQuery("SELECT * FROM mentors WHERE city= 'Miskolc'");
            while (rs.next()) {
                String nickName = rs.getString("nick_name");
                mentorNames.add(nickName);
            }
            rs.close();
            closeConnection();
            return mentorNames;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<String> getCarolData() {
        List<String> mentorNames = new ArrayList<>();
        try {
            connectToSQL();
            ResultSet rs = stm.executeQuery("SELECT CONCAT_WS(' ', (first_name),(last_name) )AS full_name,(phone_number) FROM applicants WHERE first_name='Carol'");
            while (rs.next()) {
                String nickName = rs.getString("full_name");
                String phoneNumber = rs.getString("phone_number");
                mentorNames.add(nickName + " " + phoneNumber);
            }
            rs.close();
            closeConnection();
            return mentorNames;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<String> getCorrectCarolData() {
        List<String> mentorNames = new ArrayList<>();
        try {
            connectToSQL();
            ResultSet rs = stm.executeQuery("SELECT CONCAT_WS(' ', (first_name),(last_name) )AS full_name,(phone_number) FROM applicants " +
                    "WHERE RIGHT(email,21)='@adipiscingenimmi.edu'");
            while (rs.next()) {
                String nickName = rs.getString("full_name");
                String phoneNumber = rs.getString("phone_number");
                mentorNames.add(nickName + " " + phoneNumber);
            }
            rs.close();
            closeConnection();
            return mentorNames;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<String> getNewApplicant() {
        List<String> mentorNames = new ArrayList<>();
        try {
            connectToSQL();
            stm.execute("INSERT INTO applicants (first_name,last_name,phone_number,email,application_code)" +
                    " VALUES ('Markus','Schaffarzyk','003620/725-2666','djnovus@groovecoverage.com',54823)");
            ResultSet rs = stm.executeQuery("SELECT * FROM applicants WHERE application_code = 54823");
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String code = rs.getString("application_code");
                mentorNames.add(firstName + " " + lastName + " " + phoneNumber + " " + email + " " + code);
            }
            rs.close();
            closeConnection();
            return mentorNames;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<String> updatePhoneNumber() {
        List<String> mentorNames = new ArrayList<>();
        try {
            connectToSQL();
            stm.execute("UPDATE applicants SET phone_number='003670/223-7459' WHERE first_name='Jemima' AND last_name='Foreman'");
            ResultSet rs = stm.executeQuery("SELECT phone_number FROM applicants WHERE first_name='Jemima' AND last_name='Foreman'");
            while (rs.next()) {
                String phoneNumber = rs.getString("phone_number");
                mentorNames.add(phoneNumber);
            }
            rs.close();
            closeConnection();
            return mentorNames;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    public List<String> deleteSpecificApplicants() {
        List<String> mentorNames = new ArrayList<>();
        try {
            connectToSQL();
            stm.execute("DELETE FROM applicants WHERE RIGHT(email,12)='mauriseu.net'");
            ResultSet rs = stm.executeQuery("SELECT * FROM applicants");
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String code = rs.getString("application_code");
                mentorNames.add(firstName + " " + lastName + " " + phoneNumber + " " + email + " " + code);
            }
            rs.close();
            closeConnection();
            return mentorNames;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
}

