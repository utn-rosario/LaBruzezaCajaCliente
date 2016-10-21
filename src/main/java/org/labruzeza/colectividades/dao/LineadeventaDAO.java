/*
 * Created on 21 oct 2016 ( Time 11:36:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.labruzeza.colectividades.dao;

import org.labruzeza.colectividades.modelo.Lineadeventa;

/**
 * Lineadeventa DAO interface
 * 
 * @author Telosys Tools
 */
public interface LineadeventaDAO {

	//----------------------------------------------------------------------
	/**
	 * Finds a bean by its primary key 
	 * @param idlineadeventa
	 * @return the bean found or null if not found 
	 */
	public Lineadeventa find( Integer idlineadeventa ) ;

	//----------------------------------------------------------------------
	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s) in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from the database<br>
	 * If not found, the given instance remains unchanged
	 * @param lineadeventa
	 * @return true if found, false if not found
	 */
	public boolean load( Lineadeventa lineadeventa ) ;
	
    //----------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database 
	 * @param lineadeventa
	 * @return the generated value for the auto-incremented column
	 */
	public Integer insert(Lineadeventa lineadeventa) ;

    //----------------------------------------------------------------------
	/**
	 * Updates the given bean in the database 
	 * @param lineadeventa
	 * @return
	 */
	public int update(Lineadeventa lineadeventa) ;

    //----------------------------------------------------------------------
	/**
	 * Deletes the record in the database using the given primary key value(s) 
	 * @param idlineadeventa
	 * @return
	 */
	public int delete( Integer idlineadeventa ) ;

    //----------------------------------------------------------------------
	/**
	 * Deletes the given bean in the database 
	 * @param lineadeventa
	 * @return
	 */
	public int delete( Lineadeventa lineadeventa ) ;

    //----------------------------------------------------------------------
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param idlineadeventa
	 * @return
	 */
	public boolean exists( Integer idlineadeventa ) ;

	//----------------------------------------------------------------------
	/**
	 * Checks the existence of the given bean in the database 
	 * @param lineadeventa
	 * @return
	 */
	public boolean exists( Lineadeventa lineadeventa ) ;

    //----------------------------------------------------------------------
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;

}