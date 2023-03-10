import javax.swing.JOptionPane;

public class DatosPersona {
    public static String leerDato(String dato) {
        String input = JOptionPane.showInputDialog("Ingrese su " + dato);
        return input;
    }

    public static boolean validarFechaNacimiento(String fechaNacimiento) {
        if (fechaNacimiento.length() != 10) {
            JOptionPane.showMessageDialog(null, "❌ La fecha de nacimiento debe tener el formato dd-mm-aaaa");
            return false;
        }
        if (fechaNacimiento.charAt(2) != '-' || fechaNacimiento.charAt(5) != '-') {
            JOptionPane.showMessageDialog(null, "❌ La fecha de nacimiento debe tener el formato dd-mm-aaaa");
            return false;
        }
        return true;
    }

    public static boolean validarDato(String dato, String tipo) {
        if (dato == null || dato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❌ No ingresó: " + tipo);
            return false;
        }

        if (tipo.equals("fecha de nacimiento")) {
            return validarFechaNacimiento(dato);
        }

        return true;
    }

    public static String[] leerDatos(String[] datos) {
        String[] datosPersona = new String[datos.length];
        for (int i = 0; i < datos.length; i++) {
            datosPersona[i] = leerDato(datos[i]);
            while (!validarDato(datosPersona[i], datos[i])) {
                datosPersona[i] = leerDato(datos[i]);
            }
        }
        return datosPersona;
    }

    public static double calcularIMC(String peso, String estatura) {
        double pesoDouble = Double.parseDouble(peso);
        double estaturaDouble = Double.parseDouble(estatura);
        double imc = pesoDouble / (estaturaDouble * estaturaDouble);
        return imc;
    }

    public static String estadoIMC(double imc) {
        String estado = "";
        if (imc < 18.5) {
            estado = "Bajo de peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            estado = "Normal";
        } else if (imc >= 25 && imc <= 29.9) {
            estado = "Sobrepeso";
        } else if (imc >= 30) {
            estado = "Obeso";
        }
        return estado;
    }

    public static String calcularSignoZodiacal(String fechaNacimiento) {

        String signoZodiacal = "";
        String mes = fechaNacimiento.substring(3, 5);
        String dia = fechaNacimiento.substring(0, 2);
        int mesInt = Integer.parseInt(mes);
        int diaInt = Integer.parseInt(dia);

        switch (mesInt) {
            case 1:
                if (diaInt >= 21) {
                    signoZodiacal = "Acuario";
                } else {
                    signoZodiacal = "Capricornio";
                }
                break;
            case 2:
                if (diaInt >= 20) {
                    signoZodiacal = "Piscis";
                } else {
                    signoZodiacal = "Acuario";
                }
                break;
            case 3:
                if (diaInt >= 21) {
                    signoZodiacal = "Aries";
                } else {
                    signoZodiacal = "Piscis";
                }
                break;
            case 4:
                if (diaInt >= 21) {
                    signoZodiacal = "Tauro";
                } else {
                    signoZodiacal = "Aries";
                }
                break;
            case 5:
                if (diaInt >= 21) {
                    signoZodiacal = "Géminis";
                } else {
                    signoZodiacal = "Tauro";
                }
                break;
            case 6:
                if (diaInt >= 22) {
                    signoZodiacal = "Cáncer";
                } else {
                    signoZodiacal = "Géminis";
                }
                break;
            case 7:
                if (diaInt >= 23) {
                    signoZodiacal = "Leo";
                } else {
                    signoZodiacal = "Cáncer";
                }
                break;
            case 8:
                if (diaInt >= 23) {
                    signoZodiacal = "Virgo";
                } else {
                    signoZodiacal = "Leo";
                }
                break;
            case 9:
                if (diaInt >= 23) {
                    signoZodiacal = "Libra";
                } else {
                    signoZodiacal = "Virgo";
                }
                break;
            case 10:
                if (diaInt >= 23) {
                    signoZodiacal = "Escorpio";
                } else {
                    signoZodiacal = "Libra";
                }
                break;
            case 11:
                if (diaInt >= 23) {
                    signoZodiacal = "Sagitario";
                } else {
                    signoZodiacal = "Escorpio";
                }
                break;
            case 12:
                if (diaInt >= 22) {
                    signoZodiacal = "Capricornio";
                } else {
                    signoZodiacal = "Sagitario";
                }
                break;
            default:
                signoZodiacal = "No se encontró el signo zodiacal";
                break;
        }

        return signoZodiacal;
    }

    public static void main(String[] args) throws Exception {
        String[] datos = { "nombres", "teléfono", "correo", "documento", "fecha de nacimiento", "edad", "peso",
                "estatura" };
        String[] datosPersona = leerDatos(datos);
        String nombres = datosPersona[0];
        String telefono = datosPersona[1];
        String correo = datosPersona[2];
        String documento = datosPersona[3];
        String fechaNacimiento = datosPersona[4];
        String edad = datosPersona[5];
        String peso = datosPersona[6];
        String estatura = datosPersona[7];

        double imc = calcularIMC(peso, estatura);
        String estadoIMC = estadoIMC(imc);

        String signoZodiacal = calcularSignoZodiacal(fechaNacimiento);

        JOptionPane.showMessageDialog(null, "👤 Datos de la persona: "
                + "\n👤 Nombres: " + nombres
                + "\n📞 Teléfono: " + telefono
                + "\n📧 Correo: " + correo
                + "\n📄 Documento: " + documento
                + "\n📅 Fecha de nacimiento: " + fechaNacimiento
                + "\n👶 Edad: " + edad
                + "\n🏋️ Peso: " + peso
                + "\n📏 Estatura: " + estatura
                + "\n📊 IMC: " + imc
                + "\n📊 Estado IMC: " + estadoIMC
                + "\n🌟 Signo zodiacal: " + signoZodiacal);

    }
}