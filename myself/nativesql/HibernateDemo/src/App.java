

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import pack.Emp;


public class App {
    public static void main(String[] args) {

        SessionFactory fac=NewHibernateUtil.getSessionFactory();
        Session ses=fac.openSession();

        Transaction tr=ses.beginTransaction();

        Emp em=new Emp();
//        em.setId(101);
//        em.setName("rahul");
//
//
//        ses.save(em);
//        tr.commit();
//        System.out.println("record added");

//        SQLQuery query = session.createSQLQuery(sql);
//		query.addEntity("supplier", Supplier.class);

        SQLQuery qr=ses.createSQLQuery("select {em.*} from emp em").addEntity("em",Emp.class);
        List list=qr.list();

        for(Object e:list){
            Emp e1=(Emp)e;
            System.out.println(e1.getId()+"  "+e1.getName());
            
        }

    }
}
