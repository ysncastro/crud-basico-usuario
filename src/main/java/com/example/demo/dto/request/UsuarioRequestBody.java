package com.example.demo.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

public class UsuarioRequestBody {

    @NotEmpty(message = "Campo email inválido!")
    private String nome;

    @NotEmpty(message = "Campo email inválido!")
    private String email;

}
