package entities;

public class ItemDoPedido {
	
	private Integer quantity;
	private Double price;
	
	private Produto produto;
	
	public ItemDoPedido() {
		
	}

	public ItemDoPedido(Integer quantity, Double price, Produto produto) {
		this.quantity = quantity;
		this.price = price;
		this.produto = produto;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	
	
}
