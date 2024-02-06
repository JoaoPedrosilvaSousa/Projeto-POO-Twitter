package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.Dados;

public class Usuario {
	
	/**
	 *Classe Usuario, define os atributos e metodos do Usuario na aplicação
	 *@author João Pedro
	 *@author Rafael Gomes
	 *@since 2023
	 *@version 1.1
	 *
	 */
	private String idDoUsuario;
	private String nome;
	private String biografia;
	private List<Usuario> seguidores;
	private List<Usuario> seguindo;
	private List<PostagemPublica> postagensPublicas;
	private List<PostagemDireta> postagensDiretas;
	
	/**
	 * Cria um novo usuario com os atributos comuns e o instancia.
	 * @param idDoUsuario
	 * @param nome
	 * @param biografia
	 */
	public Usuario(String idDoUsuario, String nome, String biografia) {
		this.idDoUsuario=idDoUsuario;
		this.nome=nome;
		this.biografia=biografia;
		seguidores = new ArrayList<>();
		seguindo = new ArrayList<>();
		postagensPublicas = new ArrayList<>();
		postagensDiretas = new ArrayList<>();
	}
	
	/**
	 * Retorna o nome do usuario.
	 * @return String
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Retorna a biografia do usuario
	 * @return String
	 */
	public String getBiografia() {
		return biografia;
	}
	/**
	 * Retorna a id do usuario.
	 * @return String 
	 */
	public String getIdDoUsuario() {
		return idDoUsuario;
	}
	/**
	 * Retorna a lista de quem o usuario segue.
	 * @return List<Usuario>
	 */
	public List<Usuario> getSeguindo(){
		return seguindo;
	}
	/**
	 * Retorna a lista de seguidores do usuario.
	 * @return List<Usuario>
	 */
	public List<Usuario> getSeguidores(){
		return seguidores;
	}
	/**
	 * Retorna as postagens pubnlicas do usuario.
	 * @return List<PostagemPublica>
	 */
	public List<PostagemPublica> getPostagensPublicas() {
		return postagensPublicas;
	}
	/**
	 * Retorna as postagens diretas do usuario.
	 * @return List<PostagensDiretas>
	 */
	public List<PostagemDireta> getPostagensDiretas() {
		return postagensDiretas;
	}
	
	/**
	 * Edita o nome e a bigrafia do usuario.
	 * @param nome
	 * @param biografia
	 */
	public void editarUsuario(String nome, String biografia ) {
		this.nome=nome;
		this.biografia=biografia;
	}
	/**
	 * Deleta o usuario.
	 * @param dados
	 */
	public void deletarUsuario(Dados dados) {
		dados.getUsuarios().remove(this);
	}
	/**
	 * Segue um outro usuario.
	 * @param usuario
	 */
	public void seguirUsuario(Usuario usuario) {
		seguindo.add(usuario);
		usuario.getSeguidores().add(this);
	}
	/**
	 * Para de seguir um outro usuario.
	 * @param usuario
	 */
	public void pararDeSeguirUsuario(Usuario usuario) {
		seguindo.remove(usuario);
		usuario.getSeguidores().remove(this);
	}
	/**
	 * Retorna lista de postagens publicas dos usuarios que o usuario segue.
	 * @return postagensseguindo
	 */
	public List<PostagemPublica> listarPostagensSeguindo() {
		List<PostagemPublica> postagensSeguindo = new ArrayList<>();
		for(Usuario seguindo : seguindo) {
			for(PostagemPublica postagem : seguindo.getPostagensPublicas()) {
				postagensSeguindo.add(postagem);
			}
		}
		return postagensSeguindo;
	}
	
	public void enviarPostagemDireta(PostagemDireta mensagem, Dados dados) {
		Usuario destinatario = dados.buscarUsuario(mensagem.getIdDoDestinatario());
		destinatario.getPostagensDiretas().add(mensagem);
		this.getPostagensDiretas().add(mensagem);	
	}
	/**
	 * Lista postagens diretas enviadas pelo usuario.
	 * @return postagensDiretasEnviadas
	 */
	public List<PostagemDireta> buscarPostagensDiretasEnviadas(){
		List<PostagemDireta> postagensDiretasEnviadas = new ArrayList<>();
		for(PostagemDireta p : postagensDiretas) {
			if(p.getIdDoUsuario().equals(this.idDoUsuario)) {
				postagensDiretasEnviadas.add(p);
			}
		}
		if(postagensDiretasEnviadas.size()>0) {
			return postagensDiretasEnviadas;
		}else {
			return null;
		}
	}
	/**
	 * Cria uma String para sobrescrever o toString da classe Object.
	 * @return String
	 */
	public String toString() {
		return "\n\n"
				+ getIdDoUsuario()
				+ "\n"
				+ getNome()
				+ "\n"
				+ getBiografia()
				+ "\nSeguindo: "
				+ getSeguindo().size()
				+ "\nSeguidores: "
				+ getSeguidores().size()
				+"\n"
				+ getPostagensPublicas().size()
				+ (getPostagensPublicas().size()==1?" postagem publica":" postagens publicas");
				
	}

}
