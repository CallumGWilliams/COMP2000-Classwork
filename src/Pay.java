import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Pay extends View {
    JFrame payFrame = new JFrame();
    JPanel cardPanel = new JPanel();
    JPanel cashPanel = new JPanel();
    JPanel choosePayment = new JPanel();
    JButton cardBtn = new JButton("PAY WITH CARD");
    JButton cashBtn = new JButton("PAY WITH CASH");
    JButton authorizeTran = new JButton("AUTHORIZE TRANSACTION");
    JButton cancelTran = new JButton("CANCEL TRANSACTION");
    JTextArea totalPrice = new JTextArea();
    JButton backBtn = new JButton("RETURN");

    JLabel costLbl = new JLabel("Total price:");

    JTextField enterPrice = new JTextField();
    JLabel enterPriceLbl = new JLabel("Cash given:");

    JTextArea changeArea = new JTextArea();
    JLabel changeLbl = new JLabel("Change:");
    String paymentMethod = "";





    public void initPay(){



        payFrame.setPreferredSize(new Dimension(500,200));

        choosePayment.add(cardBtn);
        choosePayment.add(backBtn);
        choosePayment.add(cashBtn);

        payFrame.setContentPane(choosePayment);
        payFrame.setVisible(true);
        payFrame.pack();





    }

    public void initCardScreen(){

        paymentMethod = "CARD";
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
cardPanel.add(new JLabel("Total to pay:"));
        cardPanel.add(totalPrice);
        cardPanel.add(authorizeTran);

        cardPanel.add(cancelTran);




        payFrame.setContentPane(cardPanel);
        payFrame.pack();

    }

    public void initCashScreen(){

        paymentMethod = "CASH";
        cashPanel.setLayout(new GridLayout(0,4));
        cashPanel.add(costLbl);
        cashPanel.add(enterPriceLbl);
        cashPanel.add(changeLbl);
        cashPanel.add(cancelTran);

        cashPanel.add(totalPrice);
        cashPanel.add(enterPrice);
        cashPanel.add(changeArea);
        cashPanel.add(authorizeTran);

        payFrame.setContentPane(cashPanel);
        payFrame.pack();
    }

    void payCardListener(ActionListener payCardListener){cardBtn.addActionListener(payCardListener);}

    void payCashListener(ActionListener payCashListener){cashBtn.addActionListener(payCashListener);}

    void authBtnListener(ActionListener authBtnListener){authorizeTran.addActionListener(authBtnListener);}

    void cancelBtnListener(ActionListener cancelBtnListener){cancelTran.addActionListener(cancelBtnListener);}

    void backBtnListener(ActionListener backBtnListener){backBtn.addActionListener(backBtnListener);}

    public void disposeFrame(){
        payFrame.dispose();
        payFrame.setVisible(false);
    }

}
