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
<<<<<<< HEAD
    public static void main(String[] args) {   
        
        //Creando artículos para comprar
        Articulo art1 = new Articulo("manzana", "fruta", 7, 100);
        Articulo art2 = new Articulo("naranja", "fruta", 12, 70);
        Articulo art3 = new Articulo("uvas", "fruta", 20, 200);
        Articulo art4 = new Articulo("ciruelas", "fruta", 20, 150);
        Articulo art5 = new Articulo("frambuesas", "fruta", 20, 200);
        art1.ToString();
        art2.ToString();
        art3.ToString();
        art4.ToString();
        art5.ToString();
        
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
        //Se imprimen como "Articulos en la orden"
        orden1.addArt(art1, 10); 
        orden1.addArt(art2, 2);
        orden2.addArt(art1, 9);
        orden2.addArt(art3, 6);
        orden3.addArt(art2, 10);
        orden5.addArt(art4, 6);
        orden4.addArt(art3, 10);
        orden5.addArt(art2, 2);
        orden5.addArt(art5, 3);

        //Direcciones de clientes
        Direccion dir1 = new Direccion("AQUI #123");
        Direccion dir2 = new Direccion("ALLA #321");
        
        //Clientes
        Cliente cliente1 = new Cliente("hola", "123-k", dir1);
        Cliente cliente2 = new Cliente("chao", "531-k", dir1);
        Cliente cliente3 = new Cliente("pc", "999-k", dir2);
                
        //Acciones con clientes
        //ToString y addOrden
        cliente1.ToString();
        cliente1.addOrden(orden1);
        cliente1.addOrden(orden2);
        cliente1.addOrden(orden3);
        
        cliente2.ToString();
        cliente2.addOrden(orden4);
        
        cliente3.ToString();
        cliente3.addOrden(orden5);
        
        //Imprime OrdenCompra de cada cliente y su respectivo Documento Tributario
        if(cliente1.getOrden(0) != null && cliente1.getOrden(1) != null && 
                cliente1.getOrden(2) != null){
            cliente1.getOrden(0).ToString();
            cliente1.getOrden(1).ToString();
            cliente1.getOrden(2).ToString();
        }
        if(cliente2.getOrden(0) != null){
            cliente2.getOrden(0).ToString();
        }
        if(cliente3.getOrden(0) != null){
            cliente3.getOrden(0).ToString();
        }
        
        //Pagos para orden 1 (con 2 pagos y efectivo)
        System.out.println("Pago de orden 1");
        Efectivo efe1 = new Efectivo(orden1, 1000);
        efe1.ToString();

        System.out.println(orden1.getTotal());
        Efectivo efe2 = new Efectivo(orden1, 500);
        efe2.ToString();
        
        System.out.println(efe2.calcDevolucion());
        System.out.println();
        
        //Pagos para orden 2 (3 pagos por transferencia en diferentes fechas)
        System.out.println("Pago de orden 2");
        Transferencia tran1 = new Transferencia(orden2, "Banco1", "02191203", 1000);
        tran1.ToString();

        System.out.println(orden2.getTotal());
        Transferencia tran2 = new Transferencia(orden2, "Banco1", "02191203", 500);
        tran2.ToString();

        System.out.println(orden2.getTotal());
        Transferencia tran3 = new Transferencia(orden2, "Banco1", "02191203", 1000);
        tran3.ToString();
        System.out.println(orden2.getTotal());
        
        System.out.println("\n");
        
        //Pagos para orden 3 (1 pago con débito)
        System.out.println("Pago de orden 3");
        Tarjeta tar1 = new Tarjeta(orden3, "Debito", "123948921", 1000);
        tar1.ToString();

        System.out.println(orden3.getTotal());        
        System.out.println("\n");
=======
    public static void main(String[] args) {
        OrdenCompra orden = new OrdenCompra();
        orden.ToString();
        Cliente cliente = new Cliente();
        cliente.ToString();
        
        // TODO code application logic here
>>>>>>> a558291 (ToString agregado en clase Cliente)
    }
    
}
class OrdenCompra{
    private float pagar = 0; //El dinero que queda por pagar (se usa para los plazos)
    private Date fecha;
    private String estado;
    private DocTributario doc; //documento asociado a la orden
    private ArrayList<DetalleOrden> detalles;
    
