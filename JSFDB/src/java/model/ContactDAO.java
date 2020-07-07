/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Contact;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

/**
 *
 * @author Dr. Bala
 */
public class ContactDAO {
     public List<Contact> findAll(){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        List<Contact> list=new ArrayList<>();
        try{
            s.beginTransaction();
            list=s.createCriteria(Contact.class).list();
            s.getTransaction().commit();
        }catch(Exception e){
            s.getTransaction().rollback();
        }
        return list;
    }
     //--------get person by id
    public Contact getPersonid(String aId){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        Contact ctl=new Contact();
        try{
            s.beginTransaction();
            ctl=(Contact)s.load(Contact.class, aId);
            s.getTransaction().commit();
        }catch(Exception e){
            s.getTransaction().rollback();
        }
        return ctl;
    }
//--create contact
    public void create(Contact c){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.save(c);
            s.getTransaction().commit();
                      // XHTML Response Text
         FacesContext.getCurrentInstance()
                 .getExternalContext()
                 .getSessionMap()
                 .put("add",c.getAid());
        }catch(Exception e){
            s.getTransaction().rollback();
        }
    }
    //----update
    public void update(Contact c){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.update(c);
            s.getTransaction().commit();
        }catch(Exception e){
            s.getTransaction().rollback();
        }
    }
    //---delete
    public void delete(Contact c){
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.delete(c);
            s.getTransaction().commit();
        }catch(Exception e){
            s.getTransaction().rollback();
        }
    }
     
}
