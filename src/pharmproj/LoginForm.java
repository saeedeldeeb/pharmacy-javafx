/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmproj;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author computer market
 */
public class LoginForm extends Stage
{
    
    public LoginForm(){
        Button btn = new Button();
        btn.setText("Sign in");
        btn.setStyle("-fx-background-color: silver;-fx-padding:12px 20px;-fx-text-color:#FFF");
        Text welcometext = new Text("Hi doctor");
        welcometext.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        welcometext.setFill(Paint.valueOf("BLUE"));
        Text welcometext2 = new Text("Please, Sign in");
        welcometext2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        welcometext2.setFill(Paint.valueOf("GREEN"));
        Text usrnam = new Text("Enter your Username");
        usrnam.setFont(Font.font("Times New Roman", FontWeight.BOLD, 13));
        Text pass = new Text("Enter your Password");
        pass.setFont(Font.font("Times New Roman", FontWeight.BOLD, 13));
        TextField usr = new TextField();
        PasswordField pas = new PasswordField();

        GridPane root = new GridPane();
        root.setStyle("-fx-background-image: url('download.jpg');-fx-background-repeat: no-repeat;-fx-background-position: center;-fx-background-size: 400 250;");
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(0, 10, 0, 10));
        root.add(welcometext, 2, 1);
        root.add(welcometext2, 2, 2);
        root.add(usrnam, 1, 3);
        root.add(usr, 2, 3);
        root.add(pass, 1, 4);
        root.add(pas, 2, 4);
        root.add(btn, 3, 5);
        
        btn.setOnAction((ActionEvent event) -> {
            String us = usr.getText();
        String pa = pas.getText();
            if("saeed".equals(us)&&"123".equals(pa)){
                pharmacymainframe p = new pharmacymainframe();
                this.close();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Password");
            }
        });
        pas.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER))
            {
                String us = usr.getText();
                String pa = pas.getText();
                if("saeed@softizone.com".equals(us)&&"123".equals(pa)){
                    pharmacymainframe p = new pharmacymainframe();
                    this.close();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                }  
            }
        });
        
        Scene scene = new Scene(root, 400, 250);

        this.setTitle("Pharmacy!");
        this.setScene(scene);
        this.show();
      
    }
    
}
