package ifrn.pi.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.empresa.models.Servico;
import ifrn.pi.empresa.repositories.ServicoRepository;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

	@Autowired
	private ServicoRepository sv;

	@PostMapping
	public String salvarSV(Servico servico) {
		System.out.println("Fez o que eu queria!");
		System.out.println(servico);
		sv.save(servico);
		return "servicos/servico-cadastrado";
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		List<Servico> servicos = sv.findAll();
		ModelAndView mv = new ModelAndView("servicos/listadeservicos");
		mv.addObject("servicos", servicos);
		return mv;
	}
}
