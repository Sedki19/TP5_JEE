package metier.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "PCS")
public class Pcs implements Serializable{
	@Id
	@Column (name = "ID_PC")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long idPcs;
	
	@Column (name = "NOM_PC")
private String nomPcs;

private double prix;
private String Specs;
public Pcs() {
super();
}
public Pcs(String nomPcs, double prix,String Specs) {
super();
this.nomPcs = nomPcs;
this.prix = prix;
this.Specs = Specs;
}
public Long getIdPcs() {
return idPcs;
}
public void setIdPcs(Long idPcs) {
this.idPcs = idPcs;
}
public String getNomPcs() {
return nomPcs;
}
public void setNomPcs(String nomPcs) {
this.nomPcs = nomPcs;
}
public double getPrix() {
return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
	}
public String getSpecs() {
	return Specs;
}
public void setSpecs(String specs) {
	Specs = specs;
}
	}