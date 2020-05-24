package controle;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleAlunosApplication {
	
	public final static String CODIGO = "abcd";
	
	public static void main(String[] args) {
		SpringApplication.run(ControleAlunosApplication.class, args);
		System.out.println("http://localhost:8080");
		
		try {
			System.out.println("http://"+InetAddress.getLocalHost().getHostAddress()+":8080");
		} catch (UnknownHostException e) {
			
		}
	}
}
