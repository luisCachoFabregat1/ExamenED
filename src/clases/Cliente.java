package clases;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {

    // Atributos de la clase Cliente
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private Date fechaDeAlta;
    private ArrayList<Pedido> historial;
    private Pedido pedidoCliente;

    // Lista estática de clientes (compartida por todas las instancias)
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    // Constructor con parámetros
    public Cliente(String nombre, String apellidos, String telefono, String direccion) {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setFechaDeAlta(new Date()); // Fecha actual
        this.historial = new ArrayList<>(); // Historial individual para cada cliente
    }

    // Constructor por defecto
    public Cliente() {
        this.setFechaDeAlta(new Date());
        this.historial = new ArrayList<>();
    }

    // Getters y setters...

    // Método para agregar un pedido al historial
    public void agregarPedidoHistorial(Pedido nuevoPedido) {
        if (nuevoPedido != null && nuevoPedido.getEstado() == 0) {
            System.out.println("Error al añadir el pedido al historial");
        } else {
            historial.add(nuevoPedido);
        }
    }

    // Método para mostrar los clientes
    public static void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(((Cliente) cliente).getNombre() + " : " + ((Cliente) cliente).getApellidos() + " : " + cliente.getTelefono());
        }
    }

    // Método para agregar clientes a la lista
    public static void agregarClientes(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
        }
    }

    // Método para eliminar un cliente
    public static void eliminarCliente() {
        // Implementación del método con manejo adecuado de Scanner y excepciones
    }

	public Pedido getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(Pedido pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	public void menuCliente() {
		
	}


}
