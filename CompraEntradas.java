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
        System.out.println("Bienvenido al sistema de compra de entradas");
        
        int opcion = 0;
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
        
    //entradas
        String entrada1_tipo="";
        String entrada1_descuento="";
        double entrada1_valor=0;
        boolean entrada1_registrada=false;
        
        String entrada2_tipo="";
        String entrada2_descuento="";
        double entrada2_valor=0;
        boolean entrada2_registrada=false;
        
        String entrada3_tipo="";
        String entrada3_descuento="";
        double entrada3_valor=0;
        boolean entrada3_registrada=false;
        
        String entrada4_tipo="";
        String entrada4_descuento="";
        double entrada4_valor=0;
        boolean entrada4_registrada=false;
        
        while (opcion != 5) {
            System.out.println("\nSeleccione una de las siguientes opciones:" + "\n");
            System.out.println("1. Comprar entradas");
            System.out.println("2. Ver Promociones");
            System.out.println("3. Buscar Entrada");
            System.out.println("4. Eliminar Entrada");
            System.out.println("5. Salir" + "\n");
            
            
            try {
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    
                    if (entrada1_registrada && entrada2_registrada && entrada3_registrada && entrada4_registrada) {
                        System.out.println("No hay más entradas disponibles");
                        continue;
                    }
                    String tipoEntrada = "";
                    String tipoDescuento = "";
                    int tipoAsiento = 0;
                    boolean validador = false;
                    precioEntrada = 0;
                    totalEntrada = 0;
                    
                    while (!validador) {
                        System.out.println("\nSeleccione el tipo de asiento" + "\n");
                        System.out.println("1. VIP");
                        System.out.println("2. Platea Baja");
                        System.out.println("3. Platea Alta");
                        System.out.println("4. Platea Baja" + "\n");
                        
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
                                    System.out.println("Opción no válida");
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
                            continue;
                        }
                        
                        System.out.println("Tipo de entrada: " + tipoEntrada);
                        System.out.println("Precio Base Entrada: " + precioEntrada);
                        System.out.println("Tipo de descuento: " + tipoDescuento);
                        System.out.println("Valor Entrada: " + totalEntrada + "\n");
                //almacenar entradas
                        if (!entrada1_registrada) {
                            entrada1_tipo=tipoEntrada;
                            entrada1_descuento=tipoDescuento;
                            entrada1_valor=totalEntrada;
                            entrada1_registrada=true;
                        }else if (!entrada2_registrada) {
                            entrada2_tipo=tipoEntrada;
                            entrada2_descuento=tipoDescuento;
                            entrada2_valor=totalEntrada;
                            entrada2_registrada=true;
                        }else if (!entrada3_registrada) {
                            entrada3_tipo=tipoEntrada;
                            entrada3_descuento=tipoDescuento;
                            entrada3_valor=totalEntrada;
                            entrada3_registrada=true;
                        }else if (!entrada4_registrada) {
                            entrada4_tipo=tipoEntrada;
                            entrada4_descuento=tipoDescuento;
                            entrada4_valor=totalEntrada;
                            entrada4_registrada=true;
                        }

                        totalFacturado = totalFacturado + totalEntrada;
                        validador = true;
                    }
            //Promociones:
                }else if (opcion == 2){
                    System.out.println("Promociones Disponibles: \n");
                    System.out.println(" - 10% Estudiantes");
                    System.out.println(" - 15% Adulto Mayor\n");
                    
            //Buscar:
                }else if (opcion == 3){
                    System.out.println("\nEntradas Almacenadas:\n");
                    if (entrada1_registrada) {
                        System.out.println("Entrada 1: ");
                        System.out.println("    Tipo        : "+entrada1_tipo);
                        System.out.println("    Descuento   : "+entrada1_descuento);
                        System.out.println("    Valor       : "+entrada1_valor);
                    }
                    if (entrada2_registrada) {
                        System.out.println("Entrada 2: ");
                        System.out.println("    Tipo        : "+entrada2_tipo);
                        System.out.println("    Descuento   : "+entrada2_descuento);
                        System.out.println("    Valor       : "+entrada2_valor);
                    }
                    if (entrada3_registrada) {
                        System.out.println("Entrada 3: ");
                        System.out.println("    Tipo        : "+entrada3_tipo);
                        System.out.println("    Descuento   : "+entrada3_descuento);
                        System.out.println("    Valor       : "+entrada3_valor);
                    }
                    if (entrada4_registrada) {
                        System.out.println("Entrada 4: ");
                        System.out.println("    Tipo        : "+entrada4_tipo);
                        System.out.println("    Descuento   : "+entrada4_descuento);
                        System.out.println("    Valor       : "+entrada4_valor);
                    }
                    if (!entrada1_registrada && !entrada2_registrada && !entrada3_registrada && !entrada4_registrada) {
                        System.out.println("No hay entradas almacenadas");
                    }
                    
                    
            //Eliminar:        
                }else if (opcion == 4){
                    System.out.println("Ingrese entrada a eliminar: ");
                 //mostrar almacenadas   
                    if (entrada1_registrada) {
                        System.out.println("1: "+ entrada1_tipo+ " | "+entrada1_descuento+" | "+entrada1_valor);
                    }
                    if (entrada2_registrada) {
                        System.out.println("2: "+ entrada2_tipo+ " | "+entrada2_descuento+" | "+entrada2_valor);
                    }
                    if (entrada3_registrada) {
                        System.out.println("3: "+ entrada3_tipo+ " | "+entrada3_descuento+" | "+entrada3_valor);
                    }
                    if (entrada4_registrada) {
                        System.out.println("4: "+ entrada4_tipo+ " | "+entrada4_descuento+" | "+entrada4_valor);
                    }
                    if (!entrada1_registrada && !entrada2_registrada && !entrada3_registrada && !entrada4_registrada) {
                        System.out.println("No hay entradas almacenadas");
                    }
                //solicitar eliminacion:    
                    int eliminar= scanner.nextInt();
                    scanner.nextLine();
                    
                    if (eliminar == 1 && entrada1_registrada) {
                        totalFacturado= totalFacturado-entrada1_valor;
                        entrada1_tipo="";
                        entrada1_descuento="";
                        entrada1_valor=0;
                        entrada1_registrada=false;
                        System.out.println("Entrada 1 eliminada");
                    } else if (eliminar == 2 && entrada2_registrada) {
                        
                        totalFacturado= totalFacturado-entrada2_valor;
                        entrada2_tipo="";
                        entrada2_descuento="";
                        entrada2_valor=0;
                        entrada2_registrada=false;
                        System.out.println("Entrada 2 eliminada");
                        
                    }else if (eliminar == 3 && entrada3_registrada) {
                        
                        totalFacturado= totalFacturado-entrada3_valor;
                        entrada3_tipo="";
                        entrada3_descuento="";
                        entrada3_valor=0;
                        entrada3_registrada=false;
                        System.out.println("Entrada 3 eliminada");
                        
                    }else if (eliminar == 4 && entrada4_registrada) {
                        
                        totalFacturado= totalFacturado-entrada4_valor;
                        entrada4_tipo="";
                        entrada4_descuento="";
                        entrada4_valor=0;
                        entrada4_registrada=false;
                        System.out.println("Entrada 4 eliminada");
                    }else  {
                        System.out.println("Número de entrada no válido");
                    }
                    
            //Salir        
                } else if (opcion == 5) {
                    System.out.println("\nSu total a pagar es: " + totalFacturado + "\n");
                    System.out.println("Disfrute la función");
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