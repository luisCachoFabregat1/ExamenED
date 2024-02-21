package clases;

import java.util.Scanner;

public class GestionPedidos {

    static Pedido pedido1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validar val = new Validar();

        while (true) {
            System.out.println(" ----- RESTAURANTE ----- ");
            String telefono = obtenerTelefonoValido(sc, val);
            Cliente cliente = val.buscarTelfCliente(telefono);

            if (cliente == null) {
                cliente = registrarNuevoCliente(sc, val, telefono);
                Cliente.agregarClientes(cliente);
            }
            
            cliente.menuCliente();
        }
    }

    private static String obtenerTelefonoValido(Scanner sc, Validar val) {
        String telefono;
        do {
            System.out.print("Introduce el teléfono del cliente: ");
            telefono = sc.nextLine();
        } while (!val.validarTelefono(telefono));
        return telefono;
    }

    private static Cliente registrarNuevoCliente(Scanner sc, Validar val, String telefono) {
        System.out.print("Introduce el nombre del cliente: ");
        String nombre = obtenerCadenaValida(sc, val);
        
        System.out.print("Introduce los apellidos del cliente: ");
        String apellidos = obtenerCadenaValida(sc, val);

        System.out.print("Introduce la dirección del cliente: ");
        String direccion = sc.nextLine();

        return new Cliente(nombre, apellidos, telefono, direccion);
    }

    private static String obtenerCadenaValida(Scanner sc, Validar val) {
        String cadena;
        do {
            cadena = sc.nextLine();
        } while (!val.validarCadena(cadena));
        return cadena;
    }
}
