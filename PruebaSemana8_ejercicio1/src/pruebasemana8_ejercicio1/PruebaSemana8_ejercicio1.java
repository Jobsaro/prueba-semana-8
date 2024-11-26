/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasemana8_ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class PruebaSemana8_ejercicio1 {

    // Método para ingresar los precios del día
    public static double[] ingresarPrecios(Scanner scanner) {
        double[] precios = new double[6];  // 3 precios de comida + 3 precios de extras
        
        System.out.println("Precios del dia");
        System.out.print("Precio de comida economica: $");
        precios[0] = scanner.nextDouble();
        System.out.print("Precio de comida regular: $");
        precios[1] = scanner.nextDouble();
        System.out.print("Precio de comida premium: $");
        precios[2] = scanner.nextDouble();
        
        System.out.print("Precio extra de Queso: $");
        precios[3] = scanner.nextDouble();
        System.out.print("Precio extra de Paque. Tortillas: $");
        precios[4] = scanner.nextDouble();
        System.out.print("Precio extra de arroz con pollo: $");
        precios[5] = scanner.nextDouble();
        
        return precios;
    }

    // Método para aplicar descuento
    public static double aplicarDescuento(double total, String tipoCliente) {
        double descuento = 0;
        if (tipoCliente.equals("1")) {
            descuento = 0.15;  // 15% de descuento
        } else if (tipoCliente.equals("2")) {
            descuento = 0.25;  // 25% de descuento
        }
        return total - (total * descuento);
    }

    // Método para facturar un pedido
    public static double facturarPedido(double[] precios, Scanner scanner) {
        // Solicitar datos del cliente
        System.out.print("\nIngrese el nombre completo del cliente: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        String nombreCliente = scanner.nextLine();
        
        System.out.print("Ingrese la direccion del cliente: ");
        String direccionCliente = scanner.nextLine();
        
        System.out.print("Ingrese el numero de telefono del cliente: ");
        String telefonoCliente = scanner.nextLine();
        
        // Mostrar datos del cliente
        System.out.println("\nDatos del cliente:");
        System.out.println("Nombre: " + nombreCliente);
        System.out.println("Dirección: " + direccionCliente);
        System.out.println("Teléfono: " + telefonoCliente);
        
        // Solicitar tipo de comida
        System.out.println("\nQue tipo de comida desea?");
        System.out.print("----MENU----"
                + "\n1.economica, "
                + "\n2.regular, "
                + "\n3.premium"
                + "\nElija una opcion: ");
        String tipoComida = scanner.next().toLowerCase();
        
        int comidaIndex = -1;
        if (tipoComida.equals("1")) {
            comidaIndex = 0;
        } else if (tipoComida.equals("2")) {
            comidaIndex = 1;
        } else if (tipoComida.equals("3")) {
            comidaIndex = 2;
        }
        
        if (comidaIndex == -1) {
            System.out.println("Opcion no valida. Intente de nuevo.");
            return 0;
        }

        System.out.println("\nQue extras desea? (escriba 'x' para no elegir extras)");
        System.out.print("Elija entre "
                + "\n1.Extra de Queso "
                + "\n2.Extra de Paque. Tortillas"
                + "\n3.Extra de arroz con pollo"
                + "\nIngrese extra(escriba 'x' para no elegir extras: )");
        String extras = scanner.next().toLowerCase();
        
        double total = precios[comidaIndex];
        
        if (extras.contains("1")) {
            total += precios[3];
        }
        if (extras.contains("2")) {
            total += precios[4];
        }
        if (extras.contains("3")) {
            total += precios[5];
        }

        System.out.println("\n----cliente----"
                + "\n1.Frecuente"
                + "\n2.Tercera edad"
                + "\nQue tipo de cliente es?(ingrese 'x' si no es ninguno): ");
        String tipoCliente = scanner.next().toLowerCase();
        total = aplicarDescuento(total, tipoCliente);

        System.out.printf("\nTotal a pagar: $%.2f\n", total);
        return total;
    }

    // Método para mostrar resumen de ventas
    public static void resumenVentas(ArrayList<Double> ventasTotales) {
        double totalVentas = 0;
        for (double venta : ventasTotales) {
            totalVentas += venta;
        }

        System.out.println("\nResumen de ventas del dia:");
        System.out.printf("Total de ventas: $%.2f\n", totalVentas);
        System.out.printf("Total de pedidos: %d\n", ventasTotales.size());
        if (ventasTotales.size() > 0) {
            System.out.printf("Venta promedio por pedido: $%.2f\n", totalVentas / ventasTotales.size());
        } else {
            System.out.println("No se realizaron ventas.");
        }
    }

    // Método principal del programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> ventasTotales = new ArrayList<>();
        
        // Ingresar los precios del día
        double[] precios = ingresarPrecios(scanner);

        while (true) {
            System.out.println("\n----MENU----"
                    + "\n1. Facturar un pedido");
            System.out.println("2. Salir y mostrar resumen de ventas"
                    + "Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            
            if (opcion == 1) {
                double total = facturarPedido(precios, scanner);
                if (total > 0) {
                    ventasTotales.add(total);
                }
            } else if (opcion == 2) {
                resumenVentas(ventasTotales);
                break;
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }
}