package ReconocimientosExtra.Modelo;

import ReconocimientosExtra.Modelo.MedioDeContacto.MedioDeContacto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ColaboradorRecomendado {

    private String nombre;
    private String apellido;
    private double puntosAcumulados;
    private Direccion direccion;
    private List<MedioDeContacto> mediosDeContacto;

}
