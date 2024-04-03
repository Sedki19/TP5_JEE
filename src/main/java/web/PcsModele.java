package web;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Pcs;
public class PcsModele {
private String motCle;

List<Pcs> Pcss = new ArrayList<>();


public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<Pcs> getPcss() {
return Pcss;
}
public void setPcss(List<Pcs> Pcs) {
this.Pcss = Pcs;
}

}