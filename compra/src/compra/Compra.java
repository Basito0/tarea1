/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compra;

import java.util.Date;

/**
 *
 * @author bas_b
 */
public class Compra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrdenCompra orden = new OrdenCompra();
        orden.ToString();
        Cliente cliente = new Cliente();
        cliente.ToString();
        
        // TODO code application logic here
    }
    
}
class OrdenCompra{
    private Date fecha;
    private String estado;
    public void ToString(){
        fecha = new Date();
        System.out.println("Info de la orden");
        System.out.println("Fecha de compra: " + fecha);
        System.out.println("Estado: " + estado);
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
    
    public void ToString(){
        System.out.println("Info del cliente");
        System.out.println("Nombre: " + nombre);
        System.out.println("Rut: " + rut);
    }
}
class Direccion{
    private String direccion;
}
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
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
class Transferencia{
    private String banco;
    private String numCuenta;
}
class Tarjeta{
    private String tipo;
    private String numTransaccion;
}