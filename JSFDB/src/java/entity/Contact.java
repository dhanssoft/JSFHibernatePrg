package entity;
// Generated 19 May, 2020 11:34:32 PM by Hibernate Tools 4.3.1



/**
 * Contact generated by hbm2java
 */
public class Contact  implements java.io.Serializable {
     private String aid;
     private String pname;
     private Long phone;

    public Contact() {
    }

	
    public Contact(String aid) {
        this.aid = aid;
    }
    public Contact(String aid, String pname, Long phone) {
       this.aid = aid;
       this.pname = pname;
       this.phone = phone;
    }
   
    public String getAid() {
        return this.aid;
    }
    
    public void setAid(String aid) {
        this.aid = aid;
    }
    public String getPname() {
        return this.pname;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }
    public Long getPhone() {
        return this.phone;
    }
    
    public void setPhone(Long phone) {
        this.phone = phone;
    }




}


