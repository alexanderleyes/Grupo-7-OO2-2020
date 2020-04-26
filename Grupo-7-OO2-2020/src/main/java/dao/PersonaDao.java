package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;


public class PersonaDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso datos Persona", he);
	}
	
	public int agregar(Persona objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}		
		return id;
	}
	
	public void actualizar(Persona objeto) throws HibernateException{
		try {
			iniciaOperacion();
			session.saveOrUpdate(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Persona objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public Persona traer(long idPersona) throws HibernateException{
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, idPersona);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	public Persona traer(int dni) throws HibernateException{
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona p where p.dni="+dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> traer() throws HibernateException {
		List<Persona> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("From Persona p order by p.apellido asc, p.nombre asc").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
}
