package sistemavehiculos2;

/**
 * Esta clase hereda y sobreescribe los metodos de la clase {@link Vehiculo}
 * de modo a adaptar a las características de un camion autonomo.
 * 
 * * @author Karina Bogarin
 * @version 2.0
 * @since 05/2026
 */
public class CamionAutonomo extends Vehiculo {
    private double combustible; 
    
    /**
     * Constructor de la clase.
     * @param id : Identificador del camion (Vehiculo).
     * @param combustible : Litros de combustible que posee el camión.
     * @param modelo : Modelo del camión
     */
    public CamionAutonomo(String id, String modelo, double combustible){
        super(id, modelo);
        this.combustible = combustible;
    }
    
    // Sobreescritura de los metodos de la clase Vehículo.
    @Override
    public void patronMovimiento(){
        System.out.println("Camion " + getId() + " saliendo del deposito...");
    }
    @Override
    public void ubicarVehiculo(){
        System.out.println("Camion " + getId() + " circulando a 80Km/h sobre RN1(Km 12)");
    }
    
    // Accesor del combustible.
    public double getCombustible(){
        return combustible;
    }
}
