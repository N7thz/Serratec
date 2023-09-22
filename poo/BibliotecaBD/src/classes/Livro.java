package classes;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private int numPaginas;
	private String editora;
	private int quantidade;
	private int idlivro;
	
	public enum Localizar{
		TITULO,
		AUTOR,
		ISBN,
		EDITORA
	}
	
	public boolean saldoInicial(int quant) {		
		if (quant > 0) {
			setQuantidade(quant);
			return true;
		} else {
			System.out.println("Quantidade invalida.");
			return false;
		}
	}
	
	public void dadosLivro() {
		System.out.printf("Titulo: %s%n", this.titulo);
		System.out.printf("Autor: %s%n", this.autor);
		System.out.printf("ISBN: %s%n", this.isbn);
		System.out.printf("Editora: %s%n", this.editora);
		System.out.printf("Numero de paginas: %s%n", this.numPaginas);
		System.out.printf("Quantidade disponivel: %d%n", this.quantidade);
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIdlivro() {
		return idlivro;
	}

	public void setIdlivro(int idlivro) {
		this.idlivro = idlivro;
	}

}
