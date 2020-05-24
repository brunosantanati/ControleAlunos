package controle.service;

import java.util.Collections;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controle.entity.Aluno;

@Service
public class RelatorioService {
	
	@Autowired
	private AlunoService alunoService;
	
	public byte[] gera () {
		try {
			ByteArrayOutputStream arquivo = new ByteArrayOutputStream();
			arquivo.write("Nome;E-mail;\n".getBytes());
		
			for (Aluno aluno : alunoService.findAll()) {
				arquivo.write((aluno.getNome()+";"+aluno.getEmail()+";").getBytes());
				
				List<LocalDate> datas = aluno.getDatas();
				Collections.sort(datas);
				for (LocalDate data : datas) {
					arquivo.write((data+";").getBytes());
				}
				
				arquivo.write("\n".getBytes());
			}
			
			arquivo.flush();
			arquivo.close();
	
			return arquivo.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar o relatório, favor avisar o ADM do servidor");
		}		
	}
}
