import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Homepage {

  JFrame homepage = new JFrame();
  JPanel p = new JPanel();

    public void loadHomepage(){
homepage.setPreferredSize(new Dimension(500,500));
p.setBackground(Color.RED);
homepage.setContentPane(p);

    homepage.setVisible(true);
    homepage.pack();
    }

}
