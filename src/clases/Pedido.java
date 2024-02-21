/**
 * 
 */
package clases;

/**
*@author luiscachofabregat
*
*
 */
import java.util.*;

public class Pedido {


    /**
     * Atributos
     */
    private Date FechaHora = new Date();
    static ArrayList<Producto> pedidoCliente;
    ArrayList<Producto> cartaProducto = new ArrayList<>();
    private double importeTotal;
    private PasarelaDePago pago;


    private Cliente clientePedido= new Cliente();
    private static int estado = 1;
    Validar validar =new Validar();

    // ESTADOS:
    public static final int PAGADO=0;
    public static final int PREPARADO=1;
    public static final int LISTO=2;
    public static final int SERVIDO=3;
	private Scanner sc;
	private Scanner sc2;
	private Scanner sc3;
	private Scanner sc4;

    /**
     * Constructores
     *
     * @param cliente de que cliente es el pedido
     * @param FechaHora fecha en la que se realiza el pedido
     * @param Estado estado del pedido
     */
    public Pedido(Cliente cliente, Date FechaHora, int Estado) {
        this.clientePedido =cliente;
        setFechaHora(FechaHora);
        setEstado(Estado);
        getImporteTotal();
    }

    Pedido() {
        pedidoCliente=new ArrayList<>();
    }


    /**
     *  Getter cliente que realiza el pedido
     * @return el cliente del cual es el pedido
     */
    public Cliente getClientePedido() {
        return this.clientePedido;
    }

    /**
     * Setter del cliente
     * @param clientePedido al que pertenece el pedido
     */
    public void setClientePedido(Cliente clientePedido) {
        this.clientePedido = clientePedido;
    }

    /**
     * Getter pedidoCliente que es el array del pedido
     * @return el arraylist que engloba los productos del pedido del cliente
     */
    public ArrayList<Producto> getPedidoCliente() {
        return pedidoCliente;
    }

    /**
     *  Setter del pedido cliente
     * @param pedidoCliente arraylist con los productos del pedido
     */
    public void setPedidoCliente(ArrayList<Producto> pedidoCliente) {

        Pedido.pedidoCliente = pedidoCliente;
    }

    /**
     * Getter fecha y hora de la creación del pedido
     * @return fecha y hora del pedido
     */
    public Date getFechaHora() {
        return FechaHora;
    }

    /**
     * Setter fecha y hora
     * @param fechaHora fecha y hora del pedido
     */
    public void setFechaHora(Date fechaHora) {
        FechaHora = fechaHora;
    }

    /**
     * Pago conecta con pasarela de pago para hacer el pago
     * @return pago
     */
    public PasarelaDePago getPago() {
        return pago;
    }

    /**
     * Setter del pago
     * @param pago forma de pago
     */
    public void setPago(PasarelaDePago pago) {
        this.pago = pago;
    }

    /**
     *  Getter importe total del producto
     * @return importe del producto con dos decimales
     */
    public double getImporteTotal() {
        return ((double)Math.round(this.importeTotal * 100d) / 100d);
    }

    /**
     * Setter importe total
     * @param importeTotal del pedido
     */
    public void setImporteTotal(double importeTotal) {
        this.importeTotal=importeTotal;
    }

    /**
     * Getter del estado del producto
     * @return estado del producto
     */
    public int getEstado() {
        return Pedido.estado;
    }

    /**
     * Setter del estado del producto
     * @param estado en el que se encuentra el producto
     */
    public void setEstado(int estado) {
            Pedido.estado = estado;
    }

    /**
     * Método que da nombre a los difrentes estados en los que se encuentra el producto
     * @return estado en el que se encuentra en tipo String
     */
    public static String estadoPedido() {
        if ( estado == PAGADO) return "PAGADO";
        if (estado == PREPARADO) return"PREPARANDO";
        if (estado == LISTO) return "LISTO";
        if (estado == SERVIDO) return "SERVIDO";
        return null;
    }


