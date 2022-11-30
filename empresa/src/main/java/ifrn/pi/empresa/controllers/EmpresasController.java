package ifrn.pi.empresa.controllers;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.empresa.models.Empresa;
import ifrn.pi.empresa.repositories.EmpresaRepository;

	@Controller
	public class EmpresasController {
		
		@Autowired
		private EmpresaRepository em;

		@RequestMapping("/empresa/form")
		public String form() {
		return "formEmpresa";

		}
		
		@PostMapping("/empresas")
		public String adicionar(Empresa empresa) {
			System.out.println(empresa);
			em.save(empresa);
			return "empresa-adicionada";
		}
		
		
	}
