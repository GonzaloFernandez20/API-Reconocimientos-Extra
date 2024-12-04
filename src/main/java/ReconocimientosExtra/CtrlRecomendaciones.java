package ReconocimientosExtra;

import ReconocimientosExtra.Modelo.ColaboradorRecomendado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ConsultarRecomendaciones")
public class CtrlRecomendaciones {

    private final RecomendadorDeColaboraciones recomendadorDeColaboraciones;

    @Autowired
    public CtrlRecomendaciones(RecomendadorDeColaboraciones recomendadorDeColaboraciones) {
        this.recomendadorDeColaboraciones = recomendadorDeColaboraciones;
    }


    @GetMapping
    public ResponseEntity<List<ColaboradorRecomendado>> consultarRecomendaciones(
            @RequestParam int minimoDePuntos,
            @RequestParam int minimoDeViandas,
            @RequestParam int maximoDeColaboradores
    ){
        List<ColaboradorRecomendado> recomendaciones = recomendadorDeColaboraciones.obtenerRecomendaciones(minimoDePuntos, minimoDeViandas, maximoDeColaboradores);

        if (recomendaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(recomendaciones);
        }
    }
}
