package game;



/**
 * Classe Prato que contem informa��es como nome do prato e alguma caracteristica que o descreva. 
 * @author gabriel-coutinho
 *
 */
public class Prato {
	private String nome;
	private String descricao;
	
	public Prato() {
	}
	
	public Prato(String nome) {
		this.nome = nome;
	}

	public Prato(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	/**
	 * Retorna o nome do prato.
	 */

	public String toString() {
		return this.nome;
	}

	
}