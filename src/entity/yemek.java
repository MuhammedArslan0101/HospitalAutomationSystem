package entity;

public class yemek {
	
	private Integer idyemek_gs ;
	private String ady_gs ;
	private Integer odano ;
	private String yemektur_gs ;
	private String durumtur_gs ;
	public yemek(Integer idyemek_gs, String ady_gs, Integer odano, String yemektur_gs, String durumtur_gs) {
		super();
		this.idyemek_gs = idyemek_gs;
		this.ady_gs = ady_gs;
		this.odano = odano;
		this.yemektur_gs = yemektur_gs;
		this.durumtur_gs = durumtur_gs;
	}
	public yemek() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "yemek [idyemek_gs=" + idyemek_gs + ", ady_gs=" + ady_gs + ", odano=" + odano + ", yemektur_gs="
				+ yemektur_gs + ", durumtur_gs=" + durumtur_gs + "]";
	}
	public Integer getIdyemek_gs() {
		return idyemek_gs;
	}
	public void setIdyemek_gs(Integer idyemek_gs) {
		this.idyemek_gs = idyemek_gs;
	}
	public String getAdy_gs() {
		return ady_gs;
	}
	public void setAdy_gs(String ady_gs) {
		this.ady_gs = ady_gs;
	}
	public Integer getOdano() {
		return odano;
	}
	public void setOdano(Integer odano) {
		this.odano = odano;
	}
	public String getYemektur_gs() {
		return yemektur_gs;
	}
	public void setYemektur_gs(String yemektur_gs) {
		this.yemektur_gs = yemektur_gs;
	}
	public String getDurumtur_gs() {
		return durumtur_gs;
	}
	public void setDurumtur_gs(String durumtur_gs) {
		this.durumtur_gs = durumtur_gs;
	}
	
	

}
