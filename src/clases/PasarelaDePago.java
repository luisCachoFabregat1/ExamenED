package clases;

import java.sql.Date;

public class PasarelaDePago {
    private Date codigoPago;
    private Pedido pedido;
    private double importe;

    public PasarelaDePago(Pedido pedido) {
        this.setPedido(pedido);
        this.setImporte(pedido.getImporteTotal());
        this.setCodigoPago(new Date(0)); // Establecer la fecha adecuadamente
    }

    // Getters y setters...

    public static void efectivo(double cliente, Pedido pedido) {
        // Implementación simplificada del método efectivo
    }

    public static boolean tarjeta(String numeroTarjeta) {
		return false;
        // Implementación simplificada de validación de tarjeta
    }

    public static boolean cuenta(String cuentaBancaria) {
		return false;
        // Implementación simplificada de validación de cuenta bancaria
    }

	public Date getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(Date codigoPago) {
		this.codigoPago = codigoPago;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
}
