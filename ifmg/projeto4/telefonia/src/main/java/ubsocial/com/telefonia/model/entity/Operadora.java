package ubsocial.com.telefonia.model.entity;
import ubsocial.com.telefonia.model.entity.comercial.Celular;
import ubsocial.com.telefonia.model.entity.comercial.Plano;
import ubsocial.com.telefonia.model.entity.pessoal.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class Operadora {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private Set<Cliente> clientes;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private Set<Celular> celulares;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private Set<Plano> planos;
}