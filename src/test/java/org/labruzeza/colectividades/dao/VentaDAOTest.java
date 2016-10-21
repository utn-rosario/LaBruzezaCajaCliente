/*
 * Created on 21 oct 2016 ( Time 11:36:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.labruzeza.colectividades.dao;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.labruzeza.colectividades.dao.commons.DAOProvider;
import org.labruzeza.colectividades.dao.commons.DAOTestUtil;
import org.labruzeza.colectividades.modelo.Venta;

/**
 * JUnit tests for VentaDAO
 * 
 * @author Telosys Tools
 *
 */
public class VentaDAOTest {


	private static final String CREATE_TABLE = 
			 "CREATE TABLE venta ("
			+ "idventa IDENTITY AUTO_INCREMENT NOT NULL,"
			+ "codigo VARCHAR(45) ,"
			+ "fecha DATE ,"
			+ "PRIMARY KEY(idventa)"
			+ ");"
			;

	@BeforeClass
	public static void init() {
		DAOTestUtil.initDatabase(CREATE_TABLE) ;
	}

	@Test
	public void testDAO() throws SQLException {
    	System.out.println("test VentaDAO ");
    	VentaDAO dao = DAOProvider.getDAO(VentaDAO.class);

    	Assert.assertTrue( dao.count() == 0 );

    	Venta venta = new Venta();
		//--- Key values
		// Auto-incremented key : nothing to set in the Primary Key
		//--- Other values
		venta.setCodigo("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "codigo" : java.lang.String
		venta.setFecha(java.sql.Date.valueOf("2001-06-22")); // "fecha" : java.util.Date

    	//--- INSERT
    	System.out.println("Insert : " + venta );
    	Integer pkAutoIncr = dao.insert(venta);
    	venta.setIdventa( pkAutoIncr );
    	Assert.assertTrue( dao.exists(pkAutoIncr) );
    	Assert.assertTrue( dao.count() == 1 );
    	Assert.assertTrue( dao.exists(venta) );
    	
    	//--- FIND
    	System.out.println("Find..." );
    	Venta venta2 = dao.find(pkAutoIncr);
    	Assert.assertNotNull(venta2);
    	Assert.assertTrue( dao.exists(venta2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		venta2.setCodigo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "codigo" : java.lang.String
		venta2.setFecha(java.sql.Date.valueOf("2002-06-22")); // "fecha" : java.util.Date
    	System.out.println("Update : " + venta2 );
    	Assert.assertTrue( dao.update(venta2) == 1 );
    	
    	//--- LOAD
    	Venta venta3 = new Venta();
    	venta3.setIdventa( pkAutoIncr );
    	Assert.assertTrue( dao.load(venta3) );
    	System.out.println("Loaded : " + venta3 );
		Assert.assertEquals(venta2.getCodigo(), venta3.getCodigo() ); 
		Assert.assertEquals(venta2.getFecha(), venta3.getFecha() ); 


    	venta3.setIdventa(300);
    	Assert.assertFalse( dao.load(venta3) );
    	
    	//--- DELETE
    	System.out.println("Delete : " + venta2 );
    	Assert.assertTrue( dao.delete(venta2) == 1 );
    	Assert.assertTrue( dao.delete(venta2) == 0 );
    	Assert.assertTrue( dao.delete(100) == 0 );

    	Assert.assertTrue( dao.count() == 0 );
    	Assert.assertFalse( dao.exists(100) ) ;
    	Assert.assertFalse( dao.exists(venta2) ) ;
    	venta2 = dao.find(100);
    	Assert.assertNull( venta2 );
    	
    	System.out.println("Normal end of DAO test." );
	}

}