/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package polinomio.pkg3.pkg0;

import java.util.Scanner;

public class Polinomio30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polinomio polinomio = new Polinomio();
        polinomio.agregarTermino(3, 4);
        polinomio.agregarTermino(-4, 2);
        polinomio.agregarTermino(11, 0);

        boolean salir = false;
        while (!salir) {
            System.out.print("Ingrese el valor de X (o 'V' para salir): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("V")) {
                salir = true;
            } else {
                try {
                    double x = Double.parseDouble(input);
                    double valor = polinomio.evaluar(x);
                    System.out.println("El valor del polinomio para X = " + x +
                            " es: " + valor);
                    System.out.println("------------------------------------"+
                            "--------");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese"+
                            " un número válido o 'q' para salir.");
                }
            }
        }
        scanner.close();
    }

    static class TerminoPolinomio {
        double coeficiente;
        int exponente;
        TerminoPolinomio siguiente;

        public TerminoPolinomio(double coeficiente, int exponente) {
            this.coeficiente = coeficiente;
            this.exponente = exponente;
            this.siguiente = null;
        }
    }

    static class Polinomio {
        TerminoPolinomio cabeza;

        public Polinomio() {
            this.cabeza = null;
        }

        public void agregarTermino(double coeficiente, int exponente) {
            TerminoPolinomio nuevoTermino = new TerminoPolinomio(coeficiente,
                    exponente);
            if (cabeza == null) {
                cabeza = nuevoTermino;
            } else {
                TerminoPolinomio temp = cabeza;
                while (temp.siguiente != null) {
                    temp = temp.siguiente;
                }
                temp.siguiente = nuevoTermino;
            }
        }

        public double evaluar(double x) {
            double resultado = 0;
            TerminoPolinomio temp = cabeza;
            while (temp != null) {
                resultado += temp.coeficiente * Math.pow(x, temp.exponente);
                temp = temp.siguiente;
            }
            return resultado;
        }
    }
}
