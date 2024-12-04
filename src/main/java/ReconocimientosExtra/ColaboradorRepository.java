package ReconocimientosExtra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ColaboradorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ColaboradorRecomendadoDAO> obtenerColaboradorDAO(int minimoDePuntos, int minimoDeViandas) {
        String query = """
            SELECT colaborador.puntos_acumulados, persona_humana.nombre, persona_humana.apellido,
                   direccion.calle, direccion.altura, mail.correo, whats_app.nro_de_telefono
            FROM colaborador
            LEFT JOIN persona_humana ON persona_humana.id_persona = colaborador.persona
            LEFT JOIN direccion ON persona_humana.direccion = direccion.id_direccion
            LEFT JOIN mail ON mail.colaborador = colaborador.id_colaborador
            LEFT JOIN whats_app ON whats_app.colaborador = colaborador.id_colaborador
            WHERE puntos_acumulados >= :minimoDePuntos
            GROUP BY colaborador.puntos_acumulados, persona_humana.nombre, persona_humana.apellido,
                     direccion.calle, direccion.altura, mail.correo, whats_app.nro_de_telefono
        """;

        // Cambiar a javax.persistence.Query
        Query nativeQuery = entityManager.createNativeQuery(query);

        // Establecer el parámetro usando setParameter
        nativeQuery.setParameter("minimoDePuntos", minimoDePuntos);

        // Ejecutar la consulta
        List<Object[]> resultList = nativeQuery.getResultList();

        return getColaboradorRecomendadoDAOS(resultList);
    }

    private List<ColaboradorRecomendadoDAO> getColaboradorRecomendadoDAOS(List<Object[]> resultList) {
        List<ColaboradorRecomendadoDAO> colaboradores = new ArrayList<>();
        for (Object[] result : resultList) {
            ColaboradorRecomendadoDAO dao = new ColaboradorRecomendadoDAO();
            dao.setPuntosAcumulados((Double) result[0]);   // Asignar el primer valor (puntos_acumulados)
            dao.setNombre((String) result[1]);             // Asignar el segundo valor (nombre)
            dao.setApellido((String) result[2]);           // Asignar el tercer valor (apellido)
            dao.setCalle((String) result[3]);              // Asignar el cuarto valor (calle)
            dao.setAltura((String) result[4]);             // Asignar el quinto valor (altura)
            dao.setCorreo((String) result[5]);             // Asignar el sexto valor (correo)
            dao.setNro_de_telefono((String) result[6]);    // Asignar el sexto valor (nro_de_telefono)

            colaboradores.add(dao);
        }
        return colaboradores;
    }
}