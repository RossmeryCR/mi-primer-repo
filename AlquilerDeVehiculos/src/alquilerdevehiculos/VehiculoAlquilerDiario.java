/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquilerdevehiculos;

/**
 *
 * @author Rossmery CR
 */
public class VehiculoAlquilerDiario extends Vehiculo 
{
   private int diasAlquiler; // entre 1 y 90
   private double tarifaDiaria; //no puede ser negativa
   
   public VehiculoAlquilerDiario (int id, int diasAlquiler, double tarifaDiaria, String marca, String modelo, String placa )
   {
       super (id, marca, modelo,placa);
       setDiasAlquiler(diasAlquiler);
       setTarifaDiaria(tarifaDiaria);
   }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        if (diasAlquiler < 1 || diasAlquiler > 9) {  
            throw new IllegalArgumentException("Los días de alquiler debe estar entre 1 y 9");
        }
        
        this.diasAlquiler = diasAlquiler;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        if(tarifaDiaria < 0 )
            throw new IllegalArgumentException("No puede ser negativo");
        this.tarifaDiaria = tarifaDiaria;
    }
   
   @Override 
    public double calcularCostoAlquiler()
    {
       double costo = diasAlquiler * tarifaDiaria;
        if (diasAlquiler >= 7) {
        costo *= 0.90; // Aplica 10% de descuento
        }
         return costo;
    }

    @Override
    public void mostrarInformacion()
    {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│        ALQUILER DIARIO          |");
        System.out.println("└─────────────────────────────────────────┘");
        System.out.println("│ ID: " + getId());
        System.out.println("│ VEHICULO: " + getMarca() + " " + getModelo());
        System.out.println("│ PLACA: " + getPlaca());
        System.out.println("│ DIAS DE ALQUILER: " + diasAlquiler );
        System.out.println("│ TARIFA DIARIA: " + tarifaDiaria);
        System.out.println("│ COSTO TOTAL: " + calcularCostoAlquiler());
        System.out.println("└─────────────────────────────────────────┘");
    
    }
} 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

