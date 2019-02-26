/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmproj;

import DataBase.data;
import DataBase.dbcontrol;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author computer market
 */
public class pharmacymainframe extends Stage {
boolean f= true;
int reduceq;
int p;
int q;
 int left;
 String co;
    HBox hb0 = new HBox();
    HBox hb1 = new HBox();
    VBox vb = new VBox();
    VBox vb1 = new VBox();
    HBox hb = new HBox();
    TableView<data> tv = new TableView();
    dbcontrol dbcontrol = new dbcontrol();
    data d = new data();
    TextField tf1;
    TextField tf2;
    TextField tf3;
    TextField tf4;
    int tempID;
int count;
    public void editsize() {
        dbcontrol dc = new dbcontrol();
        TextField searchield = new TextField();
        searchield.setPromptText("Search for Drugs......");
        Button searchbtn = new Button("Search");
        searchbtn.setStyle("-fx-background-color:#3498db;-fx-text-fill:#FFF");
        hb.getChildren().addAll(searchield, searchbtn);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(5);
        Label control = new Label("Drugs Control Panel");
        control.setStyle("-fx-font-size: 30px;-fx-text-fill:#FFF");
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();

        tf1.setPromptText("Drug name");
        tf2.setPromptText("Quantity");
        tf3.setPromptText("Price");
        tf4.setPromptText("Company Name");

        Button bt2 = new Button("Update");
        Button bt3 = new Button("Delete");
        Button bt4 = new Button("Add");
        Button bt5 = new Button("Sell a Drug");
        bt2.setStyle("-fx-background-color:#3498db;-fx-font-size:18;-fx-text-fill:#FFF");
        bt3.setStyle("-fx-background-color:#3498db;-fx-font-size:18;-fx-text-fill:#FFF");
        bt4.setStyle("-fx-background-color:#3498db;-fx-font-size:18;-fx-text-fill:#FFF");
        bt5.setStyle("-fx-background-color:#3498db;-fx-font-size:18;-fx-padding:8px 40px;-fx-text-fill:#FFF");
        Image im = new Image("images.png");
        ImageView imv = new ImageView(im);
        hb1.getChildren().addAll(bt4, bt2, bt3);
        hb1.setSpacing(15);
        hb1.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(control, hb, bt5, hb1, tf1, tf2, tf3, tf4, imv);
        vb.prefWidthProperty().bind(hb0.widthProperty().divide(3));
        vb.setPadding(new Insets(20));
        vb.setSpacing(15);
        vb.setStyle("-fx-background-color:#43c14e");
        vb.setAlignment(Pos.CENTER);
        bt4.setOnAction((ActionEvent event) -> {
            d.setName(tf1.getText());
            d.setQuantity(Integer.parseInt(tf2.getText()));
            d.setPrice(Integer.parseInt(tf3.getText()));
            d.setConame(tf4.getText());
            dc.insert(d);
            tv.setItems(dbcontrol.selectM());

            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
        });
        bt2.setOnMouseClicked(e -> {
            data datupd = new data();
            datupd.setId(tempID);
            datupd.setName(tf1.getText());
            datupd.setQuantity(Integer.parseInt(tf2.getText()));
            datupd.setPrice(Integer.parseInt(tf3.getText()));
            datupd.setConame(tf4.getText());
            dc.update(datupd);
            tv.setItems(dc.selectM());
        });
        bt3.setOnMouseClicked(e -> {
            dc.delete(tempID);
            tv.setItems(dc.selectM());

        });
        searchbtn.setOnMouseClicked(e -> {
            if (searchield.getText() == null) {
                tv.setItems(dc.selectM());
            }

            tv.setItems(dc.searth(searchield.getText()));
        });
        searchield.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                if (searchield.getText() == null) {
                    tv.setItems(dc.selectM());
                }

                tv.setItems(dc.searth(searchield.getText()));

            }
        });
        bt5.setOnMouseClicked(e -> {
            data dat = tv.getSelectionModel().getSelectedItem();
            tf1.setPromptText("Drug ID");
            tf2.setPromptText("Quantity");
            tf3.setPromptText("Paid");
            tf4.setPromptText("The Rest");
             tf1.setText(dat.getName());
             tf2.setText("");
             tf3.setText("");
             tf4.setText("");
             q=(dat.getQuantity());
            
            p=(dat.getPrice());
            
           
            co=(dat.getConame());
            tempID = dat.getId();
            tf4.setEditable(false);
            f= true;
        });
        tf3.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                reduceq = q - Integer.parseInt(tf2.getText());
                left = Integer.parseInt(tf3.getText())-p;
                 tf4.setText(left+"");
                 data datup = new data();
            datup.setId(tempID);
            datup.setName(tf1.getText());
            datup.setQuantity(reduceq);
            datup.setPrice(p);
            datup.setConame(co);
            dc.update(datup);
            tv.setItems(dc.selectM());

            }
        });

        

    }

    public void viewsize() {
        Label drug = new Label("Drugs view");
        Button logout = new Button("LOGOUT");
        logout.setStyle("-fx-background-color:#e74c3c;-fx-font-size:18;-fx-text-fill:#FFF");
        logout.setOnAction((ActionEvent event) -> {
            LoginForm log = new LoginForm();
            this.close();
        });
        drug.setStyle("-fx-font-size: 30px;-fx-text-fill:#3498db");
        TableColumn<data, Integer> colid = new TableColumn("ID");
        TableColumn<data, String> colname = new TableColumn("Name");
        TableColumn<data, Integer> colquantity = new TableColumn("Quantity");
        TableColumn<data, Integer> colprice = new TableColumn("Price");
        TableColumn<data, String> colcompany = new TableColumn("Company");

        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colcompany.setCellValueFactory(new PropertyValueFactory<>("coname"));

        tv.getColumns().addAll(colid, colname, colquantity, colprice, colcompany);
        tv.setItems(dbcontrol.selectM());
//        tv.setItems();
        vb1.getChildren().addAll(logout, drug, tv);
        vb1.setStyle("-fx-background-color:#ecf0f1");
        vb1.prefWidthProperty().bind(hb0.widthProperty().subtract(hb0.widthProperty().divide(3)));
        
        tv.setOnMouseClicked(e -> {
            data dat = tv.getSelectionModel().getSelectedItem();
            tf1.setText(dat.getName());
            tf2.setText(dat.getQuantity() + "");
            tf3.setText(dat.getPrice() + "");
            tf4.setText(dat.getConame());
            tempID = dat.getId();
            
           
               
            });
 
        
            
    }

    public pharmacymainframe() {
        this.editsize();
        this.viewsize();

        hb0.getChildren().addAll(vb1, vb);
        Scene s = new Scene(hb0, 1366, 600);
        this.setScene(s);
        this.show();
        this.setTitle("Control Panel");
    }

}
