import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Results {
    static String User = "root";
    static String Password = "mysql1234";
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Results res = new Results();
        res.getInput();
    }

    void getInput() {

        System.out.println("Enter the user");
        System.out.println("1. Admin");
        System.out.println("2. HOD");
        System.out.println("3. Advisor");
        System.out.println("4. Faculty");
        System.out.println("5. Student");
        int N = s.nextInt();
        switch (N) {
            // Admin
            case 1: {
                adminDashboard();
                getInput();
                break;
            }
            case 2: {
                Dashboard(1);
                getInput();
                break;
            }
            case 3: {
                Dashboard(2);
                getInput();
                break;
            }
            case 4: {
                Dashboard(3);
                getInput();
                break;
            }
            case 5: {
                Dashboard(4);
                getInput();
                break;
            }
            default: {
                System.out.println("Incorrect Option Selected");
                getInput();
                break;
            }
        }
    }

    void Dashboard(int value) {
        try {
            // MySQL Driver Init
            Class.forName("com.mysql.cj.jdbc.Driver");

            switch (value) {
                // HOD Dashboard
                case 1: {
                    System.out.println("Enter Department Name");
                    String Dept = s.next();
                    System.out.println("Enter Semester");
                    String sem = s.next();

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Dept, User,
                            Password);

                    Statement stmt = con.createStatement();

                    String query = "SELECT r.`Student ID` ,r.`Subject ID`, s.`Subject Code`, r.Mark , st.`Student Name` FROM Results r LEFT JOIN Subjects s ON r.`Subject ID` = s.`Subject ID` LEFT JOIN Students st ON st.`Student ID` = r.`Student ID` WHERE s.Semester = " + sem; 

                    ResultSet rs = stmt.executeQuery(query);
                    
                    System.out.println("Department: "+ Dept);
                    System.out.println("Semester: "+ sem);
                    System.out.println("===========================================================================");
                    System.out.println("Student ID    Subject ID     Subject Code        Mark        Student Name");
                    System.out.println("===========================================================================");
                    while (rs.next()) {
                        System.out.println("      " + rs.getString(1) + "            " + rs.getString(2) + "            " + rs.getString(3)  + "            " + rs.getString(4)  + "            " + rs.getString(5));
                    }
                    System.out.println("===========================================================================");
                    con.close();

                    break;
                }
                // Advisor Dashboard
                case 2: {
                    System.out.println("Enter Faculty ID");
                    int id = s.nextInt();
                    System.out.println("Enter Department Name");
                    String Dept = s.next();

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Dept, User,
                            Password);

                    Statement stmt = con.createStatement();

                    ResultSet rs = stmt.executeQuery(
                            "SELECT * FROM Results INNER JOIN Subjects ON Subjects.`Subject ID` = Results.`Subject ID` INNER JOIN Students ON Students.`Class ID`="
                                    + id);

                    System.out.println("===============================");
                    System.out.println("Student ID  Subject ID  Marks");
                    System.out.println("===============================");

                    while (rs.next()) {
                        System.out.println(
                                rs.getString(1) + "              " + rs.getString(2) + "         " + rs.getString(3));
                    }
                    System.out.println("===============================");
                    con.close();
                    break;
                }
                // Faculty Dashboard
                case 3: {
                    System.out.println("Enter Faculty ID");
                    int id = s.nextInt();
                    System.out.println("Enter Department Name");
                    String Dept = s.next();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Dept, User,
                            Password);

                    Statement stmt = con.createStatement();

                    String query = "SELECT * FROM Results INNER JOIN Subjects ON Subjects.`Subject ID` = Results.`Subject ID` WHERE Subjects.`Faculty ID`="
                            + id;

                    ResultSet rs = stmt.executeQuery(query);
                    System.out.println("==============================");
                    System.out.println("Student ID  Subject ID  Marks");
                    System.out.println("===============================");

                    while (rs.next()) {
                        System.out.println(
                                rs.getString(1) + "              " + rs.getString(2) + "         " + rs.getString(3));
                    }
                    System.out.println("===============================");
                    con.close();
                    break;
                }
                // Student Dashboard
                case 4: {
                    System.out.println("Enter Student ID");
                    int id = s.nextInt();
                    System.out.println("Enter Department Name");
                    String Dept = s.next();

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Dept, User,
                            Password);
                    Statement stmt = con.createStatement();

                    String query = "SELECT r.`Subject ID`, s.`Subject Code`, r.Mark FROM Results r LEFT JOIN Subjects s ON r.`Subject ID` = s.`Subject ID` WHERE r.`Student ID` = " + id; 

                    ResultSet rs = stmt.executeQuery(query);
                    
                    System.out.println("Student ID: "+ id);
                    System.out.println("=============================================");
                    System.out.println("Subject ID    Subject Code     Marks Obtained");
                    System.out.println("=============================================");
                    while (rs.next()) {
                        System.out.println("      " + rs.getString(1) + "            " + rs.getString(2) + "            " + rs.getString(3));
                    }
                    System.out.println("=============================================");
                    con.close();
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    void adminDashboard() {
        try {
            // MySQL Driver Init
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Fetch Data
            System.out.println("Enter Student ID");
            String studentid = s.next();
            System.out.println("Enter Department Name");
            String Dept = s.next();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Dept, User, Password);

            System.out.println("Actions that can be performed");
            System.out.println("1. Enter Student Marks");
            System.out.println("2. View Student Marks");
            System.out.println("3. Update Student Marks");
            int ID = s.nextInt();

            switch (ID) {
                case 1: {
                    System.out.println("Enter Subject ID");
                    String subject = s.next();
                    System.out.println("Enter Mark");
                    String marks = s.next();

                    PreparedStatement pstmt = con
                            .prepareStatement("INSERT INTO Results (`Student ID`,`Subject ID`,`Mark`) VALUES (?,?,?)");
                    pstmt.setString(1, studentid);
                    pstmt.setString(2, subject);
                    pstmt.setString(3, marks);
                    int count = pstmt.executeUpdate();
                    if (count > 0) {
                        System.out.println("===============");
                        System.out.println("Query Executed Successfully!");
                        System.out.println("===============");
                    } else {
                        System.out.println("Query Failed!");
                    }
                    con.close();
                    break;
                }
                case 2: {

                    Statement stmt = con.createStatement();

                    String query = "SELECT r.`Subject ID`, s.`Subject Code`, r.Mark FROM Results r LEFT JOIN Subjects s ON r.`Subject ID` = s.`Subject ID` WHERE r.`Student ID` = " + studentid; 

                    ResultSet rs = stmt.executeQuery(query);
                    
                    System.out.println("Student ID: "+ studentid);
                    System.out.println("=============================================");
                    System.out.println("Subject ID    Subject Code     Marks Obtained");
                    System.out.println("=============================================");
                    while (rs.next()) {
                        System.out.println("      " + rs.getString(1) + "            " + rs.getString(2) + "            " + rs.getString(3));
                    }
                    System.out.println("=============================================");
                    con.close();
                    break;
                }
                case 3: {
                    System.out.println("Enter Subject ID");
                    String subject = s.next();
                    System.out.println("Enter Mark");
                    String marks = s.next();

                    PreparedStatement pstmt = con.prepareStatement(
                            "UPDATE Results SET `Mark` = ? WHERE `Student ID`= ? AND `Subject ID`= ?");
                    pstmt.setString(1, marks);
                    pstmt.setString(2, studentid);
                    pstmt.setString(3, subject);

                    int count = pstmt.executeUpdate();
                    if (count > 0) {
                        System.out.println("===============");
                        System.out.println("Query Executed Successfully!");
                        System.out.println("===============");
                    } else {
                        System.out.println("Query Failed!");
                    }
                    con.close();
                    break;
                }
                default: {
                    System.out.println("Incorrect Option Selected");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}