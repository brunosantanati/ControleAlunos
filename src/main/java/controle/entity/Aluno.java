package controle.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name = "aluno")
public class Aluno {

	@Id
	@NotBlank(message = "E-mail é obrigatório")
	@NotEmpty(message = "E-mail é obrigatório")
	@Length(message = "Digite um email com no máximo 100 caracteres", max = 100)
	@Email(message = "E-mail inválido")
	private String email;

	@NotBlank(message = "Nome é obrigatório")
	@NotEmpty(message = "Nome é obrigatório")
	@Length(message = "Digite um nome com até 100 caracteres", max = 100)
	private String nome;

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinColumn(name = "alunoEmail")
	@DateTimeFormat(iso = ISO.DATE)
	private List<LocalDate> datas = new ArrayList<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LocalDate> getDatas() {
		return datas;
	}

	public void setDatas(List<LocalDate> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Aluno [email=" + email + ", nome=" + nome + ", datas=" + datas + "]";
	}
}
