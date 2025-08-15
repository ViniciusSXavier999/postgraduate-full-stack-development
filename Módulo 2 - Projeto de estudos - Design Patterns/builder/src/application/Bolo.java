package application;

public class Bolo {

	private  double acucar;
	private  double manteiga;
	private  int ovos;
	private  int baunilha;
	private  double farinha;
	private  double fermentoEmPo;
	private  double leite;
	private  int cereja;
	
	private Bolo (Builder b) {
		this.acucar = b.acucar;
		this.manteiga = b.manteiga;
		this.ovos = b.ovos;
		this.baunilha = b.baunilha;
		this.farinha = b.farinha;
		this.fermentoEmPo = b.fermentoEmPo;
		this.leite = b.leite;
		this.cereja = b.cereja;
	}

	public static class Builder {
		
		private double acucar;
		private double manteiga; 
		private int ovos; 
		private int baunilha; 
		private double farinha; 
		private double fermentoEmPo; 
		private double leite;
		private int cereja;
		
		public Builder acucar(double xicara) {
			this.acucar = xicara;
			return this;
		}
		
		public Builder manteiga(double xicara) {
			this.manteiga = xicara;
			return this;
		}
		
		public Builder ovos(int xicara) {
			this.ovos = xicara;
			return this;
		}
		
		public Builder baunilha(int xicara) {
			this.baunilha = xicara;
			return this;
		}
		
		public Builder farinha(double xicara) {
			this.farinha = xicara;
			return this;
		}
		
		public Builder fermentoEmPo(double xicara) {
			this.fermentoEmPo = xicara;
			return this;
		}
		
		public Builder leite(double xicara) {
			this.leite = xicara;
			return this;
		}
		
		public Builder cereja(int xicara) {
			this.cereja = xicara;
			return this;
		}
		
		public Bolo build() {
			return new Bolo(this);
		}
		
	}

	@Override
	public String toString() {
		return "Bolo [acucar=" + acucar + ", manteiga=" + manteiga + ", ovos=" + ovos + ", baunilha=" + baunilha
				+ ", farinha=" + farinha + ", fermentoEmPo=" + fermentoEmPo + ", leite=" + leite + ", cereja=" + cereja
				+ "]";
	}
	 

}
