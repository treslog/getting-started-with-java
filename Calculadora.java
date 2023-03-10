
import javax.swing.JOptionPane;

public class Calculadora {
    private static double sumar(double a, double b) {
        return a + b;
    }

    private static double restar(double a, double b) {
        return a - b;
    }

    private static double multiplicar(double a, double b) {
        return a * b;
    }

    private static double dividir(double a, double b) {
        if (b == 0) {
            JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");
            throw new ArithmeticException("No se puede dividir entre 0");
        }
        return a / b;
    }

    private static double hacerOperacion(double a, double b, String operacion) {
        switch (operacion) {
            case "+":
                return sumar(a, b);
            case "-":
                return restar(a, b);
            case "*":
                return multiplicar(a, b);
            case "/":
                return dividir(a, b);
            default:
                JOptionPane.showMessageDialog(null, "Operación no válida");
                return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        String inputA = JOptionPane.showInputDialog("Ingrese el primer número");
        double a = Double.parseDouble(inputA);
        String inputB = JOptionPane.showInputDialog("Ingrese el segundo número");
        double b = Double.parseDouble(inputB);
        String inputOperacion = JOptionPane.showInputDialog("Ingrese la operación a realizar (+, -, *, /)");
        double resultado = hacerOperacion(a, b, inputOperacion);
        JOptionPane.showMessageDialog(null, "👾 El resultado es " + resultado);
    }
}