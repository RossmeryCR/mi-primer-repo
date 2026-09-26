/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alquilerdevehiculos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Rossmery CR
 */
public class main {
 private static ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int contadorId = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
         System.out.println("═══════════════════════════════════════════");
        System.out.println("   SISTEMA DE GESTIÓN DE EMPLEADOS");
        System.out.println("         TechSolutions - 2026");
        System.out.println("═══════════════════════════════════════════");
        
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    agregarVehiculoporkilometraje();
                    break;
                case 3:
                    listarVehiculos();
                    break;
                case 4:
                    mostrarCostodevehiculo();
                    break;
                case 5:
                    salir = true;
                    System.out.println("\n¡Gracias por usar el sistema! Hasta luego.");
                    break;
                default:
                    System.out.println("\n Opción inválida. Por favor, ingrese una opción del 1 al 5.");
            }
        }
        scanner.close();
    }
     private static void mostrarMenu() {
        System.out.println("\n───────────────────────────────────────────");
        System.out.println("              MENÚ PRINCIPAL");
        System.out.println("───────────────────────────────────────────");
        System.out.println("1. Agregar Vehiculo");
        System.out.println("2. Agregar Vehiculo por kilometraje ");
        System.out.println("3. Listar todos los vehiculos");
        System.out.println("4. Calcular costo de un vehiculo desde su id ");
        System.out.println("5. Salir");
        System.out.print("\n➡ Elija una opción: ");
    }
      private static int leerOpcion() {
        int opcion = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.print(" Error: Debe ingresar un número. Intente nuevamente: ");
                scanner.nextLine(); // Limpiar buffer
            }
        }
        return opcion;
    }
      // Método para leer double con manejo de errores
    private static double leerDouble(String mensaje) {
        double valor = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextDouble();
                scanner.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.print(" Error: Debe ingresar un número válido. ");
                scanner.nextLine();
            }
        }
        return valor;
    }
      // Método para leer entero con manejo de errores
    private static int leerEntero(String mensaje) {
        int valor = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextInt();
                scanner.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.print(" Error: Debe ingresar un número entero. ");
                scanner.nextLine();
            }
        }
        return valor;
    }
     private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
     // Método para agregar empleado de tiempo completo
    private static void agregarVehiculo() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("   REGISTRO - DE VEHICULO   ");
        System.out.println("═══════════════════════════════════════════");
        
        try {
             int dAlquiler = leerEntero("Ingrese los dias de Alquiler: ");
            Double tarDiaria = leerDouble("Ingrese la tarifa diaria: ");
            String Marca = leerTexto("Ingrese la Marca :");
            String Modelo = leerTexto("Ingrese el modelo :");
            String Placa = leerTexto("Ingrese la placa de 5 a 8 caracteres :");
            VehiculoAlquilerDiario vehiculo = new VehiculoAlquilerDiario(
                contadorId++, dAlquiler,tarDiaria,  Marca,Modelo,Placa
            );
            
            listaVehiculo.add(vehiculo);
            System.out.println("\n ¡Vehiculo registrado exitosamente!");
            vehiculo.mostrarInformacion();
            
        } catch (IllegalArgumentException e) {
            System.out.println("\n Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n Error inesperado: " + e.getMessage());
        }
    }
    private static void agregarVehiculoporkilometraje() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("   REGISTRO - DE VEHICULO POR KILOMETRO   ");
        System.out.println("═══════════════════════════════════════════");
        
        try {
             int kmRecorrido = leerEntero("Ingrese los kilometros recorridos: ");
            Double tarifaKm = leerDouble("Ingrese la tarifa por kilometro: ");
            String Marca = leerTexto("Ingrese la Marca :");
            String Modelo = leerTexto("Ingrese el modelo :");
            String Placa = leerTexto("Ingrese la placa de 5 a 8 caracteres :");
            VehiculoAlquilerDiario vehiculo = new VehiculoAlquilerDiario(
                contadorId++, kmRecorrido,tarifaKm,  Marca,Modelo,Placa
            );
            
            listaVehiculo.add(vehiculo);
            System.out.println("\n ¡Vehiculo registrado exitosamente!");
            vehiculo.mostrarInformacion();
            
        } catch (IllegalArgumentException e) {
            System.out.println("\n Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n Error inesperado: " + e.getMessage());
        }
    }
    //Metodo para agragar empleado por horas
     private static void listarVehiculos() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("         LISTA DE VEHICULOS");
        System.out.println("═══════════════════════════════════════════");
        
        if (listaVehiculo.isEmpty()) {
            System.out.println("\n No hay vehiculos registrados en el sistema.");
            return;
        }
        
        System.out.println("\nTotal de vehiculos: " + listaVehiculo.size());
        System.out.println("───────────────────────────────────────────\n");
        
        for (Vehiculo emp : listaVehiculo) {
            emp.mostrarInformacion();
            System.out.println();
        }
    }
      private static void mostrarCostodevehiculo() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("        CÁLCULO DE SALARIO");
        System.out.println("═══════════════════════════════════════════");
        
        if (listaVehiculo.isEmpty()) {
            System.out.println("\n No hay vehiculos registrados. Registre vehiculos primero.");
            return;
        }
        
        int idBuscado = leerEntero("\nIngrese el ID : ");
        Vehiculo vehiculoEncontrado = null;
        
        for (Vehiculo emp : listaVehiculo) {
            if (emp.getId() == idBuscado) {
                vehiculoEncontrado = emp;
                break;
            }
        }
        
        if (vehiculoEncontrado != null) {
            System.out.println("\n Vehiculo encontrado:");
            vehiculoEncontrado.mostrarInformacion();
            System.out.println("\n Costo del Vehiculo: S/ " + 
                String.format("%.2f", vehiculoEncontrado.calcularCostoAlquiler()));
        } else {
            System.out.println("\n No se encontró un vehiculo con ID: " + idBuscado);
        }
    }
}
