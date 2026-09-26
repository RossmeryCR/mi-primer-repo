/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquilerdevehiculos;

/**
 *
 * @author Aracely
 */
public class VehiculoAlquilerKilometraje extends Vehiculo {
     private int kilometrosRecorridos;
    private double tarifaPorKm;

    public VehiculoAlquilerKilometraje(int kilometrosRecorridos, double tarifaPorKm, int id, String marca, String modelo, String placa) {
        super(id, marca, modelo, placa);
        setKilometrosRecorridos(kilometrosRecorridos);
        setTarifaPorKm(tarifaPorKm); 
}
 public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }
 public void setKilometrosRecorridos(int kilometrosRecorridos) {
        if (kilometrosRecorridos < 0 || kilometrosRecorridos > 5000) {  
            throw new IllegalArgumentException("Los días de alquiler debe estar entre 0 y 5000");
        } 
 }
         public double getTarifaPorKm() {
        return tarifaPorKm;
    }

    public void setTarifaPorKm(double tarifaPorKm) {
        if (tarifaPorKm < 0) {
            throw new IllegalArgumentException("No puede ser negativo.");  }
    }
     
    @Override 
    public double calcularCostoAlquiler()
    {
       double costo = kilometrosRecorridos * tarifaPorKm;
       return costo;
    }
    
    @Override
    public void mostrarInformacion()
    {
        System.out.println("┌──────────────────────────────────────────┐");
        System.out.println("│        ALQUILER POR KILOMETRAJE     |");
        System.out.println("└──────────────────────────────────────────┘");
        System.out.println("│ ID: " + getId());
        System.out.println("│ VEHICULO: " + getMarca() + " " + getModelo());
        System.out.println("│ PLACA: " + getPlaca());
        System.out.println("│ KILOMETROS RECORRIDOS: " + kilometrosRecorridos );
        System.out.println("│ TARIFA POR KILOMETRO: S/" + tarifaPorKm);
        System.out.println("│ COSTO TOTAL: " + calcularCostoAlquiler());
        System.out.println("└───────────────────────────────────────────┘");
    
    }

    }


