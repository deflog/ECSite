/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;
 
import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;

public class jums{
        /**
     * Yahoo!ディベロッパーのAPP ID
     */
    private static String APPID = "app ID";

    /**
     * Yahoo!ショッピングAPIのベースURI
     */
    private static String BASE = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
    
    private static String BASE_CODE="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup";
    public static jums getInstance(){
        return new jums();
    }
    
    public String createUrl(String key) throws UnsupportedEncodingException{
        String url = "";
        String st = URLEncoder.encode(key, "UTF-8");
        url =BASE +"?appid="+APPID+"&query=" +st;
        return url;
    
    }
    public String createCode(String key){
    String url = "";
     
        url =BASE_CODE +"?appid="+APPID+"&itemcode="+key;
        return url;
    }
    public static String topLink(){
        return "<a href=\"Search\">TOP</a>";
    }
    public String Typest(int num){
        String type = "";
        switch(num){
            case 1:
                type="クロネコ";
                break;
            case 2:
                type="カンガルー";
                break;
            case 3:
                type="ネズミ";
                break;
        }
        return type;
    }
    
    
}