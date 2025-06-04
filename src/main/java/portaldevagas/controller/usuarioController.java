package portaldevagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import portaldevagas.model.usuariomodel;
import portaldevagas.service.usuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Libera requisições de outros domínios (ex: frontend Angular)
public class usuarioController {

    @Autowired
    private usuarioService usuarioService;

    @GetMapping
    public List<usuariomodel> listarTodos() {
        return usuarioService.listarTodos();
    }

    @PostMapping
    public usuariomodel salvar(@RequestBody usuariomodel usuario) {
        return usuarioService.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    @PutMapping("/{id}")
    public usuariomodel editar(@PathVariable Long id, @RequestBody usuariomodel usuarioAtualizado) {
        return usuarioService.editar(id, usuarioAtualizado);
    }
}
