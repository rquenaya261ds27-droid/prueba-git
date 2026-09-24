/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.crudpostres;

/**
 *
 * @author PC-822
 */
import java.util.Scanner;

public class CRUDPostres {

    static CPostre[] listaPostres;
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("**********MENU***************");
            System.out.println("1. Registrar nuevo Postre");
            System.out.println("2. Mostrar Postres");
            System.out.println("3. Eliminar Postre");
            System.out.println("4. Actualizar Postre");
            System.out.println("5. Salir del Sistema");
            System.out.println("*****************************");
            System.out.println("Ingrese la opción:");

            if (lector.hasNextInt()) {
                opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {
                    case 1:
                        registrarPostre();
                        break;
                    case 2:
                        mostrarPostres();
                        break;
                    case 3:
                        eliminarPostre();
                        break;
                    case 4:
                        actualizarPostre();
                        //subMenu();
                        break;
                    case 5:
                        System.out.println("Saliendo de la gestión de postres...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                lector.nextLine();

            }
        }
    }

    private static void subMenu() {
        System.out.println("********** SUBMENU***************");
        System.out.println("1. Nuevo nombre ");
        System.out.println("2. Nuevo sabor ");
        System.out.println("3. Nueva textura ");
        System.out.println("4. Nuevo precio ");
        System.out.println("5. Salir del Sistema");
        System.out.println("*****************************");
        System.out.println("Ingrese la opción:");
    }

    private static void registrarPostre() {

        System.out.println("Ingrese el nombre del postre:");
        String nombreT = lector.nextLine();
        System.out.println("Ingrese el sabor del postre:");
        String saborT = lector.nextLine();
        System.out.println("Ingrese la textura del postre(cremoso,esponjoso,crujiente):");
        String texturaT = lector.nextLine();
        System.out.println("Ingrese el precio del postre:");
        double precioT = lector.nextDouble();
        lector.nextLine();

        if (listaPostres == null) {

            listaPostres = new CPostre[1];
            listaPostres[0] = new CPostre(texturaT, saborT, nombreT, precioT);
            System.out.println("¡Primer postre registrado y listo para preparar!");
        } else {

            int tamañoActual = listaPostres.length;
            CPostre[] arrTemporal = new CPostre[tamañoActual + 1];

            for (int i = 0; i < listaPostres.length; i++) {
                arrTemporal[i] = listaPostres[i];
            }

            arrTemporal[arrTemporal.length - 1] = new CPostre(texturaT, saborT, nombreT, precioT);
            listaPostres = arrTemporal;
            System.out.println("¡Postre registrado con éxito!");
        }
    }

    private static void mostrarPostres() {
        if (listaPostres == null || listaPostres.length == 0) {
            System.out.println("No hay postres registrados.");
            return;
        }

        System.out.println("****************************************************************");
        System.out.println("* NOMBRE -  SABOR - TEXTURA - PRECIO *");
        for (int i = 0; i < listaPostres.length; i++) {
            System.out.println(listaPostres[i].toString());
        }
    }

    private static void eliminarPostre() {
        if (listaPostres == null || listaPostres.length == 0) {
            System.out.println("No hay postres registrados para eliminar.");
            return;
        }

        System.out.println("Ingrese el nombre del postre a eliminar:");
        String EliminarN = lector.nextLine();

        int cantEliminar = 0;

        for (int i = 0; i < listaPostres.length; i++) {
            if (EliminarN.equalsIgnoreCase(listaPostres[i].getNombre())) {
                cantEliminar++;
            }
        }

        if (cantEliminar > 0) {
            CPostre[] arrTemporal = new CPostre[listaPostres.length - cantEliminar];
            int eliminados = 0;

            for (int i = 0; i < listaPostres.length; i++) {
                if (EliminarN.equalsIgnoreCase(listaPostres[i].getNombre())) {
                    eliminados++;
                } else {
                    arrTemporal[i - eliminados] = listaPostres[i];
                }
            }
            listaPostres = arrTemporal;
            System.out.println("Postre eliminado correctamente. Cantidad: " + cantEliminar);
        } else {
            System.out.println("No se encontró ningún postre llamado: " + EliminarN);
        }
    }

    private static void actualizarPostre() {
        if (listaPostres == null || listaPostres.length == 0) {
            System.out.println("No hay postres registrados para actualizar.");
            return;
        }

        System.out.println("Ingrese el nombre del postre que desea actualizar:");
        String BuscarN = lector.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < listaPostres.length; i++) {
            if (BuscarN.equalsIgnoreCase(listaPostres[i].getNombre())) {
                encontrado = true;
                int opcion2 = lector.nextInt();
                subMenu();
                System.out.println("Postre encontrado: " + listaPostres[i].getNombre());
                System.out.println("--- Ingrese las nuevas características ---");
                switch (opcion2) {
                    case 1:
                        System.out.println("Nuevo Nombre:");
                        String nuevoNombre = lector.nextLine();
                        listaPostres[i].setSabor(nuevoNombre);
                        break;
                    case 2:
                        System.out.println("Nuevo sabor:");
                        String nuevoSabor = lector.nextLine();
                        listaPostres[i].setSabor(nuevoSabor);
                    case 3:
                        System.out.println("Nueva textura(cremoso,crujiente,:");
                        String nuevaTextura = lector.nextLine();
                        listaPostres[i].setColor(nuevaTextura);
                    case 4:
                        System.out.println("Nuevo precio:");
                        double nuevoPrecio = lector.nextDouble();
                        lector.nextLine();
                        listaPostres[i].setPrecio(nuevoPrecio);
                    
                    default:
                        System.out.println("Saliendo del sistema...");
                }
                

                System.out.println("¡Características del postre actualizadas con éxito!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún postre con ese nombre.");
        }
    }

}
