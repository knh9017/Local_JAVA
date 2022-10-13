package Server;
import java.sql.*;
import java.util.Scanner;

public class ODBC {

    static Connection conn;
    static Statement stmt;

    public static void sql_con(String uid,String pwd)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";

            conn = DriverManager.getConnection(url, uid, pwd);
            stmt = conn.createStatement();
            System.out.println("Connection Success");
            
        }
        catch(ClassNotFoundException e){
            System.out.println("Failed to load driver");
        }
        catch(SQLException e){
            System.out.println("Error : " + e);
        }
    
    }

    public static void sql_close()
    {
        if( conn != null ){
            try{
                stmt.close();
                conn.close();
            }
            catch(SQLException e)
            {
                System.out.println("An error occured when closing.");
            }
        }
    }

    public static void DB_con() {

        Scanner sc = new Scanner(System.in);

        while(conn == null){
            System.out.print("ID : ");
            String uid = sc.next();
            System.out.print("Password : ");
            String pwd = sc. next();
            sql_con(uid,pwd);
            }

        sc.close();
    }
}