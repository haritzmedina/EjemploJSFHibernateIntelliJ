package modelo.db;

import modelo.HibernateUtil;
import modelo.dominio.Usuario;
import org.hibernate.Session;

public class AccessDB {

    public Usuario createAndStoreUsuario(String nombre, String password,
                                         String tipo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setPassword(password);
        u.setTipo(tipo);
        session.save(u);
        session.getTransaction().commit();
        return u;
    }
}
