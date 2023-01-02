package ifrn.pi.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "servicos/orcamento-verificado";
	}
	
	@GetMapping("/form")
	public String formSV(Servico servico) {
		return "servicos/formServico";
	}
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		List<Servico> servicos = sv.findAll();
		ModelAndView mv = new ModelAndView("servicos/listadeservicos");
		mv.addObject("servicos", servicos);
		return mv;
	}
	
	@GetMapping("/{id}/remover")
	public String apagarSV(@PathVariable Long id ) {
		
		Optional<Servico> opt = sv.findById(id);
		
		if(!opt.isEmpty()) {
			Servico servico = opt.get();
			sv.delete(servico);
			
		}
		return "redirect:/servicos/listar";
	}
	@GetMapping("/{id}/selecionar")
	public ModelAndView selecionarOrcamento(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();

		Optional<Servico> opt = sv.findById(id);
		if (opt.isEmpty()) {
			md.setViewName("redirect:/servicos/listar");
			return md;
		}

		Servico servico = opt.get();
		md.setViewName("servicos/formServico");//aqui deve ir a URL do Cadastro
		md.addObject("servico", servico);
		return md;
	}
}
