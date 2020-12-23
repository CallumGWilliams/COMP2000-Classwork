import javax.swing.*;
import java.awt.*;

public class view {

    public void printItemID(String itemId, String itemStock){

        JFrame j = new JFrame();
        JPanel p = new JPanel();
        JTextArea item = new JTextArea();
        JTextArea stock = new JTextArea();
        JLabel itemLabel = new JLabel();
        JLabel stockLabel = new JLabel();

        p.add(item);

        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setPreferredSize(new Dimension(700,700));
        j.add(p);
        p.setLayout(new GridLayout(2,10));


        stockLabel.setText("QUANTITY");
        itemLabel.setText("ITEM");
        p.add(itemLabel);


        item.setText(itemId);
        p.add(item);

        stock.setText(itemStock);
        p.add(stock);

        j.add(p);
        j.pack();
        j.setVisible(true);


        p.add(stockLabel);




    }


}
