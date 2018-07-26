package com.neoris.oraclerestapi.dao.oracle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.neoris.oraclerestapi.dao.IProveedorDAO;
import com.neoris.oraclerestapi.entity.Proveedor;



@Transactional
@Repository
public class ProveedorDAOImpl implements IProveedorDAO {
	@PersistenceContext
	private EntityManager entityManager;	

	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> getAllProveedores() {
		String hql = "FROM Proveedor as prov ORDER BY prov.proveedorid";
		return (List<Proveedor>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Proveedor getProveedorById(int proveedorId) {
		return entityManager.find(Proveedor.class, proveedorId);
	}

	@Override
	public void addProveedor(Proveedor proveedor) {
		entityManager.persist(proveedor);
		
	}

	@Override
	public void updateProveedor(Proveedor proveedor) {
		Proveedor prov = getProveedorById(proveedor.getProveedorid());
		prov.setProveedorid(proveedor.getProveedorid());
		prov.setNombreprov(proveedor.getNombreprov());
		prov.setContacto(proveedor.getContacto());
		prov.setCeluprov(proveedor.getCeluprov());
		prov.setFijoprov(proveedor.getFijoprov());
		try {
			
		}catch(PersistenceException e) {
			
		}
		entityManager.flush();
		
	}

	@Override
	public void deleteProveedor(int proveedorId) {
		entityManager.remove(getProveedorById(proveedorId));
		
	}

	@Override
	public boolean proveedorExists(String nombreProv, String celuProv) {
		String hql = "FROM Proveedor as prov WHERE prov.nombreprov like :nombre and prov.celuprov like :celu";
		int count = entityManager.createQuery(hql).setParameter("nombre", nombreProv)
		              .setParameter("celu", celuProv).getResultList().size();
		return count > 0 ? true : false;
	}

}
