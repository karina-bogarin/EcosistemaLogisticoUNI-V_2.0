package sistemavehiculos2;

/**
 * Esta clase hereda de {@link Vehiculo} e implementa {@link IConectable}.
 * Se trata de una moto utilizada para realizar servicios de delivery.
 * 
 * * @author Karina Bogarin
 * @version 2.0
 * @since 05/2026
 */
public class MotoDelivery extends Vehiculo implements IConectable{
    private double combustible;
    
    /**
     * Constructor de la clase.
     * @param id : Identificador de la moto (vehiculo)
     * @param modelo : Modelo de la moto
     * @param combustible : Litros de combustible que posee la moto.
     */
    public MotoDelivery(String id,String modelo, double combustible){
        super(id, modelo);
        this.combustible = combustible;
    }
    
    // Sobreescritura de los metodos de Vehiculo y IConectable.
    @Override
    public void patronMovimiento(){
        System.out.println("Moto " + getId() + " saliendo del garage...");
    }
    
    @Override
    public void sincronizarGPS(){
        System.out.println("Sincronizando satelites para ubicar a la moto " + getId() + "...");
    }
    
    @Override
    public void ubicarVehiculo(){
        System.out.println("Moto " + getId() + " se dirige hacia Ruta 1 a 85Km/h.");
    }
    
    // Accesor del combustible de la moto.
    public double getCombustible(){
        return combustible;
    }
}
