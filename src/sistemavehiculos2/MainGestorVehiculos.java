package sistemavehiculos2;

import java.util.List;
/**
 * Gestiona las clases del sistema de Vehiculos. 
 * Nos ayuda a verificar el funcionamiento de nuestras clases y metodos.
 * 
 * * @author Karina Bogarin
 * @version 2.0
 * @since 05/2026
 */
public class MainGestorVehiculos {
    public static void main(String[] args){
        CentroControl control = new CentroControl();
        
        System.out.println("BIENVENIDO AL SISTEMA DE GESTION DE VEHICULOS.\n");
        
        // Creamos una unidad de cada tipo de vehiculo.
        DronTransporte dron = new DronTransporte("D-01","DJI Lito 1", 57);
        CamionAutonomo camion = new CamionAutonomo("AAXD-383", "Scania", 100);
        MotoDelivery moto = new MotoDelivery("AABX-838","Star XTZ 110", 89);
        
        // Registramos las tres unidades creadas.
        control.crearVehiculo(dron);
        control.crearVehiculo(camion);
        control.crearVehiculo(moto);
        
        // Monitoreamos la flota de vehiculos que tenemos.
        control.monitorearFlota();
        
        System.out.println();
        
        // Sincronizamos el GPS del dron y la moto.
        dron.sincronizarGPS();
        moto.sincronizarGPS();
        
        System.out.println();
        
        // Pedimos la ubicacion de los vehiculos.
        control.ubicarVehiculos();
        
        System.out.println();
        
        // Buscamos los vehiculos segun su modelo
        String modeloABuscar = "Scania";
        
        System.out.println("\n\tRESULTADOS DE BUSQUEDA PARA: " + modeloABuscar);

        List<Vehiculo> resultados = control.buscarPorModelo(modeloABuscar);

        // Verificamos si encontro algo para imprimirlo
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron vehículos de ese modelo.");
        } 
        else {
            resultados.forEach(v -> System.out.println("ID: " + v.getId() + " | Modelo: " + v.getModelo()));
        }
        
        System.out.println(control.filtrarConectables());
        
        System.out.println(control.obtenerListaIds());
        System.out.println("");
        control.ordenarPorTipo();
        control.listarVehiculos();
    }
}
