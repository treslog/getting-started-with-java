
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Boton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Boton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hiciste click");
            }
        });
        frame.add(button);
        frame.setVisible(true);
    }
}