import javax.swing.JOptionPane;

public class Pago {
    public static void main(String[] args) throws Exception {
        String input = JOptionPane.showInputDialog("Enter a number");
        double number = Double.parseDouble(input);
        JOptionPane.showMessageDialog(null, "👾 The double is " + number * 2);
    }
}