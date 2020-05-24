package controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import controle.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

}
