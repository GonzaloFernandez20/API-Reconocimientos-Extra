package ReconocimientosExtra;

import ReconocimientosExtra.Modelo.ColaboradorRecomendado;
import ReconocimientosExtra.Modelo.Direccion;
import ReconocimientosExtra.Modelo.MedioDeContacto.Mail;
import ReconocimientosExtra.Modelo.MedioDeContacto.MedioDeContacto;
import ReconocimientosExtra.Modelo.MedioDeContacto.WhatsApp;

import java.util.ArrayList;
import java.util.List;

public class ColaboradorRecomendadoMapper {

    public static List<ColaboradorRecomendado> construirColaboradorRecomendadoAPartirDe(List <ColaboradorRecomendadoDAO> colaboradores){

        List<ColaboradorRecomendado> colaboradoresRecomendados = new ArrayList<>();


        for (ColaboradorRecomendadoDAO colaborador : colaboradores){

            List<MedioDeContacto> mediosDeContacto = new ArrayList<>();

            if (colaborador.getNro_de_telefono() != null) { mediosDeContacto.add(new WhatsApp(colaborador.getNro_de_telefono())); }
            if (colaborador.getCorreo() != null) { mediosDeContacto.add(new Mail(colaborador.getCorreo())); }

            colaboradoresRecomendados.add(
                    new ColaboradorRecomendado(
                            colaborador.getNombre(),
                            colaborador.getApellido(),
                            colaborador.getPuntosAcumulados(),
                            new Direccion(
                                    colaborador.getCalle(),
                                    colaborador.getAltura()),
                            mediosDeContacto
                    )
            );
        }
        return colaboradoresRecomendados;
    }
}
