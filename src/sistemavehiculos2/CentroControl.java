package sistemavehiculos2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta clase es el centro de control y gestión de todos los vehículos.
 * Administra el ciclo de vida (CRUD) y el monitoreo operativo de la flota.
 * 
 * * @author Karina Bogarin
 * @version 2.0
 * @since 05/2026
 */
public class CentroControl {

    private final List<Vehiculo> listaVehiculos;

    public CentroControl() {
        this.listaVehiculos = new ArrayList<>();
    }
    
    // METODOS DE LA VERSION 1.0
    
    /**
     * Monitorea el movimiento de todos los vehículos que se encuentran 
     * en la flota.
     */
    public void monitorearFlota() {
        System.out.println("\n\tMONITOREO DE FLOTA EN TIEMPO REAL");
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay unidades activas para monitorear.");
            return;
        }
        listaVehiculos.forEach(v -> v.patronMovimiento());
    }

    /**
     * Imprime la ubicación actual de todos los vehículos del sistema.
     */
    public void ubicarVehiculos() {
        System.out.println("\n\tUBICACION GEOGRAFICA DE UNIDADES");
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay unidades registradas para ubicar.");
            return;
        }
        listaVehiculos.forEach(v -> v.ubicarVehiculo());
    }

    // METODOS CRUD - VERSION 2.0
    
     /**
     * Crea un nuevo vehículo en el sistema
     * @param v : nombre del vehiculo
     */
    public void crearVehiculo(Vehiculo v) {
        if(v!=null) listaVehiculos.add(v);
    }
    
    /**
     * Busca un vehiculo especifico por su identificador
     * @param id : El identificador del vehiculo a buscar.
     * @return El objeto Vehiculo encontrado, o null si no existe.
     */
    public Vehiculo buscarVehiculo(String id) {
        return listaVehiculos.stream()
                .filter(v -> v.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
    
     /**
     * Lista los vehiculos existentes en el sistema
     */
    public void listarVehiculos() {
        System.out.println("\n\tLISTA DE VEHICULOS");
        if(listaVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados en el sistema.");
            return;
        }
        listaVehiculos.forEach(v -> System.out.println(v.toString()));
    }
    
    /**
     * Modifica el modelo de un vehiculo existente en el sistema
     * @param id : identificador del vehiculo
     * @param nuevoModelo : el nuevo modelo del vehiculo
     * @return true si el vehiculo fue modificado con exito, false si no.
     */
    public boolean modificarVehiculo(String id, String nuevoModelo) {
        Vehiculo v = buscarVehiculo(id);
        if(v != null) {
            v.setModelo(nuevoModelo);
            return true;
        }
        return false; 
    }
    
    /**
     * Elimina un vehiculo de sistema basado en su id 
     * @param id : identificador del vehiculo
     * @return true si se elimino con exito
     */
    public boolean eliminarVehiculo(String id) {
        return listaVehiculos.removeIf(v -> v.getId().equalsIgnoreCase(id));
    }
    
    /**
     * Obtiene una lista con todos los identificadores id de los vehiculos
     * registrados en el sistema.
     * @return lista de id's
     */
    public List<String> obtenerListaIds() {
        return listaVehiculos.stream()
                .map(Vehiculo::getId)
                .collect(Collectors.toList());
    }
    
    /**
     * Busca un vehiculo a partir de su modelo
     * @param modelo : modelo del vehiculo
     * @return vehiculo
     */
    public List<Vehiculo> buscarPorModelo(String modelo){
        return listaVehiculos.stream()
                .filter(v -> v.getModelo().toLowerCase().contains(modelo.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Cuenta la cantidad total de vehiculos registrados en el ecosistema.
     * @return cantidad total de vehiculos
     */
    public long contarVehiculos(){
        return listaVehiculos.stream().count();
    }
    
    /**
     * Filtra y devuelve una lista de los vehiculos que tienen un contrato con 
     * (IConectable).
     * @return lista de vehiculos que implementan IConectable
     */
    public List<Vehiculo> filtrarConectables(){
        return listaVehiculos.stream()
                .filter(v -> v instanceof IConectable)
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra los vehiculos segun su tipo de clase heredada
     * @param tipo el nombre de la clase a buscar
     * @return lista de vehiculos filtrados
     */
    public List<Vehiculo> buscarPorTipo(String tipo){
        return listaVehiculos.stream()
                .filter(v -> v.getClass().getSimpleName().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }
    
    /**
     * Ordena la lista interna de vehiculos alfabeticamente por su id
     */
    public void ordenarPorId(){
        listaVehiculos.sort((v1,v2) -> v1.getId().compareTo(v2.getId()));
    }
    
    /**
     * Ordena la listainterna alfabeticamente por el tipo de vehiculo (nombre de su clase)
     */
    public void ordenarPorTipo(){
        listaVehiculos.sort((v1,v2) -> v1.getClass().getSimpleName().compareTo(v2.getClass().getSimpleName()));
    }
    
}
