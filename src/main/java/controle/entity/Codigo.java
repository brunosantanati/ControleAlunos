package controle.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import controle.validator.CodigoTexto;

public class Codigo {

	@CodigoTexto(message = "Código inválido")
	@NotBlank(message = "Código é obrigatório")
	@NotEmpty(message = "Código é obrigatório")
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Codigo [texto=" + texto + "]";
	}
}
