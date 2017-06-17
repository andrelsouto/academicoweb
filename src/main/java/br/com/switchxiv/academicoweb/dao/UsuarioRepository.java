package br.com.switchxiv.academicoweb.dao;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.switchxiv.academicoweb.model.Usuario;

public interface UsuarioRepository extends UserDetailsService, GenericRepository<Usuario>{

}
