/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;


import java.io.Serializable;
import java.sql.Timestamp;


/**
 *
 * @author geust1Day
 */
public class Syouhindatabeans implements Serializable{
    private String name;
    private String url;
    private String image;
    private int price;
    private String code;
    private String headline;
    private Timestamp buyDate;
    private int type;
    public Syouhindatabeans(){}
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
     public String getUrl(){
        return url;
    }
    
    public void setUrl(String url){
        this.url=url;
    }
     public String getImage(){
        return image;
    }
    
    public void setImage(String image){
        this.image=image;
    }
     public int getPrice(){
        return price;
    }
    
    public void setPrice(String price){
        this.price=Integer.parseInt(price);
    }
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code=code;
    }
    public String getHeadline(){
        return headline;
    }
    public void setHeadline(String headline){
        this.headline=headline;
    }
    public Timestamp getBuyDate(){
        return buyDate;
    }
    public void setBuyDate(Timestamp buyDate){
        this.buyDate=buyDate;
    }
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type=type;
    }
}