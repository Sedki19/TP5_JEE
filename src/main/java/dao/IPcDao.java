package dao;

import java.util.List;
import metier.entities.Pcs;



public interface IPcDao {
	public Pcs save(Pcs p);
	public List<Pcs> PcssParMC(String mc);
	public Pcs getPcs(Long id);
	public Pcs updatePcs(Pcs p);
	public void deletePcs(Long id);
	
}
