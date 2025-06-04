package portaldevagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import portaldevagas.model.vagasmodel;
import portaldevagas.service.vagasservice;
import java.util.List;

@RestController
@RequestMapping("/api/vagas")
@CrossOrigin(origins = "*") // Libera requisições de outros domínios (ex: frontend Angular)
public class vagascontroller {

    @Autowired
    private vagasservice Vagasservice;

    @GetMapping
    public List<vagasmodel> listarTodos() {
        return Vagasservice.listarTodos();
    }

    @PostMapping
    public vagasmodel salvar(@RequestBody vagasmodel vagas) {
        return Vagasservice.salvar(vagas);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        Vagasservice.deletar(id);
    }

    @PutMapping("/{id}")
    public vagasmodel editar(@PathVariable Long id, @RequestBody vagasmodel vagaAtualizada) {
        return Vagasservice.editar(id, vagaAtualizada);
    }
}
