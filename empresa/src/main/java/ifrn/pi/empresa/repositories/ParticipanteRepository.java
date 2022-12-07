package ifrn.pi.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.empresa.models.Empresa;
import ifrn.pi.empresa.models.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>{
	
	List<Participante> findByEmpresa(Empresa empresa);
	
}
