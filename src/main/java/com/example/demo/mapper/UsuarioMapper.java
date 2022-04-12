package com.example.demo.mapper;

import com.example.demo.domain.Usuario;
import com.example.demo.dto.request.UsuarioRequestBody;
import com.example.demo.dto.response.UsuarioResponseBody;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class UsuarioMapper {

    public static Usuario toUsuario(UsuarioRequestBody usuarioRequestBody) {
        return Usuario.builder()
                .nome(usuarioRequestBody.getNome())
                .email(usuarioRequestBody.getEmail())
                .build();
    }

    public static UsuarioResponseBody toUsuarioResponseBody(Usuario usuario) {
        return UsuarioResponseBody.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build();
    }
}