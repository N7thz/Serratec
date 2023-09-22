import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

	private String nome;
	private String cpf;
	private Date dataNasc;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	public Pessoa(){};
	
	
	public Pessoa (String nome, String cpf, Date dataNasc) {
		this.nome = nome;
		this.cpf = cpf; 
		this.dataNasc = dataNasc;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public boolean setDataNasc(String dataNasc) {
		try {
			this.dataNasc = sdf.parse(dataNasc);
			return true;
		} catch (ParseException e) {
			System.out.println("Data Invalida!!");
			return false;
		}
		
	}
	
	
	@Override
	public String toString () {
		return "NOME: "+this.nome+" CPF: "+this.cpf+" DATA: "+sdf.format(this.dataNasc);
	}
}
