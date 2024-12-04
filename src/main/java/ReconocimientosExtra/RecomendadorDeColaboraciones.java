package ReconocimientosExtra;

import ReconocimientosExtra.Modelo.ColaboradorRecomendado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecomendadorDeColaboraciones {

    private final ColaboradorRepository colaboradorRepository;

    @Autowired
    public RecomendadorDeColaboraciones(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public List <ColaboradorRecomendado> obtenerRecomendaciones(int minimoDePuntos, int minimoDeViandas, int maximoDeColaboradores){

        List <ColaboradorRecomendadoDAO> recomendadosDAO = colaboradorRepository.obtenerColaboradorDAO(minimoDePuntos, minimoDeViandas);
        recomendadosDAO.subList(0, Math.min(maximoDeColaboradores, recomendadosDAO.size())); // Consideramos recortarla si se pasa del maximo pedido

        return ColaboradorRecomendadoMapper.construirColaboradorRecomendadoAPartirDe(recomendadosDAO);
    }

}