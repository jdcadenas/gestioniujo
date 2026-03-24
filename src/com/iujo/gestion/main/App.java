package com.iujo.gestion.main;

import com.iujo.gestion.model.Estudiante;
import com.iujo.gestion.service.GestorIUJO;
import java.util.Scanner;

public class App {

    private static GestorIUJO<Estudiante> db = new GestorIUJO<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcion = 0;
        do {
            System.out.println("\n--- SISTEMA IUJO (Total: " + db.contar() + ") ---");
            System.out.print("1. Nuevo Estudiante\n2. Cargar Saldo\n3. Pagar Matrícula\n4. Listar\n5. Salir\nOpción: ");
            opcion = sc.nextInt();
            procesar(opcion);

        } while (opcion != 5);

    }

    private static void procesar(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    registrar();
                    break;
                case 2:
                    gestionarSaldo(true);
                    break;
                case 3:
                    gestionarSaldo(false);
                    break;
                case 4:
                    for (Estudiante e : db.obtenerTodos()) {
                        e.mostrarPerfil();
                    
                    }break;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registrar() {
        System.out.println("\n--- REGISTRAR NUEVO ESTUDIANTE ---");
        System.out.println("Nombre: ");
        String nombre = sc.next();
         

        System.out.println("Cédula: ");
        String cedula = sc.next();
        db.agregar(new Estudiante(nombre, cedula));

    }

    private static void gestionarSaldo(boolean esCarga) throws Exception {
        System.out.println("Cédula del estudiante");
        String id = sc.next();

        Estudiante encontrado = null;

        for (Estudiante e : db.obtenerTodos()) {
            if (e.getCedula().equals(id)) {
                encontrado = e;

            }
        }
        if (encontrado == null) {
            throw new Exception("Estudiante no encontrado");

        }
        System.out.print("Monto $: ");
        double m = sc.nextDouble();
        if (esCarga) {
            encontrado.recargarCuenta(m); 
        }else {
            encontrado.pagarInscripcion(m);
        }
        System.out.println("¡Operación exitosa!");

    }
}
