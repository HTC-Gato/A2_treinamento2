package modelo;
import java.util.ArrayList;
import java.util.List;

public class Pessoa implements Impressao{
	
	private String nome;
	private int idade;
	private Sexo sexo;
    private List<Telefone> telefones;
    
	public Pessoa(String nome, int idade, Sexo sexo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.telefones = new ArrayList();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public void adicionarTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", telefones=" + telefones + "]";
	}

	public void imprimir() {
	        System.out.println(this.toString());
	    }
    
}
