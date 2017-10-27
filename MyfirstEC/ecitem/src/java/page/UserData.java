/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class UserData implements Serializable{
    private int userID=0;
    private String password="";
    private String name="";
    private String mail="";
    private String address="";
    private Date newDate=null;
    private int total = 0;
    
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID=userID;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail=mail;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public Date getNewDate(){
        
        return newDate;
    }
    public void setNewDate(Timestamp ts){
        this.newDate=ts;
    }
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total=total;
    }
    UserDataDTO Changeudd(){
        UserDataDTO udd = new UserDataDTO();
        udd.setName(name);
        udd.setPassword(password);
        udd.setMail(mail);
        udd.setAddress(address);
       
        return udd;
    }
    UserData Changeud(UserDataDTO udd){
       UserData ud =new UserData();
       ud.setUserID(udd.getUserID());
       ud.setName(udd.getName());
       ud.setPassword(udd.getPassword());
       ud.setMail(udd.getMail());
       ud.setAddress(udd.getAddress());
       ud.setTotal(udd.getTotal());
       ud.setNewDate(udd.getNewDate());
       return ud;
        
    }
}
