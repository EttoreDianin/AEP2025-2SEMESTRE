package com.aep.nexo.repository;

import com.aep.nexo.model.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosModel, Long> {
    Optional<UsuariosModel> findByEmailAndSenha(String email, String senha);
    void deleteByEmailAndSenha(String email, String senha);
}
