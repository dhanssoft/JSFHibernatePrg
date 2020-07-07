/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;


import entity.Contact;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ContactDAO;

/**
 *
 * @author Dr. Bala
 */
@ManagedBean (name="c", eager=true)
@SessionScoped
public class ContactControler {
    
public List<Contact> list=new ArrayList<Contact>();
Contact c=new Contact();

    public List<Contact> getList() {
        ContactDAO cd=new ContactDAO();
        return cd.findAll();
    }

    public void setList(List<Contact> list) {
        this.list = list;
    }

    public Contact getC() {
        return c;
    }

    public void setC(Contact c) {
        this.c = c;
    }

    /**
     * Creates a new instance of ContactControler
     */
    public ContactControler() {
    }
//-----------------------
public String edit(Contact c){
        this.c=c;
        return "updatecontacts";
    }
    public String update(){
        ContactDAO cd=new ContactDAO();
        cd.update(c);
        return "index";
    }
//--------create    
    public void create(){
        ContactDAO cd=new ContactDAO();
        cd.create(c);
    }
 //--------delete
    public void delete(Contact c){
        ContactDAO cd=new ContactDAO();
        cd.delete(c);
    }
}
