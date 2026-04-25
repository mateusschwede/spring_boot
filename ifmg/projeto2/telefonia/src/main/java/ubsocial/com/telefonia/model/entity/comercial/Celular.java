package ubsocial.com.telefonia.model.entity.comercial;

import ubsocial.com.telefonia.model.entity.pessoal.Cliente;
import java.util.Set;

public class Celular {
    private long numero;
    private Cliente cliente;
    private Set<Ligacao> ligacoes;
    private Plano plano;
}