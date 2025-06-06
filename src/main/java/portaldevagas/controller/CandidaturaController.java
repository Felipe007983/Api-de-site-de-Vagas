package portaldevagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portaldevagas.model.CandidaturaModel;
import portaldevagas.service.CandidaturaService;

import java.util.List;

@RestController
@RequestMapping("/api/candidaturas")
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    // Usuário se candidata a uma vaga
    @PostMapping
    public ResponseEntity<CandidaturaModel> candidatar(@RequestParam Long usuarioId, @RequestParam Long vagaId) {
        CandidaturaModel candidatura = candidaturaService.candidatar(usuarioId, vagaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatura);
    }

    // Listar candidaturas feitas por um usuário
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<CandidaturaModel>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<CandidaturaModel> candidaturas = candidaturaService.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(candidaturas);
    }

    // Listar candidaturas para uma vaga
    @GetMapping("/vaga/{vagaId}")
    public ResponseEntity<List<CandidaturaModel>> listarPorVaga(@PathVariable Long vagaId) {
        List<CandidaturaModel> candidaturas = candidaturaService.listarPorVaga(vagaId);
        return ResponseEntity.ok(candidaturas);
    }
}

