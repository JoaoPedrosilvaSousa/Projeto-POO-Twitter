package negocio;
/**
 * Classe postagem publica herda da classe postagem.
 * @author João Pedro
 * @author Rafael Gomes
 */
public class PostagemPublica extends Postagem {
	/**
	 * Cria uma nova postagem publica.
	 * @param idDoUsuario
	 * @param texto
	 * @param dataHora
	 */
	public PostagemPublica(String idDoUsuario, String texto, String dataHora) {
		super(idDoUsuario, texto, dataHora);
	}
	/**
	 * Deleta uma postagem publica.
	 * @param post
	 * @param usuario
	 */
	public void deletarPostagemPublica(Postagem post, Usuario usuario) {
		usuario.getPostagensPublicas().remove(post);
	}
}