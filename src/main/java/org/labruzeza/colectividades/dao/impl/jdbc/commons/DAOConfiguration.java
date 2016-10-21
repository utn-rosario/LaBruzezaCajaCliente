/*
 * Created on 21 oct 2016 ( Time 11:36:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.labruzeza.colectividades.dao.impl.jdbc.commons;

/**
 * Configuration class for native JDBC DAO 
 * 
 * @author Telosys Tools
 *
 */
public class DAOConfiguration {

	/**
	 * The properties file containing the JDBC DataSource configuration
	 */
	public final static String JDBC_PROPERTIES_FILE_NAME = "/jdbc.properties" ;
	
	//--- DAO implementation package name (choose one of the two options : full or partial name)
	/**
	 * The full package name to be used ( e.g. "org.demo.dao.impl.jdbc" )
	 */
	public final static String DAO_IMPLEMENTATION_FULL_PACKAGE_NAME = null ; // e.g. "org.demo.dao.impl.jdbc" ;

	/**
	 * The partial package name to be added at the end of the interface package (relative package name)
	 */
	public final static String DAO_IMPLEMENTATION_SUB_PACKAGE_NAME = "impl.jdbc" ; 

	/**
	 * The DAO implementation class name suffix (to be added at the end of the interface class name)
	 */
	public final static String DAO_IMPLEMENTATION_CLASS_SUFFIX = "Impl" ;

}