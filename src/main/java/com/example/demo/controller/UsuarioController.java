package com.example.demo.controller;

import com.example.demo.dto.request.UsuarioRequestBody;
import com.example.demo.dto.response.UsuarioResponseBody;
import com.example.demo.facade.UsuarioFacade;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
