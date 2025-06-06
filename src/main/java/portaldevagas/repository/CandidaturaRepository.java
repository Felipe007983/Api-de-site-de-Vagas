package portaldevagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portaldevagas.model.CandidaturaModel;


import java.util.List;

public interface CandidaturaRepository extends JpaRepository<CandidaturaModel, Long> {

    List<CandidaturaModel> findByUsuarioId(Long usuarioId);

    List<CandidaturaModel> findByVagaId(Long vagaId);

}
