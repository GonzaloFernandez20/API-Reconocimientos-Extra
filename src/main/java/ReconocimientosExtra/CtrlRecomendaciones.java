package ReconocimientosExtra;

import ReconocimientosExtra.Modelo.ColaboradorRecomendado;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ConsultarRecomendaciones")
@Tag(name = "API_DDS", description = "Servicio 2: Reconocimientos Extra")
public class CtrlRecomendaciones {

    private final RecomendadorDeColaboraciones recomendadorDeColaboraciones;

    @Autowired
    public CtrlRecomendaciones(RecomendadorDeColaboraciones recomendadorDeColaboraciones) {
        this.recomendadorDeColaboraciones = recomendadorDeColaboraciones;
    }

    @Operation(summary = "Devolver lista de colaboradores a ser reconocidos por otras empresas, junto con el puntaje que obtuvo cada uno hasta el momento",
            description = "Devuelve una lista de ColaboradorRecomendado, que tiene nombre, apellido, direccion, puntos y medios de contacto")
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
