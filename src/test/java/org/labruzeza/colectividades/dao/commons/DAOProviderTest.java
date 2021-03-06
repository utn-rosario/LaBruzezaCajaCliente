/*
 * Created on 21 oct 2016 ( Time 11:36:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.labruzeza.colectividades.dao.commons;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit tests for DAOProvider 
 * 
 * @author Telosys Tools
 *
 */
public class DAOProviderTest {


	@Test
	public void test1() throws SQLException {
    	System.out.println("test DAOProvider ");

		//--- Test for each DAO interface
    	tryToGetDAO( org.labruzeza.colectividades.dao.ConfiguracionDAO.class );
    	tryToGetDAO( org.labruzeza.colectividades.dao.LineadeventaDAO.class );
    	tryToGetDAO( org.labruzeza.colectividades.dao.ProductoDAO.class );
    	tryToGetDAO( org.labruzeza.colectividades.dao.VentaDAO.class );
	}

	private <T> void tryToGetDAO(Class<T> interfaceClass) throws SQLException {
    	System.out.println("--- "  );
    	System.out.println("trying to get DAO for interface '" + interfaceClass.getCanonicalName() + "'...");

    	T dao = DAOProvider.getDAO(interfaceClass);
    	System.out.println("OK, DAO instance ready, class : '" + dao.getClass().getCanonicalName() + "'" );
    	
    	Assert.assertNotNull( dao );
    	Assert.assertTrue( interfaceClass.isAssignableFrom(dao.getClass()) );
	}
}
