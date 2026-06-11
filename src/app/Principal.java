package app;

import java.util.ArrayList;
import modelo.Pessoa;
import modelo.Sexo;
import modelo.Telefone;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		 List<Pessoa> listaDePessoas = new ArrayList<>();
	
	

	        System.out.println("CADASTROS ");
	       
			for (int i = 0; i < 5; i++) {
	            System.out.println("Cadastrando Pessoa " + (i + 1) + "/" + 5);
	            listaDePessoas.add(lerDados());
	        }

	        System.out.println("Lista de Cadastrados");
	        imprimirLista(listaDePessoas);

	
	        System.out.println("Cadastrados do sexo masculino");
	        imprimirLista(listaDePessoas, Sexo.MASCULINO);
	        
	        System.out.println("Cadastrados do sexo feminino");
	        imprimirLista(listaDePessoas, Sexo.FEMININO);

	        
	        imprimirListaOrdenadaPorNome(listaDePessoas);
	        imprimirListaOrdenadaPorIdade(listaDePessoas);
	        imprimirListaOrdenadaPorSexo(listaDePessoas);

	       
	        imprimirListaOrdenadaPorNomeLambda(listaDePessoas);
	        imprimirListaOrdenadaPorIdadeLambda(listaDePessoas);
	        imprimirListaOrdenadaPorSexoLambda(listaDePessoas);

	        
			scanner.close();
	        System.out.println("--- FIM ---");
	    }

	    
	    public static Pessoa lerDados() {
	        System.out.print("Informe seu nome: ");
			String nome = scanner.nextLine();

	        System.out.print("Infome sua idade: ");
	        int idade = Integer.parseInt(scanner.nextLine());

	        System.out.print("Informe seu sexo (1 para MASCULINO, 2 para FEMININO): ");
	        int sexoOp = Integer.parseInt(scanner.nextLine());
	        Sexo sexo = (sexoOp == 1) ? Sexo.MASCULINO : Sexo.FEMININO;

	        Pessoa pessoa = new Pessoa(nome, idade, sexo);

	        System.out.print("Quantos telefones você possui ? ");
	        int qtdeTelefones = Integer.parseInt(scanner.nextLine());

	        for (int i = 0; i < qtdeTelefones; i++) {
	            System.out.print("Digite seu DDD: ");
	            String ddd = scanner.nextLine();
	            System.out.print("Digite seu Numero: ");
	            String numero = scanner.nextLine();
	            pessoa.adicionarTelefone(new Telefone(ddd, numero));
	        }

	        System.out.println("Pessoa cadastrada!");
	        return pessoa;
	    }

	    public static void imprimirLista(List<Pessoa> lista) {
	        System.out.println("---------------------------------");
	        for (Pessoa p : lista) {
	            p.imprimir();
	        }
	        System.out.println("---------------------------------");
	    }

	  
	    public static void imprimirLista(List<Pessoa> lista, Sexo sexo) {
	        System.out.println("---------------------------------");
	        System.out.println("Filtrando por: " + sexo);
	        for (Pessoa p : lista) {
	            if (p.getSexo() == sexo) {
	                p.imprimir();
	            }
	        }
	        System.out.println("---------------------------------");
	    }

	    
	    public static void imprimirListaOrdenadaPorNome(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);
	        
	        listaCopiada.sort(new java.util.Comparator<Pessoa>() {
	            @Override
	            public int compare(Pessoa o1, Pessoa o2) {
	                return o1.getNome().compareTo(o2.getNome());
	            }
	        });
	        
	        System.out.println("Cadastrados ordenados por nome");
	        imprimirLista(listaCopiada);
	    }

	    public static void imprimirListaOrdenadaPorIdade(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);

	        listaCopiada.sort(new java.util.Comparator<Pessoa>() {
	            @Override
	            public int compare(Pessoa o1, Pessoa o2) {
	                if (o1.getIdade() < o2.getIdade()) {
	                    return -1;
	                } else if (o1.getIdade() == o2.getIdade()) {
	                    return 0;
	                } else {
	                    return 1;
	                }
	            }
	        });

	        System.out.println("Cadastrados ordenados por idade");
	        imprimirLista(listaCopiada);
	    }

	    public static void imprimirListaOrdenadaPorSexo(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);
	        
	        listaCopiada.sort(new java.util.Comparator<Pessoa>() {
	            @Override
	            public int compare(Pessoa o1, Pessoa o2) {
	                return o1.getSexo().compareTo(o2.getSexo());
	            }
	        });
	        
	        System.out.println("Cadastrados ordenados por sexo");
	        imprimirLista(listaCopiada);
	    }

	    // --- Lambda ---
	    public static void imprimirListaOrdenadaPorNomeLambda(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);
	        
	        listaCopiada.sort( (o1, o2) -> o1.getNome().compareTo(o2.getNome()) );
	        
	        System.out.println("Cadastrados ordenados por nome (Lambda)");
	        imprimirLista(listaCopiada);
	    }

	    public static void imprimirListaOrdenadaPorIdadeLambda(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);

	        listaCopiada.sort( (o1, o2) -> Integer.compare(o1.getIdade(), o2.getIdade()) );

	        System.out.println("Cadastrados ordenados por idade (Lambda)");
	        imprimirLista(listaCopiada);
	    }

	    public static void imprimirListaOrdenadaPorSexoLambda(List<Pessoa> lista) {
	        List<Pessoa> listaCopiada = new ArrayList<>(lista);
	        
	        listaCopiada.sort( (o1, o2) -> o1.getSexo().compareTo(o2.getSexo()) );
	        
	        System.out.println("Cadastrados ordenados por sexo (Lambda)");
	        imprimirLista(listaCopiada);
	    }
	 


     

   	// TODO Auto-generated method stub
		
	


	public static void impressao(Pessoa pessoa) {
        pessoa.imprimir();
    }
    public static void impressao(Telefone telefone) {
        telefone.imprimir();
    }
}
