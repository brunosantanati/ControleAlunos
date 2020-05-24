package controle.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErroController implements ErrorController {

	@RequestMapping("/error")
	public ModelAndView handleError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
		
		List<String> erros = new ArrayList<>();
		
		if(exception != null) {
			exception.printStackTrace();
			erros.add(exception.getMessage());
		}
		
		if(statusCode != null) {
			switch (statusCode) {
				case 400: erros.add("Erro de Requisição");// BAD_REQUEST
				break;
				case 403: erros.add("Acesso Negado!!!"); // FORBIDDEN
				break;
				case 404: erros.add("Mapeamento inválido"); // NOT_FOUND
				break;
				case 405: erros.add("Metodo não suportado");// METHOD_NOT_ALLOWED
				break;
				case 500: erros.add("Erro Interno do Sistema");// INTERNAL_SERVER_ERROR
				break;
				default: erros.add("Erro Genérico");
			}
		}
		
		return new ModelAndView("erro")
				.addObject("statusCode", statusCode)
				.addObject("erros", erros);
	}

	@Override
	public String getErrorPath() {
		return "error";
	}
}
