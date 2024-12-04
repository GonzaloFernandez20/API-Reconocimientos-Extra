package ReconocimientosExtra.Modelo.MedioDeContacto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Mail implements MedioDeContacto{
    private String email;
}
