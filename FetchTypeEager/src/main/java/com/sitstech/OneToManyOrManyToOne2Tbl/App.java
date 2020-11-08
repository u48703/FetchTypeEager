package com.sitstech.OneToManyOrManyToOne2Tbl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {	 
    	System.out.println( "Hello World!" );
        System.out.println( "Hello World!" );
        System.out.println( "Hello World3!" );
        Laptop laptop = new Laptop();
        laptop.setlId(101);
        laptop.setlName("dell");
        Laptop laptop2 = new Laptop();
        laptop2.setlId(102);
        laptop2.setlName("Hp");
        List<Laptop> laptops= new ArrayList<Laptop>();
        laptops.add(laptop);
        laptops.add(laptop2);

        System.out.println( "Hello World3" );
        System.out.println( "Hello World3" );

        
        
        Student student =new Student();
        student.setRollNo(1);
        student.setName("jose");
        student.setMarks(80);
        student.setLaptops(laptops);
        laptop2.setStudent(student);
        laptop.setStudent(student);
        
        Configuration con =new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx =session.beginTransaction();
        session.save(laptop);
        session.save(laptop2);
        session.save(student);
//        session.delete(student);
        Student student2 =session.get(Student.class, 1);//if we use fetch type Eager while executing this statement itself laptop 
//        					//details will also fetch using left outer join //note i couldnt fint any left outerjoin qury in the console
        System.out.println("student2 ="+student2);
        
//        Collection<Laptop> laps=student2.getLaptops();// if we are using the fetch type lazy then . the details of the laptop will fetch only 
//        											   //	when we execute this statement
//        System.out.println( "laps = " +laps);

        
        //System.out.println("student2 = "+session.get(Student.class, 1));
        tx.commit(); // session.getTransaction().commit(); this can also used instead of the give statement 
        System.out.println("hi");
        System.out.println("hellow");
       
        
    }
}
