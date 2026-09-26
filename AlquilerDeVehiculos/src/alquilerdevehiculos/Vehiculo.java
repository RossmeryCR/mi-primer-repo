/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquilerdevehiculos;

/**
 *
 * @author Rossmery CR
 */
 abstract class Vehiculo 
{
    private int id;
    private String marca;
    private String modelo;
    private String placa;

    public Vehiculo(int id, String marca, String modelo, String placa) 
    {
        setId(id);
        setMarca(marca);
        setModelo(modelo);
        setPlaca(placa);
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        if (id <= 0) {throw new IllegalArgumentException("El ID debe ser un número positivo.");}
        this.id = id;
    }

    public String getMarca() 
    {
        return marca;
    }

    public void setMarca(String marca) 
    {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacío.");
        }
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío.");
        }
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) 
    {
        if (placa == null || !placa.matches("^[a-zA-Z0-9]{5,8}$")) {
            throw new IllegalArgumentException(
                    "La placa debe tener entre 5 y 8 caracteres alfanuméricos"
            );
        }
        this.placa = placa;
    }
    
    public abstract double calcularCostoAlquiler();
    
    public void mostrarInformacion()
    {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│       DATOS DEL VEHICULO        |");
        System.out.println("└─────────────────────────────────────────┘");
        System.out.println("│ ID: " + id);
        System.out.println("│ MARCA: " + marca);
        System.out.println("│ MODELO: " + modelo);
        System.out.println("│ PLACA: " + placa);
        System.out.println("└─────────────────────────────────────────┘");
    }
}
// Comentario agregado para practicar Git
