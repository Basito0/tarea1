/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compra;

import java.util.Date;
import java.util.ArrayList;
import java.lang.Math;


/**
 *
 * @author bas_b
 */
public class Compra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        
        //Creando artículos para comprar
        Articulo art1 = new Articulo("manzana", "fruta", 7, 100);
        Articulo art2 = new Articulo("naranja", "fruta", 12, 70);
        Articulo art3 = new Articulo("uvas", "fruta", 20, 200);
        art1.ToString();
        art2.ToString();
        art3.ToString();
        
        //Decidiendo boleta o factura
        Factura doc1 = new Factura();
        Boleta doc2 = new Boleta();
        Boleta doc3 = new Boleta();
        Factura doc4 = new Factura();
        Boleta doc5 = new Boleta();
        
        //Creando ordenes de compra
        OrdenCompra orden1 = new OrdenCompra(doc1);
        OrdenCompra orden2 = new OrdenCompra(doc2);
        OrdenCompra orden3 = new OrdenCompra(doc3);
        OrdenCompra orden4 = new OrdenCompra(doc4);
        OrdenCompra orden5 = new OrdenCompra(doc5);
        
        //Añadiendo artículos a las ordenes
        orden1.addArt(art1, 10); 
        orden1.addArt(art2, 2);
        orden2.addArt(art1, 9);
        orden2.addArt(art3, 6);
        orden3.addArt(art2, 10);
        orden4.addArt(art3, 10);
        orden5.addArt(art2, 2);

        //Direcciones de clientes
        Direccion dir1 = new Direccion("AQUI #123");
        Direccion dir2 = new Direccion("ALLA #321");
        
        //Clientes
        Cliente cliente1 = new Cliente("hola", "123-k", dir1);
        Cliente cliente2 = new Cliente("chao", "531-k", dir1);
        Cliente cliente3 = new Cliente("pc", "999-k", dir2);
                
        //Acciones con clientes
        cliente1.ToString();
        cliente1.addOrden(orden1);
        cliente1.addOrden(orden2);
        cliente1.addOrden(orden3);
        
        cliente2.ToString();
        cliente2.addOrden(orden4);
        
        cliente3.ToString();
        cliente3.addOrden(orden5);
        
        if(cliente1.getOrden(0) != null && cliente1.getOrden(1) != null && 
                cliente1.getOrden(2) != null){
            cliente1.getOrden(0).ToString();
            cliente1.getOrden(0).ToString();
            cliente1.getOrden(0).ToString();
        }
        if(cliente2.getOrden(0) != null){
            cliente2.getOrden(0).ToString();
        }
        if(cliente3.getOrden(0) != null){
            cliente3.getOrden(0).ToString();
        }
        System.out.println("Tipo: " + orden1.getType());
        System.out.println("Tipo: " + orden2.getType());
        System.out.println("Tipo: " + orden3.getType());
        System.out.println("Tipo: " + orden4.getType());
        System.out.println("Tipo: " + orden5.getType());
        
    }
    
}
class OrdenCompra{
    private Date fecha;
    private String estado;
    private DocTributario doc; //documento asociado a la orden
    private ArrayList<DetalleOrden> detalles;
    