    /**
     * Método para gestionar la forma de pago, el cual se comunica con la clase PasarelaDePago
     *
     */
    public void pagar() {
        if(estado==PREPARADO) {
                System.out.println("*** FORMA DE PAGO ***");
                System.out.println("1. Efectivo");
                System.out.println("2. Tarjeta");
                System.out.println("3. Cuenta bancaria");
                System.out.println("0. Salir");
                sc4 = new Scanner(System.in);
                int TipoPago = sc4.nextInt();
                switch (TipoPago) {
                    case 0:
                        System.out.println("Operación cancelada");
                        break;
                    case 1:
                        System.out.println("Introduce cuando dinero entregas");
                        double cliente = sc4.nextDouble();
                        PasarelaDePago.efectivo(cliente);
                        break;
                    case 2:
                        System.out.println("Introduce el número de tarjeta");
                        String numeroTarjeta = sc4.nextLine();
                        sc4.nextLine();
                        if (PasarelaDePago.tarjeta(numeroTarjeta) == true) {
                            clientePedido.agregarPedidoHistorial(new Pedido());
                        }
                        break;
                    case 3:
                        System.out.println("Introduce cuenta bancaria");
                        String cuentaBancaria = sc4.nextLine();
                        sc4.nextLine();
                        if (PasarelaDePago.cuenta(cuentaBancaria) == true) {
                            estado = 0;
                            clientePedido.agregarPedidoHistorial(new Pedido());
                        }
                        break;
                    default:
                        System.out.println("Error de pago");
                }
        }else if(estado==PAGADO) System.out.println("Este pedido ya está pagado");
    }

    /**
     * Agregar producto a la colección de productos del pedido
     */
    public void agregarProducto(Producto p) {
        if(estado==PREPARADO) {
            pedidoCliente.add(p);
        } else if (estado==PAGADO)System.out.println("Este pedido ya está pagado");
    }

    /**
     * Eliminar un producto del pedido
     */
    public void eliminarProducto (){
        sc3 = new Scanner(System.in);
        if(estado==PREPARADO) {
            System.out.println("Introduce el número del producto que deseas eliminar");
            for (int i = 0; i < pedidoCliente.size(); i++) {
                System.out.println(i + ": " + pedidoCliente.get(i).getNombre());
            }
            int productoEliminado = sc3.nextInt();
            // Validar que el número introducido este dentro de los parámetros
            if (productoEliminado >= 0 && productoEliminado < pedidoCliente.size()) {
                pedidoCliente.get(productoEliminado).setCantidad(pedidoCliente.get(productoEliminado).getCantidad()-1);
                System.out.println("Producto eliminado");
            } else System.out.println("Error a la hora de eliminar el producto");
        } else if(estado==PAGADO) System.out.println("Este pedido ya está pagado");

    }

    /**
     * Se muestra el pedido del cliente
     */
    public void mostrarPedidoCliente() {
        System.out.println("Realizando pedido el " + Validar.fechaAlta() + " .... Su pedido:");
        System.out.println(" CANT.         PRODUCTOS         PRECIO UD.           TOTAL");
        System.out.println(" =====         =========         ==========           =====");
        for (int i = 0; i < pedidoCliente.size(); i++) {
            if (pedidoCliente.get(i).getCantidad() == 0) {
                pedidoCliente.get(i).incrementar();
            }
            for (int j = i + 1; j < pedidoCliente.size(); j++) {
                if (pedidoCliente.get(i).getNombre().contains(pedidoCliente.get(j).getNombre())) {
                    pedidoCliente.get(i).incrementar();
                    pedidoCliente.remove(pedidoCliente.get(j));
                }
            }
        }
        for (int j = 0; j < pedidoCliente.size(); j++) {
            System.out.println("   " + pedidoCliente.get(j).getCantidad() + "           "
                    + pedidoCliente.get(j).getNombre() + "             "
                    + pedidoCliente.get(j).getPrecio() + "              "
                    + pedidoCliente.get(j).getPrecioTotalProducto());
        }
        this.importeTotal = 0;
        for (int i = 0; i < pedidoCliente.size(); i++) {
            setImporteTotal(this.importeTotal += pedidoCliente.get(i).getPrecioTotalProducto());
        }
        System.out.println("TOTAL ------------------------------>" + getImporteTotal());
    }

    /**
     * Menu donde se indica las opciones de agregar o eliminar productos del pedido o pagar
     */
    public void menuRestaurante(){
        String seleccion;
        int seleccionMenu;
        do {
            sc2 = new Scanner(System.in);
            System.out.println("Que deseas hacer?" +
                    "\n 1. Mostrar pedido en curso"+
                    "\n 2. Agregar un producto a tu pedido" +
                    "\n 3. Eliminar un producto de tu pedido" +
                    "\n 4. Pagar"+
                    "\n 0. Salir" );
            seleccion=sc2.nextLine();
            seleccionMenu = Integer.parseInt(seleccion);
            sc2.nextLine();
            switch (seleccionMenu) {
                case 1:
                    mostrarPedidoCliente();
                    break;
                case 2:
                    agregarProductoPedido();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    pagar();
                    break;
                default:
                    System.out.println("Error");
            }
        }while (seleccionMenu!=0);
        System.out.println("Nos vemos pronto!");
    }

