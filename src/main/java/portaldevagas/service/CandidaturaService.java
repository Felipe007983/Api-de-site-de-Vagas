package portaldevagas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaldevagas.model.CandidaturaModel;
import portaldevagas.model.usuariomodel;
import portaldevagas.model.vagasmodel;
import portaldevagas.repository.CandidaturaRepository;
import portaldevagas.repository.usuariorepository;
import portaldevagas.repository.vagasrepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Autowired
    private usuariorepository UsuarioRepository;

    @Autowired
    private vagasrepository VagasRepository;

    public CandidaturaModel candidatar(Long usuarioId, Long vagaId) {
        usuariomodel usuario = UsuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        vagasmodel vaga = VagasRepository.findById(vagaId)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        // Verifica se já existe candidatura para evitar duplicidade
        boolean jaCandidatado = candidaturaRepository
                .findByUsuarioId(usuarioId)
                .stream()
                .anyMatch(c -> c.getVaga().getId().equals(vagaId));

        if (jaCandidatado) {
            throw new RuntimeException("Usuário já se candidatou a essa vaga");
        }

        CandidaturaModel candidatura = new CandidaturaModel();
        candidatura.setUsuario(usuario);
        candidatura.setVaga(vaga);
        candidatura.setDataCandidatura(LocalDateTime.now());
        candidatura.setStatus("ENVIADA");

        return candidaturaRepository.save(candidatura);
    }

    public List<CandidaturaModel> listarPorUsuario(Long usuarioId) {
        return candidaturaRepository.findByUsuarioId(usuarioId);
    }

    public List<CandidaturaModel> listarPorVaga(Long vagaId) {
        return candidaturaRepository.findByVagaId(vagaId);
    }
}

