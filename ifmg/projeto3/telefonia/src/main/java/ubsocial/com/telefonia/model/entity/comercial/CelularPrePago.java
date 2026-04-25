package ubsocial.com.telefonia.model.entity.comercial;
import java.util.Date;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@DiscriminatorValue(value = "CelularPrePago")
public class CelularPrePago extends Celular {
    private double saldo;
    @Temporal(TemporalType.DATE)
    private Date dataDeValidade;
}