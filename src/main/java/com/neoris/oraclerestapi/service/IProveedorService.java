package com.neoris.oraclerestapi.service;

import java.util.List;

import com.neoris.oraclerestapi.entity.Proveedor;





public interface IProveedorService {
	 
     List<Proveedor> getAllProveedores();
   
     Proveedor getProveedorById(int proveedorId);
     
     boolean addProveedor(Proveedor proveedor);
    
     void updateProveedor(Proveedor proveedor);
    
     void deleteProveedor(int proveedorId);

}
