package ubsocial.com.telefonia.model.entity;

import ubsocial.com.telefonia.model.entity.comercial.Celular;
import ubsocial.com.telefonia.model.entity.comercial.Plano;
import ubsocial.com.telefonia.model.entity.pessoal.Cliente;
import java.util.Set;

public class Operadora {
    private String nome;
    private Set<Cliente> clientes;
    private Set<Celular> celulars;
    private Set<Plano> planos;
}