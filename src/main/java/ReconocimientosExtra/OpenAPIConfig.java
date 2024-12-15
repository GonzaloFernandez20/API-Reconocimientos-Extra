package ReconocimientosExtra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("grupo8dds@gmail.com");
        contact.setName("GRUPO_8_DDS");

        Info info = new Info()
                .title("Servicio 2: Reconocimientos Extra")
                .version("1.0")
                .contact(contact)
                .description("Ésta API en base a una cantidad mínima de puntos requeridos, una cantidad mínima de donación de\n" +
                        "viandas realizada en el último mes y una cantidad máxima de colaboradores devolverá una lista de colaboradores recomendados. " +
                        "En caso de que no se llegue a la cantidad de colaboradores solicitados, se deberán\n" +
                        "devolver únicamente los que cumplan las condiciones.");

        return new OpenAPI().info(info);
    }
}
