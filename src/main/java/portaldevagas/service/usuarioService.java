package portaldevagas.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import portaldevagas.model.usuariomodel;
import portaldevagas.repository.usuariorepository;

import java.util.List;

@Service
public class usuarioService {

    @Autowired
    private usuariorepository Usuariorepository;


    public List<usuariomodel> listarTodos(){
    return Usuariorepository.findAll();
}

public usuariomodel salvar(usuariomodel usuario){
        if (Usuariorepository.existsByEmail(usuario.getEmail())){
            throw new RuntimeException("Email já cadastrado");
        }
        return Usuariorepository.save(usuario);
}

public void deletar(Long id){
        if(!Usuariorepository.existsById(id)){
            throw new RuntimeException("Usuario do id " + id +" não encontrado");
        }
        Usuariorepository.deleteById(id);
}

public usuariomodel editar(Long id, usuariomodel usuarioAtualizado){
        usuariomodel usuarioExistente = Usuariorepository.findById(id).orElseThrow( () -> new RuntimeException("Usuario não encontrado com o id" + id));

        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setDataNascimento(usuarioAtualizado.getDataNascimento());
        usuarioExistente.setSexo(usuarioAtualizado.getSexo());
        usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());

        return Usuariorepository.save(usuarioExistente);
}

}
