package negocio;
/**
 * É uma superclasse que determina o comportamento basico de uma postagem.
 * @author João Pedro
 * @author Rafael Gomes
 * @since 2023
 * @version 1.1
 */
public abstract class Postagem {
	
	private String idDoUsuario;
	private String texto;
	private String dataHora;
	
	/**
	 * Instancia todos os atributos comuns do usuario.
	 * @param idDoUsuario
	 * @param texto
	 * @param dataHora
	 */
	public Postagem(String idDoUsuario, String texto, String dataHora) {
		this.idDoUsuario=idDoUsuario;
		this.texto=texto;
		this.dataHora=dataHora;
		
	}
	
	/**
	 * retorna o id do usuario autor da postagem.
	 * @return String
	 */
	public String getIdDoUsuario() {
		return idDoUsuario;
	}
	/**
	 * Retorna texto da postagem.
	 * @return String
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * Retorna a data e a hora que a postagem foi feita.
	 * @return String
	 */
	public String getDataHora() {
		return dataHora;
	}
	/**
	 * Edita a postagem.
	 * @param texto
	 */
	public void editarPostagem(String texto) {
		this.texto=texto;
	}

	/**
	 * Sobrescreve o metodo toString da classe.
	 * @return String
	 */
	public String toString() {
		return "\n"
				+ idDoUsuario
				+ "\n" 
				+ texto 
				+ "\nPostado em " 
				+ dataHora
				+"\n";
	}

	
}
