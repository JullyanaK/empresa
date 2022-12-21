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

import ifrn.pi.empresa.models.Orcamento;
import ifrn.pi.empresa.models.Participante;
import ifrn.pi.empresa.repositories.OrcamentoRepository;
import ifrn.pi.empresa.repositories.ParticipanteRepository;

@Controller
@RequestMapping("/orcamentos")
public class EmpresasController {

	@Autowired
	private OrcamentoRepository em;
	@Autowired
	private ParticipanteRepository pa;
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "orcamentos/formServico";
	}

	@GetMapping("/form")
	public String form(Orcamento orcamento) {
		return "orcamentos/formOrcamento";
	}

	@PostMapping
	public String adicionar(Orcamento orcamento) {
		System.out.println(orcamento);
		em.save(orcamento);
		return "orcamentos/orcamento-verificado";
	}

	@GetMapping
	public ModelAndView listar() {
		List<Orcamento> orcamentos = em.findAll();
		ModelAndView mv = new ModelAndView("orcamentos/lista");
		mv.addObject("orcamentos", orcamentos);
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		java.util.Optional<Orcamento> opt = em.findById(id);

		if (opt.isEmpty()) {
			md.setViewName("redirect:/orcamentos");
			return md;
		}

		md.setViewName("orcamentos/detalhes");
		Orcamento orcamento = opt.get();
		md.addObject("orcamento", orcamento);
		List<Participante> participantes = pa.findByOrcamento(orcamento);
		md.addObject("participantes", participantes);
		return md;
	}

	@PostMapping("/{idOrcamento}")
	public String salvarParticipante(@PathVariable Long idOrcamento, Participante participante) {
		System.out.println("ID do orçamento: " + idOrcamento);
		System.out.println(participante);

		java.util.Optional<Orcamento> opt = em.findById(idOrcamento);
		if (opt.isEmpty()) {
			return "redirect:/orcamentos";
		}

		Orcamento orcamento = opt.get();
		participante.setOrcamento(orcamento);

		pa.save(participante);

		return "redirect:/orcamentos/{idOrcamento}";
	}
	
	@GetMapping("/{id}/selecionar")
	public ModelAndView selecionarOrcamento(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();

		java.util.Optional<Orcamento> opt = em.findById(id);
		if (opt.isEmpty()) {
			md.setViewName("redirect:/orcamentos");
			return md;
		}

		Orcamento orcamento = opt.get();
		md.setViewName("orcamentos/formOrcamento");
		md.addObject("orcamento", orcamento);
		return md;
	}
	
	@GetMapping("/{idOrcamento}/participantes/{idParticipante}/retirar")
	public String retirarParticipante(@PathVariable Long idOrcamento, @PathVariable Long idParticipante) {

		Optional<Participante> opt = pa.findById( idParticipante);

		if(!opt.isEmpty()) {
			Participante participante = opt.get();
			pa.delete(participante);
		}

		return "redirect:/orcamentos/{idOrcamento}";
	}

	@GetMapping("/{id}/remover")
	public String concluirOrcamento(@PathVariable Long id) {

		java.util.Optional<Orcamento> opt = em.findById(id);

		if (!opt.isEmpty()) {
			Orcamento orcamento = opt.get();

			List<Participante> participantes = pa.findByOrcamento(orcamento);

			pa.deleteAll(participantes);
			em.delete(orcamento);
		}

		return "redirect:/orcamentos";
	}
	
}