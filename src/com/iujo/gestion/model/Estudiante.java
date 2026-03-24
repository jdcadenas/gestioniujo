package com.iujo.gestion.model;


public class Estudiante extends Persona {
    private double balanceCuenta;

    public Estudiante(String nombre, String cedula) {
        super(nombre, cedula);     
    }

    public void pagarInscripcion(double monto) throws Exception{
        if(monto  > balanceCuenta){
            throw new Exception("Saldo insuficiente  ( $"+balanceCuenta+")");   
        }
        balanceCuenta -= monto;
        }

        public void recargarCuenta(double monto){
            balanceCuenta +=monto;
        }

        @Override
        public void mostrarPerfil(){
            System.out.println("[ID: " + getCedula() + "] " + getNombre() + " | Saldo: $" + balanceCuenta);
        }

    }
