package com.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp {

	public static void main(String[] args)
	{
	    Configuration conn=new Configuration().configure().addAnnotatedClass(EmployeeHql.class);
	    ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conn.getProperties()).buildServiceRegistry();
	    SessionFactory sf=conn.buildSessionFactory(reg);
	    Session sess=sf.openSession();
	    Transaction tx=sess.beginTransaction();
	   /** EmployeeHql e1=new EmployeeHql(1, "devi", 5639.00, "sivan street",101);
	    sess.save(e1);
	    EmployeeHql e2=new EmployeeHql(2, "divi", 85639.00, " dpk street",102);
	    sess.save(e2);
	    EmployeeHql e3=new EmployeeHql(3, "thara", 98689.00, "new street",103);
	    sess.save(e3);
	    EmployeeHql e4=new EmployeeHql(4, "abi", 45632.22, "mgr street",104);
	    sess.save(e4);
	    EmployeeHql e5=new EmployeeHql(5, "maha", 55639.00, "sivan street",105);
	    sess.save(e5);
	    **/
	    
       /** EmployeeHql e=(EmployeeHql) sess.get(EmployeeHql.class,2);
        System.out.println(e);
        System.out.println();
        System.out.println("eid:"+e.getEid()+ "ename:"+e.getEname()+ "esalary:"+e.getSalary()+ "address:" +e.getAddress()+"edepno"+e.getDeptno());
        **/
	    //select all record
	   /** Query q=sess.createQuery("from EmployeeHql");
	    List l=q.list();
	    System.out.println(l);
	    Iterator<EmployeeHql> it=l.iterator();
	    while(it.hasNext())
	    {
	    	EmployeeHql e=it.next();
	    	  System.out.println("eid:" +e.getEid()+ "ename:" +e.getEname()+ "esalary:" +e.getSalary()+ "address:" +e.getAddress()+ "edepno:" +e.getDeptno());
	    }
	    **/
	    //update the record in name
	    /**Query q=sess.createQuery("update EmployeeHql set ename=:n where eid=:i" );
	    q.setParameter("n","keshsva" );
	    q.setParameter("i", 1);
	    int i=q.executeUpdate();
	    if(i>0)
	    {
	    	System.out.println("Record update sucessfully");
	    }
	    else
	    {
	    	System.out.println("not update");
	    }
	    **/
	    //update the record in salary
	    /**Query q=sess.createQuery("update EmployeeHql set salary=:s where eid=:i" );
	    q.setParameter("s",10000.00);
	    q.setParameter("i", 2);
	    int i=q.executeUpdate();
	    if(i>0)
	    {
	    	System.out.println("Record update sucessfully");
	    }
	    else
	    {
	    	System.out.println("not update");
	    }
	    **/
	    //delete a particular data
	    /**Query q=sess.createQuery("delete from EmployeeHql where eid=:i" );
	    q.setParameter("i", 3);
	    int i=q.executeUpdate();
	    if(i>0)
	    {
	    	System.out.println("record deleted");
	    }
	    else
	    {
	    	System.out.println("not deleted");
	    }
	    **/
	    //Aggregative function
	    Query q=sess.createQuery("select sum(salary) from EmployeeHql");
	    List s=q.list();
	    System.out.println("Total is: "+s.get(0));
	    Query a=sess.createQuery("select max(salary) from EmployeeHql");
	    List l=a.list();
	    System.out.println("Maximum is: "+l.get(0));
	    Query b=sess.createQuery("select min(salary) from EmployeeHql");
	    List s1=b.list();
	    System.out.println("Minmum is: "+s1.get(0));
	    Query c=sess.createQuery("select avg(salary) from EmployeeHql");
	    List s2=c.list();
	    System.out.println("Average is: "+s2.get(0));
	    Query q1=sess.createQuery("select count(salary) from EmployeeHql");
	    List s3=q1.list();
	    System.out.println("Total number of employee is: "+s3.get(0));
        tx.commit();
	    sess.close();
	}

}
