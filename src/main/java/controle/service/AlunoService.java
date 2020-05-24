package controle.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import controle.entity.Aluno;
import controle.repository.AlunoRepository;

@Service
public class AlunoService {	
	
	@Autowired
	private AlunoRepository repository;

	@Transactional
	public Aluno save(Aluno aluno) {
		Optional<Aluno> optional = repository.findById(aluno.getEmail());	
		
		if(optional.isPresent()) aluno = optional.get();
		
		LocalDate atual = LocalDate.now();
		if(!aluno.getDatas().contains(atual)) aluno.getDatas().add(atual);
		
		repository.save(aluno);
		
		return aluno;
	}
	
	public List<Aluno> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "email"));
	}
}
