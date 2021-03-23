package entity;

import java.time.LocalDate;

public class hasta extends personel{
	
	
    private Integer hastaid;
    private String id_ad;
    private String tcid;
    private String kan_id;
    private String polik_id;
    private String doktor_id;
    private LocalDate tarih_id;
    


	public hasta() { 

		// TODO Auto-generated constructor stub
	}

	public hasta(Integer idper_gs, String adper_gs, String soyper_gs, String tcper_gs, String personeltur_gs,
			long teleper_gs, Integer massper_gs, String polikper_gs, LocalDate tarihper_gs) {
		super(idper_gs, adper_gs, soyper_gs, tcper_gs, personeltur_gs, teleper_gs, massper_gs, polikper_gs,
				tarihper_gs);
	}

	@Override
	public String toString() {
		return "hasta [hastaid=" + hastaid + ", id_ad=" + id_ad + ", tcid=" + tcid + ", kan_id=" + kan_id
				+ ", polik_id=" + polik_id + ", doktor_id=" + doktor_id + ", tarih_id=" + tarih_id + "]";
	}

	public hasta(Integer hastaid, String id_ad, String tcid, String kan_id, String polik_id, String doktor_id,
			LocalDate tarih_id) {
		super();
		this.hastaid = hastaid;
		this.id_ad = id_ad;
		this.tcid = tcid;
		this.kan_id = kan_id;
		this.polik_id = polik_id;
		this.doktor_id = doktor_id;
		this.tarih_id = tarih_id;
	}

	public String getKan_id() {
		return kan_id;
	}

	public void setKan_id(String kan) {
		this.kan_id = kan;
	}

	public Integer getHastaid() {
		return hastaid;
	}

	public void setHastaid(Integer hastaid) {
		this.hastaid = hastaid;
	}

	public String getId_ad() {
		return id_ad;
	}

	public void setId_ad(String id_ad) {
		this.id_ad = id_ad;
	}

	public String getTcid() {
		return tcid;
	}

	public void setTcid(String tcid) {
		this.tcid = tcid;
	}

	public String getPolik_id() {
		return polik_id;
	}

	public void setPolik_id(String polik_id) {
		this.polik_id = polik_id;
	}

	public String getDoktor_id() {
		return doktor_id;
	}

	public void setDoktor_id(String doktor_id) {
		this.doktor_id = doktor_id;
	}

	public LocalDate getTarih_id() {
		return tarih_id;
	}

	public void setTarih_id(LocalDate tarih_id) {
		this.tarih_id = tarih_id;
	}

	
    
    
	

}