    public OrdenCompra(DocTributario doct){ // Para iniciar el estado, fecha y tipo
        detalles = new ArrayList<>();
        estado = "Pendiente";
        fecha = new Date();
        doc = doct;
        doc.setFecha(fecha);
    }
    public Class getType(){ // Para saber si se tiene boleto o factura
        return doc.getClass();
    }
    public void addArt(Articulo arti, int cant){ //agrega detalles de compra
        DetalleOrden ordet = new DetalleOrden(arti);
        detalles.add(ordet);
        detalles.get(detalles.size()-1).setCant(cant);
        detalles.get(detalles.size()-1).ToString();
    }
    public void setDir(Direccion dir){ //direccion para el docTributario
        doc.setDir(dir);
    }
    public void setRut(String rut){ //rut para el docTributario
        doc.setRut(rut);
    }
    public void ToString(){
        System.out.println("Info de la orden");
        System.out.println("Fecha de compra: " + fecha);
        System.out.println("Estado: " + estado);
        System.out.println("Precio sin IVA: " + calcPrecioSinIVA());
        System.out.println("IVA: " + calcIVA());
        System.out.println("Precio: " + calcPrecio());
        System.out.println("Peso: " + calcPeso() + "\n");
        doc.ToString();
    }
    public float calcPrecioSinIVA(){
        float total = 0;
        for(int u=0; u<(detalles.size()); u++){
            total += detalles.get(u).calcPrecioSinIVA();
        }
        return total;
    }
    public float calcIVA(){
        float total = 0;
            for(int u=0; u<(detalles.size()); u++){
                total += detalles.get(u).calcPrecioSinIVA();
            }
        total = total * 0.19f;
        return total;
    }
    public float calcPrecio(){
        float total = 0;
        for(int u=0; u<(detalles.size()); u++){
            total += detalles.get(u).calcPrecioSinIVA();
        }
        return total + calcIVA();
    }
    public float calcPeso(){
        float total = 0;
        for(int u=0; u<(detalles.size()); u++){
            total += detalles.get(u).calcPeso();
        }
        return total;
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
        orden.setDir(direccion);
        orden.setRut(rut);
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
        System.out.println("Dirección: " + direccion.getDir() + "\n");
        
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
        System.out.println("Dirección: " + direccion + "\n");
    }
}
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    private Direccion direccion; //Para relacionar el documento con una dirección
    
    public DocTributario(){
        numero = "" + (int)(Math.random()*(1000000-0+1)+0);
    }
    
    public void setDir(Direccion dir){ //Para asignar la direccion de boleta/factura
        direccion = dir;
    }
    public void setRut(String ru){ //Para asignar la direccion de boleta/factura
        rut = ru;
    }
    public void setFecha(Date fec){ //Para asignar la direccion de boleta/factura
        fecha = fec;
    }
    public Direccion getDir(){
        return direccion;
    }
    
    public void ToString(){
        System.out.println("Info DocTributario");
        System.out.println("Número: " + numero);
        System.out.println("Rut: " + rut);
        System.out.println("Fecha de compra: " + fecha);
        System.out.println("Direccion: " + direccion.getDir() + "\n");
    }
}
class Boleta extends DocTributario{
    
}
class Factura extends DocTributario{
    
}
class DetalleOrden{
    private int cantidad;
    private Articulo art; //Para saber el cálculo a realizar
    
    public DetalleOrden(Articulo art1){ //Determina el tipo de articulo
        art = art1;
    }
    public void setCant(int can){ //Set a cantidad
        cantidad = can;
    }
    public void ToString(){
        System.out.println("Detalle de los articulos en la orden");
        System.out.println("Articulo: " + art.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio sin IVA: " + calcPrecioSinIVA());
        System.out.println("IVA: " + calcIVA());
        System.out.println("Precio: " + calcPrecio());
        System.out.println("Peso: " + calcPeso() + "\n");
    }
    public float calcPrecioSinIVA(){
        float total = 0;
        for(int i=0; i<cantidad; i++){
            total += art.getPrecio();
        }
        return total;
    }
    public float calcIVA(){
        float total = 0;
        for(int i=0; i<cantidad; i++){
            total += art.getPrecio();
        }
        total = total * 0.19f;
        return total;
    }
    public float calcPrecio(){
        float total = 0;
        for(int i=0; i<cantidad; i++){
            total += art.getPrecio();
        }
        return total + calcIVA();
    }
    public float calcPeso(){
        float total = 0;
        for(int i=0; i<cantidad; i++){
            total += art.getPeso();
        }
        return total;
    }
}
class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    
    public Articulo(String Nomb, String Desc, float pes, float prec){
        peso = pes;
        precio = prec;
        nombre = Nomb;
        descripcion = Desc;
    }
    public String getNombre(){
        return nombre;
    }
    public float getPeso(){
        return peso;
    }
    public float getPrecio(){
        return precio;
    }
    public void ToString(){
        System.out.println("Info Artículo");
        System.out.println("Peso: " + peso);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio: " + precio + "\n");
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
class Efectivo extends Pago{
    public calcDevolucion(){
        
    }
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    public void ToString(){
        System.out.println("Info transferencia");
        System.out.println("Banco: " + banco);
        System.out.println("numCuenta: " + numCuenta);
    }
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
    public void ToString(){
        System.out.println("Info tarjeta");
        System.out.println("Tipo: " + tipo);
        System.out.println("numTransacción: " + numTransaccion);
    }
}