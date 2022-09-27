/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1;
import java.util.Date;

/**
 *
 * @author babecerra2021
 */
public class Tarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrdenCompra orden = new OrdenCompra();
        orden.ToString();
    }
    
}

class OrdenCompra{
    private Date fecha;
    private String estado;
    public void ToString(){
        System.out.println("Fecha de compra: " + fecha);
    }
    public float calcPrecioSinIVA(){
        
    }
    public float calcIVA(){
        
    }
    public float calcPrecio(){
        
    }
    public float calcPeso(){
        
    }
}
class Cliente{
    private String nombre;
    private String rut;
}
class Direccion{
    private String direccion;
}
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha
}
class Boleto{
    
}
class Factura{
    
}
class DetalleOrden{
    private int cantidad;
    public float calcPrecioSinIVA(){
        
    }
    public float calcIVA(){
        
    }
    public float calcPrecio(){
        
    }
    public float calcPeso(){
        
    }
}
class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
}
class Pago{
    private float monto;
    private Date fecha;
}
class Efectivo{
    public calcDevolucion(){
        
    }
}
class Transferencia(){
    private String banco;
    private String numCuenta;
}
class Tarjeta{
    private String tipo;
    private String numTransaccion;
}