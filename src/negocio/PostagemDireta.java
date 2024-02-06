package negocio;
/**
 * Classe postagem direta que herda da classe postagem e se difere pelo atributo destinatario
 * @author João Pedro
 * @author Rafael Gomes
 */
public class PostagemDireta extends Postagem {
	
	//Atributos
	private String idDoDestinatario;
	
	/**
	 * Cria uma nova postagem direta.
	 * @param idDoUsuario
	 * @param idDoDestinatario
	 * @param texto
	 * @param dataHora
	 */
	public PostagemDireta(String idDoUsuario, String idDoDestinatario, String texto, String dataHora ) {
		super(idDoUsuario, texto, dataHora);
		this.idDoDestinatario = idDoDestinatario;
	}
	
	/**
	 * Retorna o id do destinatario da postagem direta.
	 * @return String
	 */
	public String getIdDoDestinatario() {
		return idDoDestinatario;
	}
	
	/**
	 * Deleta postagem direta.
	 * @param post
	 * @param usuario
	 */
	public void deletarPostagemDireta(Postagem post, Usuario usuario) {
		usuario.getPostagensDiretas().remove(post);
	}
	
	/**
	 * Sobrescreve o metodo toString da classe.
	 * @return String
	 */
	@Override
	public String toString() {
		return  "\n\nDe: "
				+ getIdDoUsuario()
				+"\nPara: " 
				+ idDoDestinatario 
				+ "\n"
				+ getTexto()
				+"\nEnviado em: "
				+ getDataHora(); 
	}
}
