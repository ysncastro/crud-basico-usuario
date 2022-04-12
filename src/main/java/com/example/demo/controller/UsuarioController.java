package com.example.demo.controller;

import com.example.demo.dto.request.UsuarioRequestBody;
import com.example.demo.dto.response.UsuarioResponseBody;
import com.example.demo.facade.UsuarioFacade;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/usuario")
@RestController
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioFacade usuarioFacade;

    @Operation(summary = "Insere o usuario")
    @PostMapping
    public ResponseEntity<UsuarioResponseBody> salva(@Valid @RequestBody UsuarioRequestBody usuarioRequestBody) {
        return new ResponseEntity<>(usuarioFacade.salvar(usuarioRequestBody), HttpStatus.CREATED);
    }

    @Operation(summary = "Busca por id")
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponseBody> buscaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioFacade.buscaPorId(id), HttpStatus.OK);
    }

    @Operation(summary = "Busca todos")
    @GetMapping("/usuarios/")
    public ResponseEntity<List<UsuarioResponseBody>> buscaTodos() {
        return new ResponseEntity<>(usuarioFacade.buscaTodos(), HttpStatus.OK);
    }

    @Operation(summary = "Atualiza usuário")
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponseBody> atualiza(@Valid @RequestBody UsuarioRequestBody usuarioRequestBody,
                                                         @PathVariable Long id) {
        return new ResponseEntity<>(usuarioFacade.atualizar(usuarioRequestBody, id), HttpStatus.OK);
    }

    @Operation(summary = "Deleta usuário")
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> deleta(@PathVariable Long id) {
        usuarioFacade.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
