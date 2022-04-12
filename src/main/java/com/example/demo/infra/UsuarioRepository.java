package com.example.demo.infra;

import com.example.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //só sinaliza p/ springboot que é o repositório
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
