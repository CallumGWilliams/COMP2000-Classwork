import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kioskView {


    public void initApp(){

        JFrame f = new JFrame();
        f.setTitle("CALLUM G-W E-POS SYSTEM ");
        f.setPreferredSize(new Dimension(500,500));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(1,2));

        //left side display.
        JPanel itemDisplay = new JPanel();
        itemDisplay.setBackground(Color.PINK);
        f.add(itemDisplay);
        itemDisplay.setLayout(new GridLayout(15,3));

        JLabel itemLbl = new JLabel();
        itemLbl.setText("Shopping cart");
        itemDisplay.add(itemLbl);


        //right side display
        JPanel addItemArea = new JPanel();
        addItemArea.setBackground(Color.BLUE);
        f.add(addItemArea);
        addItemArea.setLayout(new GridLayout(14,2));

        //add label for text box
        JLabel scanLabel = new JLabel();
        scanLabel.setText("scan or enter product ID");
        addItemArea.add(scanLabel);

        //add text box to right side
        JTextField scanArea = new JTextField();
        //scanArea.setText("enter product ID");
        addItemArea.add(scanArea);
        scanArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String x = scanArea.getText();

                    JTextArea item = new JTextArea();
                    item.setText(scanArea.getText());
                    itemDisplay.add(item);
                    f.pack();
                    scanArea.setText("");

            }

        });

        JLabel spacer1 = new JLabel();
        addItemArea.add(spacer1);

        JButton payCard = new JButton();
        payCard.setText("Pay with card");
        addItemArea.add(payCard);

        JLabel spacer2 = new JLabel();
        addItemArea.add(spacer2);
        JButton payCash = new JButton();
        payCash.setText("Pay with cash");
        addItemArea.add(payCash);

        JLabel spacer3 = new JLabel();
        addItemArea.add(spacer3);
        JLabel lblAccessStock = new JLabel();
        lblAccessStock.setText("Input login details to access stock");
        addItemArea.add(lblAccessStock);


        JTextField userArea = new JTextField();
        JLabel lblUser = new JLabel();
        lblUser.setText("Username");
        addItemArea.add(lblUser);
        addItemArea.add(userArea);

        JTextField passArea = new JTextField();
        JLabel lblPass = new JLabel();
        lblPass.setText("Password");
        addItemArea.add(lblPass);
        addItemArea.add(passArea);

        JLabel spacer4 = new JLabel();
        addItemArea.add(spacer4);
        JButton loginBtn = new JButton();
        loginBtn.setText("LOGIN");
        addItemArea.add(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(passArea.getText().equals("Password") && userArea.getText().equals("bob"))
                {
                    System.out.println("successful login");
                    database d = new database();
                    d.login();
                    spacer4.setText("LOGIN SUCCESSFUL");
                    passArea.setText("");
                    userArea.setText("");
                }
                else spacer4.setText("INCORRECT USERNAME OR PASSWORD");
                passArea.setText("");
                userArea.setText("");

            }
        });



       /*

        JLabel quantityLbl = new JLabel();
        quantityLbl.setText("quantity");
        addItemArea.add(quantityLbl);

        JTextField quantityField = new JTextField();
        addItemArea.add(quantityField);


        */





        f.pack();
        f.setVisible(true);


    }
}
