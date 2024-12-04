package ReconocimientosExtra;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ColaboradorRecomendadoDAO {

    private double puntosAcumulados; // Mapea la columna 'puntos_acumulados'
    private String nombre;           // Mapea la columna 'nombre'
    private String apellido;         // Mapea la columna 'apellido'
    private String direccion;        // Mapea la columna 'direccion'
    private String calle;            // Mapea la columna 'calle'
    private String altura;           // Mapea la columna 'altura'
    private String correo;           // Mapea la columna 'correo'
    private String nro_de_telefono;  // Mapea la columna 'nro_de_telefono'
}
