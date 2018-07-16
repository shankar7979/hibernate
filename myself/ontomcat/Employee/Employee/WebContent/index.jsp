<%@page import="java.util.List"%>
<%@page import="pack.Emp"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="pack.NewHibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="pack.Emp" %>
<%
SessionFactory sessionfac=NewHibernateUtil.getSessionFactory();
Session session1=sessionfac.openSession();


Transaction tr=session1.beginTransaction();
Emp emp=new Emp();
List<Emp> list=session1.createQuery("from emp").list();

for(Emp e:list)
    out.print("<br>"+e.getId()+"   "+e.getName());




%>