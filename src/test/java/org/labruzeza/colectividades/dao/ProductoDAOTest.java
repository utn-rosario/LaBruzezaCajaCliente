/*
 * Created on 21 oct 2016 ( Time 11:36:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.labruzeza.colectividades.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.labruzeza.colectividades.dao.commons.DAOProvider;
import org.labruzeza.colectividades.dao.commons.DAOTestUtil;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.labruzeza.colectividades.modelo.Producto;

/**
 * JUnit tests for ProductoDAO
 * 
 * @author Telosys Tools
 *
 */
public class ProductoDAOTest {


	private static final String CREATE_TABLE = 
			 "CREATE TABLE producto ("
			+ "idproducto IDENTITY AUTO_INCREMENT NOT NULL,"
			+ "nombre VARCHAR(90) ,"
			+ "precio DECIMAL ,"
			+ "PRIMARY KEY(idproducto)"
			+ ");"
			;

	@BeforeClass
	public static void init() {
		DAOTestUtil.initDatabase(CREATE_TABLE) ;
	}

	@Test
	public void testDAO() throws SQLException {
    	System.out.println("test ProductoDAO ");
    	ProductoDAO dao = DAOProvider.getDAO(ProductoDAO.class);

    	Assert.assertTrue( dao.count() == 0 );

    	Producto producto = new Producto();
		//--- Key values
		// Auto-incremented key : nothing to set in the Primary Key
		//--- Other values
		producto.setNombre("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); // "nombre" : java.lang.String
		producto.setPrecio((new BigDecimal(10000))); // "precio" : java.math.BigDecimal

    	//--- INSERT
    	System.out.println("Insert : " + producto );
    	Integer pkAutoIncr = dao.insert(producto);
    	producto.setIdproducto( pkAutoIncr );
    	Assert.assertTrue( dao.exists(pkAutoIncr) );
    	Assert.assertTrue( dao.count() == 1 );
    	Assert.assertTrue( dao.exists(producto) );
    	
    	//--- FIND
    	System.out.println("Find..." );
    	Producto producto2 = dao.find(pkAutoIncr);
    	Assert.assertNotNull(producto2);
    	Assert.assertTrue( dao.exists(producto2) ) ;
    	
    	//--- UPDATE
		//--- Change values
		producto2.setNombre("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"); // "nombre" : java.lang.String
		producto2.setPrecio((new BigDecimal(20000))); // "precio" : java.math.BigDecimal
    	System.out.println("Update : " + producto2 );
    	Assert.assertTrue( dao.update(producto2) == 1 );
    	
    	//--- LOAD
    	Producto producto3 = new Producto();
    	producto3.setIdproducto( pkAutoIncr );
    	Assert.assertTrue( dao.load(producto3) );
    	System.out.println("Loaded : " + producto3 );
		Assert.assertEquals(producto2.getNombre(), producto3.getNombre() ); 
		Assert.assertEquals(producto2.getPrecio(), producto3.getPrecio() ); 


    	producto3.setIdproducto(300);
    	Assert.assertFalse( dao.load(producto3) );
    	
    	//--- DELETE
    	System.out.println("Delete : " + producto2 );
    	Assert.assertTrue( dao.delete(producto2) == 1 );
    	Assert.assertTrue( dao.delete(producto2) == 0 );
    	Assert.assertTrue( dao.delete(100) == 0 );

    	Assert.assertTrue( dao.count() == 0 );
    	Assert.assertFalse( dao.exists(100) ) ;
    	Assert.assertFalse( dao.exists(producto2) ) ;
    	producto2 = dao.find(100);
    	Assert.assertNull( producto2 );
    	
    	System.out.println("Normal end of DAO test." );
	}

}