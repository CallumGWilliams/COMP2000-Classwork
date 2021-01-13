import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;


public class payLoader extends Controller implements Runnable {
    Pay pay = new Pay();

    public payLoader(Model model, View view) throws IOException {
        super(model, view);

        pay.payCardListener(new payCard());
        pay.payCashListener(new payCash());
        pay.authBtnListener(new authBtn());
        pay.cancelBtnListener(new cancelBtn());
        pay.backBtnListener(new backBtn());
    }


    public class authBtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if (pay.paymentMethod.equals("CASH")){

                model.calcChange(model.Total, Double.parseDouble(pay.enterPrice.getText()));
                pay.changeArea.setText(model.getCalcChange().toString());
            }
            run();
        }
    }

    public class cancelBtn implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"the transaction has been cancelled","TranVoid", JOptionPane.INFORMATION_MESSAGE);
            model.shoppingCart.clear();
            pay.disposeFrame();
            pay.payFrame.setVisible(false);
            initApp();
            pay.pack();
            pay.dispose();
        }
    }

    public class payCard implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pay.initCardScreen();
        }
    }

    public class payCash implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            pay.initCashScreen();
        }
    }
public class backBtn implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        pay.disposeFrame();
    }
}
    public void initApp(){
        pay.initPay();
        pay.totalPrice.setText(String.valueOf(model.Total));
    }

    public void initReceipt(){
        System.out.println("Printing receipt...");

    }

    @Override
    public void run() {

        //thread to create receipt


        System.out.println("RECEIPT:");
        JFrame receiptFrame = new JFrame();
        JPanel receiptPanel = new JPanel();
        JLabel companyName = new JLabel("Supermarket Scammers Ltd.");
        JLabel date = new JLabel();
        JLabel payM = new JLabel();
        JLabel total = new JLabel("T");
        JLabel change = new JLabel("C");
        JLabel spacer = new JLabel("========================");
        JTextArea items = new JTextArea();

        date.setText(LocalDateTime.now().toString());
        payM.setText(pay.paymentMethod);
    total.setText("Total: " + model.Total);
    change.setText("Change: " + (pay.changeArea.getText()));
        receiptFrame.setContentPane(receiptPanel);
        receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));

        for (String i : model.shoppingCart.keySet()){
            items.append(i);
            items.append(" ");
            items.append(String.valueOf(model.shoppingCart.get(i)));
        }


        receiptPanel.add(companyName);
        receiptPanel.add(date);

        receiptPanel.add(spacer);
        receiptPanel.add(items);
        receiptPanel.add(total);
        receiptPanel.add(payM);

        if (payM.getText().equals("CASH")) {
            receiptPanel.add(change);
        }




        receiptFrame.setTitle("Receipt");
        receiptFrame.setPreferredSize(new Dimension(350,600));
        receiptFrame.setVisible(true);
        receiptFrame.pack();

    }

}