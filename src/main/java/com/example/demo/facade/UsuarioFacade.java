package com.example.demo.facade;

import com.example.demo.domain.Usuario;
import com.example.demo.dto.request.UsuarioRequestBody;
import com.example.demo.dto.response.UsuarioResponseBody;
import com.example.demo.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.mapper.UsuarioMapper.toUsuario;
import static com.example.demo.mapper.UsuarioMapper.toUsuarioResponseBody;

@Component
public class UsuarioFacade {

    private UsuarioService usuarioService;

    @Autowired
    public void UsuarioFacade(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public UsuarioResponseBody salvar(UsuarioRequestBody usuarioRequestBody) {
        return toUsuarioResponseBody(usuarioService.salva(toUsuario(usuarioRequestBody)));
    }

    public List<UsuarioResponseBody> buscaTodos() {
        List<UsuarioResponseBody> listaResposta = new ArrayList<>();
        usuarioService.buscaTodos().forEach(cadaUsuario -> {
            listaResposta.add(toUsuarioResponseBody(cadaUsuario));
        });
        return listaResposta;
    }

    public UsuarioResponseBody buscaPorId(Long id) {
        return toUsuarioResponseBody(usuarioService.buscaPorId(id));
    }

//    public List<CategoriaResponseBody> buscarTodos() {
//        return categoriaRepositorio.findAll().stream().map(CategoriaMapper::toCategoriaResponseBody).toList();
//    }

    public UsuarioResponseBody atualizar(UsuarioRequestBody usuarioRequestBody, Long id) {
        return toUsuarioResponseBody(usuarioService.atualiza(toUsuario(usuarioRequestBody), id));
    }

    public void deletar(Long id) {
        usuarioService.deletar(id);
    }

}
