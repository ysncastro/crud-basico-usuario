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

@RequestMapping("/usuario")
@RestController
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioFacade usuarioFacade;

    @Operation(summary = "Insere o usuario")
    @PostMapping
    public ResponseEntity<UsuarioResponseBody> salvar(@Valid @RequestBody UsuarioRequestBody usuarioRequestBody) {
        return new ResponseEntity<>(usuarioFacade.salvar(usuarioRequestBody), HttpStatus.CREATED);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponseBody> getPorId(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioFacade.buscaPorId(id), HttpStatus.OK);
    }

    // colocar get aqui

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponseBody> atualizar(@Valid @RequestBody UsuarioRequestBody usuarioRequestBody,
                                                         @PathVariable Long id) {
        return new ResponseEntity<>(usuarioFacade.atualizar(usuarioRequestBody, id), HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioFacade.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
