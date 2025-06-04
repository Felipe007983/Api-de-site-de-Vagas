package portaldevagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portaldevagas.model.usuariomodel;

public interface usuariorepository extends JpaRepository<usuariomodel, Long> {

    boolean existsByEmail(String email);

}
