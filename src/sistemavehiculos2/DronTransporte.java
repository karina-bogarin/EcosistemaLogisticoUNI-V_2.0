package sistemavehiculos2;

/**
 * Esta clase hereda de {@link Vehiculo} e implementa {@link IConectable}.
 * Se trata de un dron transportador que trabaja con GPS.
 * 
 * * @author Karina Bogarin
 * @version 2.0
 * @since 05/2026
 */
public class DronTransporte extends Vehiculo implements IConectable {
    private int battery; 
    
    /**
     * Constructor de la clase.
     * @param id : identificador del dron (Vehiculo)
     * @param modelo : modelo del dron
     * @param battery : Nivel de batería del dron.
     */
    public DronTransporte(String id, String modelo, int battery){
        super(id, modelo);
        this.battery = battery;
    }
    
    //Sobreescritura de los metodos de la clase Vehiculo y IConectable.
    @Override
    public void patronMovimiento(){
        System.out.println("Dron " + getId() + " despegando...");
    }
    
    @Override
    public void sincronizarGPS(){
        System.out.println("Sincronizando satelites para ubicar al dron...");
    }
    
    @Override
    public void ubicarVehiculo(){
        System.out.println("Dron " + getId() + " se dirige hacia el Norte a 25Km/h.");
    }
    
    //Accesor de la bateria
    public int getBattery(){
        return battery;
    }
}