    public OrdenCompra(DocTributario doct){ // Para iniciar el array, el estado, la fecha y asignar el documento tributario
        detalles = new ArrayList<>();
        estado = "Pendiente";
        fecha = new Date();
        doc = doct;
        doc.setFecha(fecha);
    }
    public Class getType(){ // Para saber si se tiene boleto o factura
        return doc.getClass();
    }
    public void addArt(Articulo arti, int cant){ //agrega DetalleOrden con un tipo de articulo y su cantidad
        DetalleOrden ordet = new DetalleOrden(arti);
        detalles.add(ordet);
        detalles.get(detalles.size()-1).setCant(cant);
        detalles.get(detalles.size()-1).ToString();
        sumarTotal(detalles.get(detalles.size()-1).calcPrecio());
    }
    public void setDir(Direccion dir){ //direccion para el docTributario desde Cliente
        doc.setDir(dir);
    }
    public void setRut(String rut){ //rut para el docTributario desde Cliente
        doc.setRut(rut);
    }
    public float getTotal(){ //Getter para el dinero que queda por pagar

        return pagar;
    }
    public void sumarTotal(float monto){// Sumar/restar al monto que queda por pagar
        pagar += monto;
    }
    public void setTotal(float monto){//Setter del monto que queda por pagar
        pagar = monto;
    }
    public void ToString(){
<<<<<<< HEAD
        System.out.println("Info de la orden");
        System.out.println("Fecha de compra: " + fecha);
        System.out.println("Estado: " + estado);
        System.out.println("Precio sin IVA: " + calcPrecioSinIVA());
        System.out.println("IVA: " + calcIVA());
        System.out.println("Precio: " + calcPrecio());
        System.out.println("Peso: " + calcPeso() + "\n");
        doc.ToString();
=======
        fecha = new Date();
        System.out.println("Info de la orden");
        System.out.println("Fecha de compra: " + fecha);
        System.out.println("Estado: " + estado);
>>>>>>> a558291 (ToString agregado en clase Cliente)
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
<<<<<<< HEAD
    private Direccion direccion; //La dirección del cliente
    ArrayList<OrdenCompra> ordenes; //Almacena las ordenes de cada cliente
    
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
=======
>>>>>>> a558291 (ToString agregado en clase Cliente)
    
    public void ToString(){
        System.out.println("Info del cliente");
        System.out.println("Nombre: " + nombre);
        System.out.println("Rut: " + rut);
<<<<<<< HEAD
        System.out.println("Dirección: " + direccion.getDir() + "\n");
        
=======
>>>>>>> a558291 (ToString agregado en clase Cliente)
    }
}
class Direccion{
    private String direccion;
    
<<<<<<< HEAD
    public Direccion(String dir){ 
        direccion = dir;
    }
    public String getDir(){ //Getter de dirección
        return direccion;
    }
    public void ToString(){
        System.out.println("Dirección: " + direccion + "\n");
=======
    public void ToString(){
        System.out.println("Dirección: " + direccion);
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    }
}
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
<<<<<<< HEAD
    private Direccion direccion; //Para relacionar el documento con una dirección
    
    public DocTributario(){ //Para asignar un número random
        numero = "" + (int)(Math.random()*(1000000-0+1)+0);
    }
    
    public void setDir(Direccion dir){ //Para asignar la direccion de boleta/factura
        direccion = dir;
    }
    public void setRut(String ru){ //Para asignar el rut de boleta/factura
        rut = ru;
    }
    public void setFecha(Date fec){ //Para asignar la fecha de boleta/factura
        fecha = fec;
    }
    public Direccion getDir(){ //Getter de la dirección 
        return direccion;
    }
=======
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    
    public void ToString(){
        System.out.println("Info DocTributario");
        System.out.println("Número: " + numero);
        System.out.println("Rut: " + rut);
        System.out.println("Fecha de compra: " + fecha);
<<<<<<< HEAD
        System.out.println("Direccion: " + direccion.getDir() + "\n");
=======
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    }
}
class Boleta extends DocTributario{
    
}
class Factura extends DocTributario{
    
}
class DetalleOrden{
    private int cantidad;
<<<<<<< HEAD
    private Articulo art; //Artículo para saber el cálculo a realizar
    
