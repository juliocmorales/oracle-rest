package com.neoris.oraclerestapi.dao;

import java.util.List;
import com.neoris.oraclerestapi.entity.Proveedor;

public interface IProveedorDAO {
	List<Proveedor> getAllProveedores();
    Proveedor getProveedorById(int proveedorId);
    void addProveedor(Proveedor proveedorId);
    void updateProveedor(Proveedor proveedor);
    void deleteProveedor(int proveedorId);
    boolean proveedorExists(String nombreProv, String celuProv);

}
