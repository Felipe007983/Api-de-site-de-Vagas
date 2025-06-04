package portaldevagas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portaldevagas.model.vagasmodel;
import portaldevagas.repository.vagasrepository;

import java.util.List;

@Service
public class vagasservice {

    @Autowired
    private vagasrepository Vagasrepository;

    public List<vagasmodel> listarTodos(){
        return Vagasrepository.findAll();
    }

    public vagasmodel salvar(vagasmodel vagas) {
        if (Vagasrepository.existsById(vagas.getId())) {
            throw new RuntimeException("Vaga já cadastrado");
        }
        return Vagasrepository.save(vagas);
    }

        public void deletar (Long id){
            if (!Vagasrepository.existsById(id)) {
                throw new RuntimeException("Vaga do id " + id + " não encontrado");
            }
            Vagasrepository.deleteById(id);
        }

        public vagasmodel editar (Long id, vagasmodel vagaAtualizada){
            vagasmodel vagaExistente = Vagasrepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado com o id" + id));

            vagaExistente.setNomeVaga(vagaAtualizada.getNomeVaga());
            vagaExistente.setDescricao(vagaAtualizada.getDescricao());

            return Vagasrepository.save(vagaExistente);
        }
    }