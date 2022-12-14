package ifrn.pi.empresa.controllers;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;

	import ifrn.pi.empresa.models.Empresa;
import ifrn.pi.empresa.models.Participante;
import ifrn.pi.empresa.repositories.EmpresaRepository;
import ifrn.pi.empresa.repositories.ParticipanteRepository;

	@Controller
	@RequestMapping("/empresas")
	public class EmpresasController {
		
		@Autowired
		private EmpresaRepository em;
		@Autowired
		private ParticipanteRepository pa;

		@GetMapping("/form")
		public String form() {
		return "empresas/formOrçamento";
		}
		
		@PostMapping
		public String adicionar(Empresa empresa) {
			System.out.println(empresa);
			em.save(empresa);
			return "empresas/orçamento-verificado";
		}
		
		@GetMapping
		public ModelAndView listar() {
			List<Empresa> empresas = em.findAll();
			ModelAndView mv = new ModelAndView("empresas/lista");
			mv.addObject("empresas", empresas);
			return mv;
		}
		
		@GetMapping("/{id}")
		public ModelAndView detalhar(@PathVariable Long id) {
			ModelAndView md = new ModelAndView();
			java.util.Optional<Empresa> opt = em.findById(id);
			
			if(opt.isEmpty()) {
				md.setViewName("redirect:/empresas");
				return md;
			}
			
			md.setViewName("empresas/detalhes");
			Empresa empresa = opt.get();
			md.addObject("empresa", empresa);
			
			List<Participante> participantes = pa.findByEmpresa(empresa);
			md.addObject("participantes", participantes);
			return md;
		}
		
		@PostMapping("/{idEmpresa}")
		public String salvarParticipante(@PathVariable Long idEmpresa, Participante participante) {
			System.out.println("ID da empresa: " + idEmpresa);
			System.out.println(participante);
			
			java.util.Optional<Empresa> opt = em.findById(idEmpresa);
			if (opt.isEmpty()) {
				return "redirect:/empresas";
			}
			
			Empresa empresa = opt.get();
			participante.setEmpresa(empresa);
			
			pa.save(participante);
			
			return "redirect:/empresas/{idEmpresa}";
		}
		
		@GetMapping("/{idEmpresa}/participantes/{idParticipante}/remover")
		public String apagarParticipante(@PathVariable Long idEmpresa, @PathVariable Long idParticipante) {

		java.util.Optional<Empresa> optEmpresa = em.findById(idEmpresa);
		java.util.Optional<Participante> optParticipante = pa.findById(idParticipante);

		if (!optEmpresa.isEmpty() || !optParticipante.isEmpty()) {
			Empresa empresa = optEmpresa.get();
			List<Participante> participantes = pa.findByEmpresa(empresa);

			pa.deleteAll(participantes);
		}

		return "redirect:/empresas";
		
		}
		
		@GetMapping("/{id}/remover")
		public String apagarEvento(@PathVariable Long id) {

			java.util.Optional<Empresa> opt = em.findById(id);

			if (!opt.isEmpty()) {
				Empresa empresa = opt.get();

				List<Participante> participantes = pa.findByEmpresa(empresa);

				pa.deleteAll(participantes);
				em.delete(empresa);
			}

			return "redirect:/empresas";
		}
		
}