/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author computer market
 */
public class dbcon {
   private static Connection conc;
   private dbcon(){
       
   }
   public static Connection getConnection(){
       if(conc==null){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           conc=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/saeeddb", "root", "");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(dbcon.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(dbcon.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
       return conc;
   }
   public static void dbdiscon(){
       if(conc!=null)
           conc=null;
   }
    
}
