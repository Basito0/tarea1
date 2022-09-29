/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compra;

import java.util.Date;
import java.util.ArrayList;

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
        Direccion dir = new Direccion("AQUI #123");
        Cliente cliente = new Cliente("hola", "123-k", dir);
        cliente.ToString();
        cliente.addOrden(orden);
        if(cliente.getOrden(0) != null){
            cliente.getOrden(0).ToString();
        }        
        // TODO code application logic here
    }
    
}
class OrdenCompra{
    private Date fecha;
    private String estado;
    public OrdenCompra(){ // Para iniciar el estado y la fecha
        estado = "Pendiente";
        fecha = new Date();
    }
    public void ToString(){
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
    private Direccion direccion;
    ArrayList<OrdenCompra> ordenes;
    
    public Cliente(String n, String r, Direccion dir){ // valores iniciales para cliente
        ordenes = new ArrayList<>();
        nombre = n;
        rut = r;
        direccion = dir;
    }
    
    public void addOrden(OrdenCompra orden){ // Añade ordenes al cliente
        ordenes.add(orden);
    }
    
    public OrdenCompra getOrden(int n){ // Devuelve una orden del cliente
       if(ordenes == null){
           return null;
       }
       return ordenes.get(n);
    }
    
    public void ToString(){
        System.out.println("Info del cliente");
        System.out.println("Nombre: " + nombre);
        System.out.println("Rut: " + rut);
        System.out.println("Dirección: " + direccion.getDir());
        
    }
}
class Direccion{
    private String direccion;
    
    public Direccion(String dir){
        direccion = dir;
    }
    public String getDir(){
        return direccion;
    }
    public void ToString(){
        System.out.println("Dirección: " + direccion);
    }
}
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    
    public void ToString(){
        System.out.println("Info DocTributario");
        System.out.println("Número: " + numero);
        System.out.println("Rut: " + rut);
        System.out.println("Fecha de compra: " + fecha);
    }
}
class Boleto extends DocTributario{
    
}
class Factura extends DocTributario{
    
}
class DetalleOrden{
    private int cantidad;
    public void ToString(){
        System.out.println("Cantidad: " + cantidad);
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
class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    
    public void ToString(){
        System.out.println("Info Artículo");
        System.out.println("Peso: " + peso);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: " + precio);
    }
}
class Pago{
    private float monto;
    private Date fecha;
    
    public void ToString(){
        System.out.println("Info pago");
        System.out.println("Monto: " + monto);
        System.out.println("Fecha de compra: " + fecha);
    }
}
class Efectivo{
    public calcDevolucion(){
        
    }
}
class Transferencia{
    private String banco;
    private String numCuenta;
    public void ToString(){
        System.out.println("Info transferencia");
        System.out.println("Banco: " + banco);
        System.out.println("numCuenta: " + numCuenta);
    }
}
class Tarjeta{
    private String tipo;
    private String numTransaccion;
    
    public void ToString(){
        System.out.println("Info tarjeta");
        System.out.println("Tipo: " + tipo);
        System.out.println("numTransacción: " + numTransaccion);
    }
}