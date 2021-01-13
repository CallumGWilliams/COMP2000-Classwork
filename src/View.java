import com.sun.javaws.util.JfxHelper;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class View extends JFrame{
    JFrame homeFrame = new JFrame();
    JPanel homePanel = new JPanel();
    JPanel homeBottomBar = new JPanel();
    JTextField homeScanField = new JTextField();
    JButton homeGoDbBtn = new JButton("STOCK DATABASE");
    JButton homeGoPayBtn = new JButton("PAY");
    JTextArea RunningTotalLbl = new JTextArea();
    JPanel cartContainerPanel = new JPanel();
    Double price;

    void AccessDatabaseBtn(ActionListener listenForDbBtn) { homeGoDbBtn.addActionListener(listenForDbBtn); }

    //if statement to guarantee only one instance of the object is created

    void scanDataBtn(ActionListener listenForScan)
    { if (homeScanField.getActionListeners().length<1)  { homeScanField.addActionListener(listenForScan);}}


    void payBtn(ActionListener listenForPay)
    { if (homeGoPayBtn.getActionListeners().length<1){ homeGoPayBtn.addActionListener(listenForPay); }}


    public void initApp(){

        //initiate the homepage GUI
        System.out.println("Successfully received from Controller, Initiating gui...");
        homeFrame.setPreferredSize(new Dimension(550,750));
        homePanel .setLayout(new BorderLayout());
        cartContainerPanel.setLayout(new GridLayout(0,2));
        homeFrame.setTitle("Supermarket Scammers E-POS System");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        homeBottomBar.setLayout(new GridLayout(0,3));
        homeBottomBar.add(homeGoDbBtn);
        homeBottomBar.add(homeGoPayBtn);
        homeBottomBar.add(RunningTotalLbl);

        homeFrame.setContentPane(homePanel);
        homeFrame.setVisible(true);
        homeFrame.pack();
        homePanel.add(homeScanField, BorderLayout.PAGE_START);
        homePanel.add(homeBottomBar, BorderLayout.PAGE_END);
        homePanel.add(cartContainerPanel);





    }

    //takes itemId and price, and stores them within the shopping cart
    public void addToCart(String itemId, Double itemPrice) {

        cartContainerPanel.add(new JTextArea(itemId));
            cartContainerPanel.add(new JTextArea(String.valueOf(itemPrice)));
            homeFrame.pack();


    }

}
