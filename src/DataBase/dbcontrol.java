/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author computer market
 */
public class dbcontrol {
    Statement s;
   public int myquan=0;

   
    public void insert(data d){
        try {
            s=dbcon.getConnection().createStatement();
            s.executeUpdate("insert into pharmacy (name,quantity,price,coname) values('"+d.getName()+"',"+d.getQuantity()+","+d.getPrice()+",'"+d.getConame()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(dbcontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(data d){
        try {
            s=dbcon.getConnection().createStatement();
            s.executeUpdate("update pharmacy set name = '"+d.getName()+"',quantity="+d.getQuantity()+",price="+d.getPrice()+",coname='"+d.getConame()+"' where id ="+d.getId()+" ");
        } catch (SQLException ex) {
            Logger.getLogger(dbcontrol.class.getName()).log(Level.SEVERE, null, ex);
        }}
   
    
    public void delete(int id){
         try {
            s=dbcon.getConnection().createStatement();
            s.executeUpdate("delete from pharmacy where id="+id+" ");
        } catch (SQLException ex) {
            Logger.getLogger(dbcontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ObservableList<data> selectM(){
      ObservableList<data> dbdata = FXCollections.observableArrayList();
      
        try {
            s = dbcon.getConnection().createStatement();
            ResultSet result = s.executeQuery("select * from pharmacy");
            result.beforeFirst();
            
            while (result.next()) {
data d = new data();
d.setId(result.getInt(1));
d.setName(result.getString(2));
d.setQuantity(result.getInt(3));
d.setPrice(result.getInt(4));
d.setConame(result.getString(5));
dbdata.add(d);
                System.out.println(d);

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbcontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbdata;
    }
   public ObservableList<data> searth(String name){
      ObservableList<data> dbdata = FXCollections.observableArrayList();
      
        try {
            s = dbcon.getConnection().createStatement();
            ResultSet result = s.executeQuery("select * from pharmacy where name like'"+name+"%'");
            result.beforeFirst();
            
            while (result.next()) {
data d = new data();
d.setId(result.getInt(1));
d.setName(result.getString(2));
d.setQuantity(result.getInt(3));
d.setPrice(result.getInt(4));
d.setConame(result.getString(5));
dbdata.add(d);
                System.out.println(d);

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbcontrol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbdata;
    }
   
}
