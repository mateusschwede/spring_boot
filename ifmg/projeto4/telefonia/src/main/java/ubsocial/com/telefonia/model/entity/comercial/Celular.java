package ubsocial.com.telefonia.model.entity.comercial;
import ubsocial.com.telefonia.model.entity.pessoal.Cliente;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "class")
@Entity
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long numero;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    @JoinColumn(name = "celular_id")
    private Set<Ligacao> ligacoes;
    @ManyToOne
    private Plano plano;
}