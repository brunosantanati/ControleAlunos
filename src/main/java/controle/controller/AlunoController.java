package controle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controle.entity.Aluno;
import controle.service.AlunoService;

@Controller
@RequestMapping("aluno")
public class AlunoController {

	@Autowired
	private AlunoService service;

	public ModelAndView model(Aluno aluno, String sucesso, String erro) {
		return new ModelAndView("aluno/form")
			.addObject("aluno", aluno)
			.addObject("sucesso", sucesso)
			.addObject("erro", erro);
	}
	
	@GetMapping
	public ModelAndView get() {
		return model(new Aluno(), null, null);
	}

	@PostMapping
	public ModelAndView post(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult result) {
		if(result.hasErrors()) {
			return model(aluno, null, "Erro ao efetuar o cadastro");
		}
		
		service.save(aluno);
		
		return model(aluno, "Cadastro de Aluno efetuado com sucesso!!!", null);
	}
}
