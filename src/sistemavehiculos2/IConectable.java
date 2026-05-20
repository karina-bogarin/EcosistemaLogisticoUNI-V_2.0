package sistemavehiculos2;

/**
 * Interfaz de Definicion de Contratos "IConectable".
 * Contiene un metodo que permite sicronizarGPS con los vehiculos que lo requieran.
 * 
 * * @author Karina Bogarin
 * @version 2.0
 * @since 05/2026
 */
public interface IConectable {
    
    /* Metodo abstracto que sera sobreescrito en todas las clases que implementen
     * IConectable. 
     */
    void sincronizarGPS();
}
