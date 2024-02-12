package Model;



public class Tarefas {
	private int id;
	private String titulo;
	private String descricao;
	private String data;
	private String prioridade;

	public Tarefas(int id, String titulo, String descricao, String data, String prioridade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.prioridade = prioridade;
	}

	public Tarefas() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

}