    /**
     * Muestra la carta de pedidos y gestiona la elección del cliente
     * @return la carta del producto
     */
    public Pedido mostrarCarta() {
        sc = new Scanner(System.in);
        System.out.println("Realizando pedido el " + Validar.fechaAlta()+" .... Su pedido:");
        System.out.println("******* CARTA DE PRODUCTOS ******** ");
        carta();
        System.out.println("Introduzca 7 para terminar el pedido");
        String seleccion;
        int seleccionMenu;

        do{
            seleccion=sc.nextLine();
            seleccionMenu = Integer.parseInt(seleccion);
            switch (seleccionMenu) {
                case 0 ->{
                    System.out.println("");
                }
                case 1 -> {
                    agregarProducto(cartaProducto.get(0));
                    mostrarPedidoCliente();
                }
                case 2 -> {
                    agregarProducto(cartaProducto.get(1));
                    mostrarPedidoCliente();
                }
                case 3 -> {
                    agregarProducto(cartaProducto.get(2));
                    mostrarPedidoCliente();
                }
                case 4 -> {
                    agregarProducto(cartaProducto.get(3));
                    mostrarPedidoCliente();
                }
                case 5 -> {
                    agregarProducto(cartaProducto.get(4));
                    mostrarPedidoCliente();
                }
                case 6 -> {
                    agregarProducto(cartaProducto.get(5));
                    mostrarPedidoCliente();
                }
                default ->{
                    System.out.println("Error");
                }
            }
        } while (seleccionMenu!=0);
        System.out.println("Pedido realizado");
        mostrarPedidoCliente();
        return null;
    }

    /**
     * Este método añade productos a pedidoCliente cuando este pedido ya está realizado
     */
    public void agregarProductoPedido() {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Realizando pedido el " + Validar.fechaAlta() +" .... Su pedido:");
			mostrarPedidoCliente();
			System.out.println("******* CARTA DE PRODUCTOS ******** ");
			carta();
			System.out.println("Introduzca 7 para terminar el pedido");
			String seleccion;
			int seleccionMenu;

			do{
			    seleccion=sc.nextLine();
			    seleccionMenu = Integer.parseInt(seleccion);
			    switch (seleccionMenu) {
			        case 0 ->{
			            System.out.println("");
			        }
			        case 1 -> {
			            agregarProducto(cartaProducto.get(0));
			            mostrarPedidoCliente();
			        }
			        case 2 -> {
			            agregarProducto(cartaProducto.get(1));
			            mostrarPedidoCliente();
			        }
			        case 3 -> {
			            agregarProducto(cartaProducto.get(2));
			            mostrarPedidoCliente();
			        }
			        case 4 -> {
			            agregarProducto(cartaProducto.get(3));
			            mostrarPedidoCliente();
			        }
			        case 5 -> {
			            agregarProducto(cartaProducto.get(4));
			            mostrarPedidoCliente();
			        }
			        case 6 -> {
			            agregarProducto(cartaProducto.get(5));
			            mostrarPedidoCliente();
			        }
			    }
			} while (seleccionMenu!=0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
        System.out.println("Productos añadidos");
        mostrarPedidoCliente();
    }

    /**
     * Se añade todos los productos a la carta y se recorre dicho array para mostrarla al llamar a este método
     */
     public void carta(){
        System.out.println("1. AGUA               0.35");
        Producto p1 = new Producto("AGUA", 0.35);
        cartaProducto.add(p1);
        System.out.println("2. BOCADILLO          3.35");
        Producto p2 = new Producto("BOCADILLO", 3.35);
        cartaProducto.add(p2);
        System.out.println("3. CERVEZA            0.75");
        Producto p3 = new Producto("CERVEZA", 0.75);
        cartaProducto.add(p3);
        System.out.println("4. COCACOLA           0.59");
        Producto p4 = new Producto("COCACOLA", 0.59);
        cartaProducto.add(p4);
        System.out.println("5. HAMBURGUESA        3.75");
        Producto p5 = new Producto("HAMBURGUESA", 3.75);
        cartaProducto.add(p5);
        System.out.println("6. PIZZA              7.75");
        Producto p6 = new Producto("PIZZA", 7.55);
        cartaProducto.add(p6);

        for (int i = 0; i < cartaProducto.size(); i++) {
            if (cartaProducto.get(i).getCantidad() > 0) {
                System.out.println(i+":  "+ cartaProducto.get(i).getNombre() + "   " + cartaProducto.get(i).getPrecio()+"€");
            }
        }
    }

}


