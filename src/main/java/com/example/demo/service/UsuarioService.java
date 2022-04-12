package com.example.demo.service;

import com.example.demo.domain.Usuario;
import com.example.demo.exception.ApiException;
import com.example.demo.infra.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor //gera um construtor com todos os argumentos dentro
public class UsuarioService {

    //injeção de dependência, sendo feita pelo allargs
    private final UsuarioRepository repositorio; //dizendo que o UsuarioService precisa do repositório obrigatoriamente

    //@Transactional //caso der erro no método, ele dá um rollback, cancelando qualquer coisa que tenha sido alterada;
    public Usuario salva(Usuario usuario) {
        return repositorio.save(usuario);
    }

    // TODO: 4/11/2022  essa forma é mais simples, ver exemplo do kurama depois

    public Usuario atualiza(Usuario novoUsuario, Long id) { //pegando o id do usuário que tu quer atualizar e salvando o novo no mesmo id
        novoUsuario.setId(buscaPorId(id).getId());
        return repositorio.save(novoUsuario);
    }

    public List<Usuario> buscaTodos() {
        return repositorio.findAll();
    }

    public Usuario buscaPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ApiException("Usuário não encontrado.", HttpStatus.NOT_FOUND)); //criando uma exceção pq pode retornar nulo
    }

    public void deletar(Long id) {
        repositorio.deleteById(buscaPorId(id).getId());
    }
}
