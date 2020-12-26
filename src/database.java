import javax.swing.*;
import java.awt.*;
import java.util.List;

public class database {

    private String bread;
    private String milk;
    private String cider;
    private kioskView view;
    private kiosk model;
    private String[] productList;
    DefaultListModel<String> l1 = new DefaultListModel<>();
    JList<String> stockList = new JList<>();




    private String user = "bob";
    private String pass = "pass";


    public JList<String> showStock(){

        System.out.println(l1);
        return stockList;

    }

    public String addToStock(String input){

        l1.addElement(input);

        return input;
    }

    public void login(){

        JFrame data = new JFrame();
        data.setTitle("E-POS STOCK DATABASE");
        data.setBackground(Color.GREEN);
        data.setPreferredSize(new Dimension(500,500));
        data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        data.setVisible(true);
        data.pack();

        JPanel mp = new JPanel();
        mp.setLayout(new GridLayout(10,3));
        mp.setBackground(Color.RED);
        data.add(mp);
    }





    public String[] getProductList(){

        return productList;

    }

    public void setProductList(){
        this.productList = productList;
    }


    public String newItem(String x){


        return x;
    }
}
