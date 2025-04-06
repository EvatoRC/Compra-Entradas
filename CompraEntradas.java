/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compraentradas;

import java.util.Scanner;

/**
 *
 * @author luisr
 */
public class CompraEntradas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de compra de entradas" + "\n");
        int opcion = 0;
        //precios entradas segun vimos:
        int vip = 30000;
        int plateaBaja = 15000;
        int plateaAlta = 18000;
        int palco = 13000;
        double desctoEstudiante =0.9;
        double desctoAdultoMayor=0.85;
        double precioEntrada;
        double totalEntrada;
        double totalFacturado = 0;
        int edad;

        while (opcion != 2) {
            System.out.println("Seleccione una de las siguientes opciones:" + "\n");
            System.out.println("1. Comprar entradas");
            System.out.println("2. Salir" + "\n");
            totalEntrada = 0;
            String tipoEntrada = "";
            String tipoDescuento = "";
            try {
                opcion = scanner.nextInt();

                if (opcion == 1) {

                    int tipoAsiento = 0;
                    boolean validador = false;
                    while (!validador) {
                        System.out.println("Seleccione el tipo de asiento" + "\n");
                        System.out.println("1. VIP");
                        System.out.println("2. Platea Baja");
                        System.out.println("3. Platea Alta");
                        System.out.println("4. Platea Baja" + "\n");
                        precioEntrada = 0;
                        try {
                            tipoAsiento = scanner.nextInt();
                            switch (tipoAsiento) {
                                case 1:
                                    tipoEntrada = "VIP";
                                    precioEntrada = vip;
                                    break;
                                case 2:
                                    tipoEntrada = "Platea Baja";
                                    precioEntrada = plateaBaja;
                                    break;
                                case 3:
                                    tipoEntrada = "Platea Alta";
                                    precioEntrada = plateaAlta;
                                    break;
                                case 4:
                                    tipoEntrada = "Palco";
                                    precioEntrada = palco;
                                    break;
                                default:
                                    System.out.println("Tipo de dato no válido");
                                    continue;
                            }
                        } catch (Exception e) {
                            System.out.println("Tipo de dato no válido");
                            scanner.nextLine();
                            validador= true;
                        }
                        System.out.println("Ingrese su edad");
                        edad = scanner.nextInt();
                        if (edad > 0 && edad <= 17) {
                            tipoDescuento = "10% Estudiante";
                            totalEntrada = precioEntrada * desctoEstudiante; //cálculo de precio entrada según descuento
                        } else if (edad >= 18 && edad <= 64) {
                            totalEntrada = precioEntrada;
                            tipoDescuento = "Sin descuento";
                        } else if (edad >= 65 && edad <= 120) {
                            tipoDescuento = "15% descuento Aduto mayor";
                            totalEntrada = precioEntrada * desctoAdultoMayor;//cálculo de precio entrada según descuento
                        } else {
                            System.out.println("Edad no válida"+"\n");
                            precioEntrada = 0;
                            tipoEntrada="No Aplica";
                            tipoDescuento="No Aplica";
                            validador = true;
                        }
                        System.out.println("Tipo de entrada: " + tipoEntrada);
                        System.out.println("Precio Base Entrada: " + precioEntrada);
                        System.out.println("Tipo de descuento: " + tipoDescuento);
                        System.out.println("Valor Entrada: " + totalEntrada + "\n");

                        totalFacturado = totalFacturado + totalEntrada;
                        validador = true;
                    }
                } else if (opcion == 2) {
                    System.out.println("Total a pagar: " + totalFacturado + "\n");
                    System.out.println("Hasta pronto!");
                } else {
                    System.out.println("Opción no válida, por favor ingresa 1 o 2.");
                }

            } catch (Exception e) {
                System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }
}
