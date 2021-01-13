import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    public Model model;
    private View view;
    public String user = "bob";
    public String pass = "pass";




    public void initApp(){
        view.initApp();
        System.out.println("Controller initiating app...");
    }


    public Controller(Model model, View view) throws IOException {
        this.model = model;
        this.view = view;

        this.view.AccessDatabaseBtn(new listenForDbBtn());
        this.view.scanDataBtn(new listenForScan());
        this.view.payBtn(new listenForPay());
    }

    public class listenForPay implements ActionListener{
//loads payLoader controller class

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                payLoader pl = new payLoader(model,view);
                pl.initApp();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public class listenForDbBtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                databaseLoader dbl = new databaseLoader(model,view);
                dbl.checkLogin();


                System.out.println("Authentication required...");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<String> getData(){
        return model.data;
    }

    public Integer getArrayCount(){
        return model.data.size();
    }

    public Double getTotalPrice(){
        return model.Total;
    }
    public class listenForScan implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            //make sure the product exists within the database
            if (model.data.contains(view.homeScanField.getText())) {
                String item = view.homeScanField.getText();
                view.addToCart(item, model.getItemPrice(item));
                model.shoppingCart.put(item, model.getItemPrice(item));
                view.RunningTotalLbl.setText(String.valueOf(model.Total += model.getItemPrice(item)));
                view.homeScanField.setText("");
            }
            else JOptionPane.showMessageDialog(null,"invalid product, please try again");
        }
    }

}

