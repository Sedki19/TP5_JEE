package test;
import java.util.List;

import dao.PcDaoImpl;
import metier.entities.Pcs;
public class TestMetier {
	public static void main(String[] args) {
		PcDaoImpl pdao= new PcDaoImpl();
		Pcs prod= pdao.save(new Pcs("GF-90",2800,"I7 11eme gen"));
		System.out.println(prod);
		List<Pcs> prods =pdao.PcssParMC("ip");
		for (Pcs p : prods)
		System.out.println(p);
		}

}