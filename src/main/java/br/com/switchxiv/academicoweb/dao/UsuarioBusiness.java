package br.com.switchxiv.academicoweb.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.switchxiv.academicoweb.model.Usuario;

@Repository
@Transactional
public class UsuarioBusiness extends GenericBusiness<Usuario> implements UsuarioRepository {
	
	@Override
	public Usuario save(Usuario entity) {
		manager.persist(entity);
		return entity;
	}
	
	@Override
	public UserDetails loadUserByUsername(String matricula){
		List<Usuario> usuarios = manager.createQuery("from Usuario where matricula = :matricula", Usuario.class)
				.setParameter("matricula", matricula)
				.getResultList();
		
		if (usuarios.isEmpty()){
			 throw new UsernameNotFoundException ("O usuário " + matricula + " não foi encontrado");
		}
		
		return usuarios.get(0);
	}

}
