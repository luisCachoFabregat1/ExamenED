/**
 * 
 */
package clases;

import java.sql.Date;
/**
*@author luiscachofabregat
*
*
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validar {


    private String movil;
	private String fijo;

	Validar() {
    }

    /**
     * Validar cadena
     *
     * @param cadena cadena introducida para validar
     * @return si es verdadero o falso
     */
    public boolean validarCadena(String cadena) {
        if (cadena != null) {
            /*Verificar que no sea null*/
            Pattern pat = Pattern.compile("^([a-z|A-ZñÑáéíóúÁÉÍÓÚ]+[ ]?){3}$");
        /* Representa la expresión regular la cual incluye e alfabeto más los acentos y los espacios
        método compile() que recibe como parámetro la expresión regular y
         devuelve un objeto de la clase Pattern. */
            Matcher mat = pat.matcher(cadena);
        /* compara el String y la expresión regular.
        método matches() que recibe como parámetro el String a validar
        y devuelve true si coincide con el patrón
        */
            if (mat.find()) {
                /* indica si el String contienen el patrón. */
                return true;
            } else System.out.println("Cadena de texto válida");
            return false;
        } else System.out.println("Cadena de texto válida");
        return false;
    }

    /**
     * Validar teléfonos
     *
     * @param telefono número de teléfono para validar
     * @return si es falso o verdadero
     */
    public boolean validarTelefono(String telefono) {
        // Eliminar espacios en blanco
        String NewTelefono = telefono.replace(" ", "");

        // Validar que sean todos dígitos  y longitud de 9
        Pattern pat = Pattern.compile("[6789]\\d{8}$");
        Matcher mat = pat.matcher(NewTelefono);
        int primerNumero;
        if (mat.find()) {
            primerNumero = NewTelefono.charAt(0);
            if (primerNumero == 6 || primerNumero == 7) {
                setMovil(NewTelefono);
            } else if (primerNumero == 8 || primerNumero == 9) {
                setFijo(NewTelefono);
            }
            return true;
        } else {
            System.out.println("Telefono no válido");
            return false;
        }
    }

    /**
     * Cambia formato de la fecha a dd/mm/yyyy hh_mm
     *
     * @return fecha en formato dd/mm/yyyy hh_mm
     */
    public static String fechaAlta() {
        Calendar calendar = Calendar.getInstance();
        Date dates = (Date) calendar.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaActual = formato.format(dates);
        System.out.println(fechaActual);
        return fechaActual;
    }

    /**
     * Cambia el formato del código de pago a números
     * @return codigo de pago cambiado
     */
    public static String codigoDePago(){
        Calendar calendar = Calendar.getInstance();
        Date dates = (Date) calendar.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
        String codigoActual = formato.format(dates);
        System.out.println(codigoActual);
        return codigoActual;
    }

    /**
     * Validar precio producto
     *
     * @param precio parámetro dado para validar
     * @return si es falso o verdadero
     */
    public boolean validarPrecio(double precio) {
        return precio >= 0 && precio <= 9;
    }

    /**
     * Busca si existe algún cliente con ese número de teléfono para que así no se dupliquen
     * @param telefonoCliente telefono que se introduce
     * @return si existe algún cliente con ese número de teléfono
     */
    public Cliente buscarTelfCliente(String telefonoCliente) {
        Cliente existe=null;
        boolean buscar=false;
        for(int i=0; i<Cliente.clientes.size() && !buscar; i++){
            buscar=(Cliente.clientes.get(i).getTelefono()==telefonoCliente);
            if (buscar){
            }
        }
        return existe;

    }

	/**
	 * @param telefono1
	 * @return
	 */
	public boolean validarTelefono1(String telefono1) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getFijo() {
		return fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}
}



