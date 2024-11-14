
package DAL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil
{
    // classe HibernateUtil, que recebe configurações do hibernate.cfg.xml para ser a ponte de conexão entre NetBeans e SQL Server
    public static String mensagem = "";
    
    private static SessionFactory sessionFactory = null;
    
    static 
    {
        try
        {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (Exception ex)
        {
            mensagem = ex.getMessage();
            ex.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

}
