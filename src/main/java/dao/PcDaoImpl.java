package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Pcs;
import util.JPAutil;

public class PcDaoImpl implements IPcDao {
	private EntityManager entityManager = JPAutil.getEntityManager("TP5_Pcs");

	@Override
	public Pcs save(Pcs p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
		return p;
	}

@Override
public List<Pcs> PcssParMC(String mc) {
List<Pcs> pcs = entityManager.createQuery("select p from Pcs p where p.nomPcs like :mc").setParameter("mc", "%"+mc+"%").getResultList();

return pcs;
}

	@Override
	public Pcs getPcs(Long id) {
		return entityManager.find(Pcs.class, id);
	}

	@Override
	public Pcs updatePcs(Pcs p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
		return p;
	}

	@Override
	public void deletePcs(Long id) {
		Pcs Pcs = entityManager.find(Pcs.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(Pcs);
		entityManager.getTransaction().commit();
	}
}