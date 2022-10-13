package Server;
import java.sql.*;
import java.security.NoSuchAlgorithmException;




public class accounts {
    private ResultSet rs_uid;
    private SHA256 sha256 = new SHA256();

    public void signup(String uid, String pwd)
    {
        
        if(ODBC.conn != null)
        {
            try
            {
                rs_uid = ODBC.stmt.executeQuery("Select uid from mem");
                while(rs_uid.next())
                {
                    if(!rs_uid.getString(rs_uid.getRow()).equals(uid))
                    {
                        try
                        {
                            String en_pwd = sha256.encrypt(pwd);
                            ODBC.stmt.executeQuery("Insert into mem ("+uid+","+en_pwd+",to_date(sysdate,'yyyy.mm.dd hh24:mi)') values (uid,pwd,reg_date)");
                        }
                        catch(NoSuchAlgorithmException e)
                        {
                            System.out.println(e);
                        }
                    }
                    else
                    {
                        System.out.println("This ID already exists. Insert another ID.");
                    }
                }
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }
    }

    public void signin(String uid, String pwd)
    {
        
    }
}
