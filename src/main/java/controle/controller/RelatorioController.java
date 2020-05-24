package controle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controle.entity.Codigo;
import controle.service.RelatorioService;

@Controller
@RequestMapping("relatorio")
public class RelatorioController {

	@Autowired
	private RelatorioService service;

	public ModelAndView model(Codigo codigo, String sucesso, String erro) {
		return new ModelAndView("relatorio/form")
			.addObject("codigo", codigo)
			.addObject("sucesso", sucesso)
			.addObject("erro", erro);
	}
	
	@GetMapping
	public ModelAndView get() {
		return model(new Codigo(), null, null);
	}

	@PostMapping
	public Object post(@Valid @ModelAttribute("codigo") Codigo codigo, BindingResult result) {
		if(result.hasErrors()) {
			return model(codigo, null, "Erro ao criar o relatório");
		}
		
		try {
			byte[] arquivoDonwload = service.gera();
			HttpHeaders httpHeaders = new HttpHeaders();
		    httpHeaders.add("Content-Disposition", "attachment;filename=\"relatorio.csv"+"\"");
		
		    return new HttpEntity<byte[]>(arquivoDonwload, httpHeaders);
		} catch (RuntimeException e) {
			return model(codigo, null, e.getMessage());
		}
	}
}
