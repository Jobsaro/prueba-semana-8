/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasemana8_ejercicio2;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class PruebaSemana8_Ejercicio2 {

    // Método para calcular el valor presente de una anualidad ordinaria o vencida
    public static double calcularAnualidadOrdinaria(double R, double i, int n) {
        return R * (1 - Math.pow(1 + i, -n)) / i;
    }

    // Método para calcular el valor presente de una anualidad anticipada
    public static double calcularAnualidadAnticipada(double R, double i, int n) {
        return R * (1 + i) * (1 - Math.pow(1 + i, -n)) / i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar información al usuario
        System.out.println("----ANUALIDAD----"
                + "\n1.Ordinaria "
                + "\n2.Anticipada"
                + "\nIngrese el tipo de anualidad: ");
        int tipoAnualidad = scanner.nextInt();

        System.out.print("Ingrese el valor de la renta (R): ");
        double renta = scanner.nextDouble();

        System.out.print("Ingrese la tasa de interEs (i): ");
        double tasaInteres = scanner.nextDouble();

        System.out.print("Ingrese el numero de pagos (n): ");
        int numPagos = scanner.nextInt();

        double valorPresente = 0;

        // Calcular el valor presente dependiendo del tipo de anualidad
        if (tipoAnualidad == 1) {
            valorPresente = calcularAnualidadOrdinaria(renta, tasaInteres, numPagos);
            System.out.printf("El valor presente de la anualidad ordinaria es: %.2f\n", valorPresente);
        } else if (tipoAnualidad == 2) {
            valorPresente = calcularAnualidadAnticipada(renta, tasaInteres, numPagos);
            System.out.printf("El valor presente de la anualidad anticipada es: %.2f\n", valorPresente);
        } else {
            System.out.println("Tipo de anualidad no valido.");
        }
    }
}

