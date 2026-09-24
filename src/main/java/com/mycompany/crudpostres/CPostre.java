/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudpostres;

/**
 *
 * @author PC-822
 */
public class CPostre {
     private String textura;
    private String sabor;
    private String nombre;
    private double precio;

    
    public CPostre() {
    }

    public CPostre(String textura, String sabor, String nombre, double precio) {
        this.textura = textura;
        this.sabor = sabor;
        this.nombre = nombre;
        this.precio = precio;
    }

   
    public void preparar() {
        System.out.println("Preparando un delicioso " + nombre + " con sabor a " + sabor + "...");
    }

    public void comer() {
        System.out.println("Te estás comiendo el " + nombre );
    }

    public void vender() {
        System.out.println("El postre " + nombre + " ha sido vendido por S/. " + precio);
    }

    public String getTextura() {
        return textura;
    }

    public void setColor(String color) {
        this.textura= textura;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    @Override
    public String toString() {
        return nombre + " | Sabor: " + sabor + " | Color: " + textura + " | Precio: S/. " + precio;
    }
}



