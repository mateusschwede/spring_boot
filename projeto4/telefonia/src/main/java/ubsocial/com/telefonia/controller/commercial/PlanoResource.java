package ubsocial.com.telefonia.controller.commercial;
import ubsocial.com.telefonia.model.entity.comercial.Plano;
import ubsocial.com.telefonia.model.repositories.commercial.PlanoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plano")
public class PlanoResource {
    private PlanoRepository planoRepository;

    public PlanoResource(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @GetMapping
    public List<Plano> get() {
        return planoRepository.findAll();
    }

    /* Método get sem tratamento de erros:
    @GetMapping("/{id}")
    public Plano get(@PathVariable Long id) {
        return planoRepository.getById(id);
    }*/

    // Método get específico com tratamento de erros:
    @GetMapping("/{id}")
    public ResponseEntity<Plano> get(@PathVariable Long id) {
        Optional<Plano> optional = planoRepository.findById(id);
        if(!optional.isPresent()) {
            return new ResponseEntity<Plano>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Plano>(optional.get(), HttpStatus.OK);
    }

    @PostMapping
    public Plano create(@RequestBody @Valid Plano plano) {
        return planoRepository.save(plano);
    }

    /* Método update sem tratamento de erros:
    @PutMapping("/{id}")
    public Plano update(@PathVariable Long id, @RequestBody Plano plano) {
        Plano planoAux = planoRepository.getById(id);
        planoAux.setNome(plano.getNome());
        planoAux.setValorPorMinuto(plano.getValorPorMinuto());
        return planoRepository.save(planoAux);
    }*/

    // Método update específico com tratamento de erros:
    @PutMapping("/{id}")
    public ResponseEntity<Plano> update(@PathVariable Long id, @RequestBody @Valid Plano plano) {
        Optional<Plano> optional = planoRepository.findById(id);
        if(!optional.isPresent()) {
            return new ResponseEntity<Plano>(HttpStatus.NOT_FOUND);
        }
        Plano planoAux = optional.get();
        planoAux.setNome(plano.getNome());
        planoAux.setValorPorMinuto(plano.getValorPorMinuto());
        return new ResponseEntity<Plano>(planoAux, HttpStatus.OK);
    }

    /* Método delete sem tratamento de erros:
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planoRepository.deleteById(id);
    }*/

    // Método delete específico com tratamento de erros:
    @DeleteMapping("/{id}")
    public ResponseEntity<Plano> delete(@PathVariable Long id) {
        if(!planoRepository.existsById(id)) {
            return new ResponseEntity<Plano>(HttpStatus.NOT_FOUND);
        }
        planoRepository.deleteById(id);
        return new ResponseEntity<Plano>(HttpStatus.NO_CONTENT);
    }
}