    public DetalleOrden(Articulo art1){ //Determina el tipo de articulo
        art = art1;
    }
    public void setCant(int can){ //Setter de la cantidad del artículo definido
        cantidad = can;
    }
    public void ToString(){
        System.out.println("Articulos en la orden");
        System.out.println("Articulo: " + art.getNombre());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio sin IVA: " + calcPrecioSinIVA());
        System.out.println("IVA: " + calcIVA());
        System.out.println("Precio: " + calcPrecio());
        System.out.println("Peso: " + calcPeso() + "\n");
=======
    public void ToString(){
        System.out.println("Cantidad: " + cantidad);
>>>>>>> a6ad338 (ToString agregado a todas las clases)
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
    
<<<<<<< HEAD
    public Articulo(String Nomb, String Desc, float pes, float prec){ //Asigna valores a Artículo
        peso = pes;
        precio = prec;
        nombre = Nomb;
        descripcion = Desc;
    }
    public String getNombre(){ //Getter de nombre
        return nombre;
    }
    public float getPeso(){ //Getter de peso
        return peso;
    }
    public float getPrecio(){ //Getter de precio
        return precio;
    }
=======
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    public void ToString(){
        System.out.println("Info Artículo");
        System.out.println("Peso: " + peso);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
<<<<<<< HEAD
        System.out.println("Precio: " + precio + "\n");
=======
        System.out.println("Precio: " + precio);
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    }
}
class Pago{
    private float monto;
    private Date fecha;
<<<<<<< HEAD
    private OrdenCompra orden; //La orden a pagar
    
    public void setFecha(Date date){ //Setter de fecha
        fecha = date;
    }
    public void setMonto(int plata){ //Setter del monto a pagar
        monto = plata;
    }
    public void setOrden(OrdenCompra ordem){ //Setter de la orden a pagar
        orden = ordem;
    }
    public Date getFecha(){ //Getter de la fecha
        return fecha;
    }
    public float getMonto(){ //Getter del monto a pagar
        return monto;
    }
    public OrdenCompra getCompra(){ //Getter de la OrdenCompra
        return orden;
    }
    public void ToString(){
        System.out.println("Info pago");
        System.out.println("Monto: " + monto);
        System.out.println("Fecha de pago: " + fecha);
=======
    
    public void ToString(){
        System.out.println("Info pago");
        System.out.println("Monto: " + monto);
        System.out.println("Fecha de compra: " + fecha);
    }
}
class Efectivo{
    public calcDevolucion(){
        
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    }
}
class Efectivo extends Pago{
    
    public Efectivo(OrdenCompra ordem, int plata){ //Settea monto, orden, fecha y luego paga
        super.setMonto(plata);
        super.setOrden(ordem);
        super.setFecha(new Date());
        ordem.sumarTotal(-super.getMonto());
    }    
    public float calcDevolucion(){ //Calcula la devolución
        if(super.getCompra().getTotal() < 0){
            float a = super.getCompra().getTotal()*-1;
            super.getCompra().setTotal(0);
            return a;
        }
        return 0;
    }
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
<<<<<<< HEAD
    
    public Transferencia(OrdenCompra ordem, String bank, String num, int plata){ //Settea info y paga
        banco = bank;
        numCuenta = num;
        super.setMonto(plata);
        super.setOrden(ordem);
        super.setFecha(new Date());
        ordem.sumarTotal(-super.getMonto());
        if(ordem.getTotal()<0){
            ordem.setTotal(0);
        }
    }    
    
=======
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    public void ToString(){
        System.out.println("Info transferencia");
        System.out.println("Banco: " + banco);
        System.out.println("numCuenta: " + numCuenta);
<<<<<<< HEAD
        System.out.println("Monto: " + super.getMonto());
        System.out.println("Fecha de pago: " + super.getFecha());
=======
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    }
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
<<<<<<< HEAD
    public Tarjeta(OrdenCompra ordem, String tipe, String numtran, int plata){ //Settea info y paga
        tipo = tipe;
        numTransaccion = numtran;
        super.setMonto(plata);
        super.setOrden(ordem);
        super.setFecha(new Date());
        ordem.sumarTotal(-super.getMonto());
        if(ordem.getTotal()<0){
            ordem.setTotal(0);
        }
    }    
    
=======
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    public void ToString(){
        System.out.println("Info tarjeta");
        System.out.println("Tipo: " + tipo);
        System.out.println("numTransacción: " + numTransaccion);
<<<<<<< HEAD
        System.out.println("Monto: " + super.getMonto());
        System.out.println("Fecha de pago: " + super.getFecha());
=======
>>>>>>> a6ad338 (ToString agregado a todas las clases)
    }
}