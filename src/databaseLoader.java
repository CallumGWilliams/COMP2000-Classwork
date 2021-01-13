import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class databaseLoader extends Controller {

    Database database = new Database();

    //create loader objects //get filepath
    String path = "src/Stocks.txt";
    String line = "";


    public databaseLoader(Model model, View view) throws IOException {
        super(model, view);

        view.AccessDatabaseBtn(new listenForDbBtn());


        database.AddItemBtn(new listenForAddBtn());
        database.backBtn(new listenForBackBtn());
    }

    public class listenForBackBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            database.mainDataFrame.dispose();
        }
    }

    public class listenForAddBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Creating object...");
            try {
                addToFile();
                database.dataIdArea.setText("");
                database.dataStockArea.setText("");
                database.dataPriceArea.setText("");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void checkLogin() throws IOException {

        database.initLogin();

        if (database.userField.getText().equals(user) && database.passField.getText().equals(pass)) {
            loadData();

            System.out.println("Login successful...");
        } else
            JOptionPane.showMessageDialog(null, "Incorrect credentials!", "Authentication error", JOptionPane.ERROR_MESSAGE);
    }


    public void addToFile() throws IOException {

        //empties showed data to allow modification
        database.mainDataPanel.removeAll();


        BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
        System.out.println("Adding to file...");

        //check to ensure the product doesn't already exist
        if (!model.data.contains(database.dataIdArea.getText())) {

                //check to ensure fields are not null
            if (database.dataIdArea.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter an ID", "No item selected", JOptionPane.ERROR_MESSAGE);}
            else if (!database.dataStockArea.getText().equals("") && !database.dataPriceArea.getText().equals("")){
                bw.append(database.dataIdArea.getText());
                bw.newLine();
                bw.append(database.dataStockArea.getText());
                bw.newLine();
                bw.append(database.dataPriceArea.getText());
                bw.newLine();
                bw.close();
            }
            else JOptionPane.showMessageDialog(null, "please input stock and price", "Missing info", JOptionPane.ERROR_MESSAGE);

            database.clearItems();
            loadData();

        }

        else editFile();

    }

    public void editFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));

        for (int index = 0; index < model.data.size(); index++) {

            String i = model.data.get(index);

            if (i.equals(database.dataIdArea.getText())) {
                model.data.set(index, database.dataIdArea.getText());
                model.data.set(index + 1, database.dataStockArea.getText());
                model.data.set(index + 2, database.dataPriceArea.getText());
            }

            bw.write(i);
            bw.newLine();
        }

        bw.close();
        database.clearItems();
        loadData();
    }


    public void loadData() throws IOException {

        database.loadDataGui();
        model.data.clear();


        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null){
                model.data.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < model.data.size(); i++){

            String data = model.data.get(i);
            database.createItem(data);

        }


        database.mainDataFrame.pack();
        database.mainDataFrame.setVisible(true);

    }



}

