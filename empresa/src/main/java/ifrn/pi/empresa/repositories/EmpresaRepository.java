package ifrn.pi.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.empresa.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
