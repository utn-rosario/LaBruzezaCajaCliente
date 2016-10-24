/*
 * Created on 21 oct 2016 ( Time 11:36:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.labruzeza.colectividades.dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.labruzeza.colectividades.dao.ProductoDAO;
import org.labruzeza.colectividades.dao.impl.jdbc.commons.GenericDAO;
import org.labruzeza.colectividades.modelo.Producto;

/**
 * Producto DAO implementation 
 * 
 * @author Telosys Tools
 *
 */
public class ProductoDAOImpl extends GenericDAO<Producto> implements ProductoDAO {

	private final static String SQL_SELECT = 
		"select idproducto, nombre, precio from producto where idproducto = ?";
	
	private final static String SQL_SELECT_AlL = 
			"select idproducto, nombre, precio from producto";

	private final static String SQL_INSERT = 
		"insert into producto ( nombre, precio ) values ( ?, ? )";

	private final static String SQL_UPDATE = 
		"update producto set nombre = ?, precio = ? where idproducto = ?";

	private final static String SQL_DELETE = 
		"delete from producto where idproducto = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from producto";
	
	private final static String SQL_LOAD_ALL = 
			"select count(*) from producto";

	private final static String SQL_COUNT = 
		"select count(*) from producto where idproducto = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public ProductoDAOImpl() {
		super();
	}

	//----------------------------------------------------------------------
	/**
	 * Creates a new instance of the bean and populates it with the given primary value(s)
	 * @param idproducto;
	 * @return the new instance
	 */
	private Producto newInstanceWithPrimaryKey( Integer idproducto ) {
		Producto producto = new Producto();
		producto.setIdproducto( idproducto );
		return producto ;
	}

	//----------------------------------------------------------------------
	/**
	 * Finds a bean by its primary key 
	 * @param idproducto;
	 * @return the bean found or null if not found 
	 */
	@Override
	public Producto find( Integer idproducto ) {
		Producto producto = newInstanceWithPrimaryKey( idproducto ) ;
		if ( super.doSelect(producto) ) {
			return producto ;
		}
		else {
			return null ; // Not found
		}
	}
	//----------------------------------------------------------------------
	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s) in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from the database<br>
	 * If not found, the given instance remains unchanged
	 * @param producto
	 * @return true if found, false if not found
	 */
	@Override
	public boolean load( Producto producto ) {
		return super.doSelect(producto) ;
	}
	
	@Override
	public List<Producto> loadAll() {		
		return super.doLoadAll();
	}
    //----------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database 
	 * @param producto
	 */
	@Override
	public Integer insert(Producto producto) {
		Long key = super.doInsertAutoIncr(producto);
		return key.intValue();
	}

    //----------------------------------------------------------------------
	/**
	 * Updates the given bean in the database 
	 * @param producto
	 * @return
	 */
	@Override
	public int update(Producto producto) {
		return super.doUpdate(producto);
	}	

    //----------------------------------------------------------------------
	/**
	 * Deletes the record in the database using the given primary key value(s) 
	 * @param idproducto;
	 * @return
	 */
	@Override
	public int delete( Integer idproducto ) {
		Producto producto = newInstanceWithPrimaryKey( idproducto ) ;
		return super.doDelete(producto);
	}

    //----------------------------------------------------------------------
	/**
	 * Deletes the given bean in the database 
	 * @param producto
	 * @return
	 */
	@Override
	public int delete( Producto producto ) {
		return super.doDelete(producto);
	}

    //----------------------------------------------------------------------
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param idproducto;
	 * @return
	 */
	@Override
	public boolean exists( Integer idproducto ) {
		Producto producto = newInstanceWithPrimaryKey( idproducto ) ;
		return super.doExists(producto);
	}
    //----------------------------------------------------------------------
	/**
	 * Checks the existence of the given bean in the database 
	 * @param producto
	 * @return
	 */
	@Override
	public boolean exists( Producto producto ) {
		return super.doExists(producto);
	}

    //----------------------------------------------------------------------
	/**
	 * Counts all the records present in the database
	 * @return
	 */
	@Override
	public long count() {
		return super.doCountAll();
	}

    //----------------------------------------------------------------------
	@Override
	protected String getSqlSelect() {
		return SQL_SELECT ;
	}
	
	@Override
	protected String getSqlSelectAll() {
		return SQL_SELECT_AlL ;
	}
	
	
    //----------------------------------------------------------------------
	@Override
	protected String getSqlInsert() {
		return SQL_INSERT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlUpdate() {
		return SQL_UPDATE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlDelete() {
		return SQL_DELETE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCount() {
		return SQL_COUNT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCountAll() {
		return SQL_COUNT_ALL ;
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForPrimaryKey(PreparedStatement ps, int i, Producto producto) throws SQLException {
		//--- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, producto.getIdproducto() ) ; // "idproducto" : java.lang.Integer
	}

    //----------------------------------------------------------------------
	@Override
	protected Producto populateBean(ResultSet rs, Producto producto) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		producto.setIdproducto(rs.getInt("idproducto")); // java.lang.Integer
		if ( rs.wasNull() ) { producto.setIdproducto(null); }; // not primitive number => keep null value if any
		producto.setNombre(rs.getString("nombre")); // java.lang.String
		producto.setPrecio(rs.getBigDecimal("precio")); // java.math.BigDecimal
		if ( rs.wasNull() ) { producto.setPrecio(null); }; // not primitive number => keep null value if any
		return producto ;
	}
	
	//----------------------------------------------------------------------
	@Override
	protected Producto populateBeanAll(ResultSet rs) throws SQLException {
		Producto producto = new Producto();
		//--- Set data from ResultSet to Bean attributes
		producto.setIdproducto(rs.getInt("idproducto")); // java.lang.Integer
		if ( rs.wasNull() ) { producto.setIdproducto(null); }; // not primitive number => keep null value if any
		producto.setNombre(rs.getString("nombre")); // java.lang.String
		producto.setPrecio(rs.getBigDecimal("precio")); // java.math.BigDecimal
		if ( rs.wasNull() ) { producto.setPrecio(null); }; // not primitive number => keep null value if any
		return producto ;
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForInsert(PreparedStatement ps, int i, Producto producto) throws SQLException {

		//--- Set PRIMARY KEY and DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
		// "idproducto" is auto-incremented => no set in insert		
		setValue(ps, i++, producto.getNombre() ) ; // "nombre" : java.lang.String
		setValue(ps, i++, producto.getPrecio() ) ; // "precio" : java.math.BigDecimal
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForUpdate(PreparedStatement ps, int i, Producto producto) throws SQLException {

		//--- Set DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
		setValue(ps, i++, producto.getNombre() ) ; // "nombre" : java.lang.String
		setValue(ps, i++, producto.getPrecio() ) ; // "precio" : java.math.BigDecimal
		//--- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, producto.getIdproducto() ) ; // "idproducto" : java.lang.Integer
	}

	

	@Override
	protected String getSqlLoadAll() {
		return SQL_LOAD_ALL;
	}

}
