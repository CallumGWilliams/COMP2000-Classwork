import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Database {

    JFrame mainDataFrame = new JFrame();
    JPanel mainDataPanel = new JPanel();
    JPanel dataContainerPanel = new JPanel();
    JPanel databaseTopBar = new JPanel();
JButton newBtn = new JButton("ADD / UPDATE");
JButton returnBtn = new JButton("BACK");
    JPanel databaseBottomBar = new JPanel();

JTextField dataIdArea = new JTextField();
JTextArea dataStockArea = new JTextArea();
JTextArea dataPriceArea = new JTextArea();
JLabel dataIdLabel = new JLabel("ID");
JLabel dataStockLabel = new JLabel("STOCK");
JLabel dataPriceLabel = new JLabel("PRICE");


    JPanel loginPanel = new JPanel();
    JLabel usernameLbl = new JLabel("Username");
    JLabel passLbl = new JLabel("Password");
    JTextField userField = new JTextField();
    JTextField passField = new JTextField();

    void AddItemBtn(ActionListener listenForAddBtn){newBtn.addActionListener(listenForAddBtn);}



    void backBtn (ActionListener listenForBackBtn){returnBtn.addActionListener(listenForBackBtn);}

    public void loadDataGui(){

       System.out.println("Initiating database gui...");

       //this code initiates the database frame

    mainDataFrame.setPreferredSize(new Dimension(500,500));

    databaseTopBar.setBackground(Color.RED);
    databaseTopBar.setLayout(new GridLayout(0,2));
    databaseTopBar.add(newBtn);
    dataContainerPanel.setLayout(new BorderLayout());
    databaseTopBar.add(returnBtn);

    dataContainerPanel.add(databaseTopBar, BorderLayout.PAGE_START);
    dataContainerPanel.add(databaseBottomBar, BorderLayout.PAGE_END);

    databaseBottomBar.setLayout(new GridLayout(2,3));
    databaseBottomBar.add(dataIdLabel);
    databaseBottomBar.add(dataStockLabel);
    databaseBottomBar.add(dataPriceLabel);
    databaseBottomBar.add(dataIdArea);
    databaseBottomBar.add(dataStockArea);
    databaseBottomBar.add(dataPriceArea);

    dataContainerPanel.add(mainDataPanel, BorderLayout.CENTER);

    mainDataFrame.setContentPane(dataContainerPanel);
        mainDataFrame.setVisible(true);
    mainDataPanel.setLayout(new GridLayout(0,3));


    }

    public void createItem(String data){

        mainDataPanel.add(new JTextArea(data));
        System.out.println("creating item...");

    }

    public void clearItems(){
        mainDataFrame.dispose();

        //removes current items in display to ensure no duplicates

System.out.println(Arrays.toString(mainDataPanel.getComponents()));


        Component[] components = mainDataPanel.getComponents();

        for (Component component : components) {
            mainDataPanel.remove(component);
            System.out.println("Change detected! reloading file...");
        }

        mainDataPanel.revalidate();
        mainDataFrame.pack();
    }

    public void initLogin(){

        //initiate the login gui

        loginPanel.setLayout(new GridLayout(2,2));
        loginPanel.add(usernameLbl);
        loginPanel.add(userField);
        loginPanel.add(passLbl);
        loginPanel.add(passField);
        JOptionPane.showConfirmDialog(mainDataFrame, loginPanel,"login", JOptionPane.OK_CANCEL_OPTION);
    }


}


