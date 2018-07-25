package com.neoris.oraclerestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neoris.oraclerestapi.dao.IProveedorDAO;
import com.neoris.oraclerestapi.entity.Proveedor;

@Service
public class ProveedorService implements IProveedorService {
	@Autowired
	private IProveedorDAO proveedorDAO;

	@Override
	public List<Proveedor> getAllProveedores() {
		return proveedorDAO.getAllProveedores();
	}

	@Override
	public Proveedor getProveedorById(int proveedorId) {
		Proveedor obj = proveedorDAO.getProveedorById(proveedorId);
		return obj;
	}

	@Override
	public synchronized boolean addProveedor(Proveedor proveedor) {
		if (proveedorDAO.proveedorExists(proveedor.getNombreprov(), proveedor.getCeluprov())) {
	        return false;
         } else {
	        proveedorDAO.addProveedor(proveedor);
	        return true;
         }
	}

	@Override
	public void updateProveedor(Proveedor proveedor) {
		proveedorDAO.updateProveedor(proveedor);		
	}

	@Override
	public void deleteProveedor(int proveedorId) {
		proveedorDAO.deleteProveedor(proveedorId);
		
	}

}
