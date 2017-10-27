/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;


import java.util.ArrayList;
import java.util.Map;
import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;
/**jsonTextもらってshd配列で返します
 検索結果一覧ページに使ってね
 **/
public class setSyouhin{
    public ArrayList<Syouhindatabeans> setSyouhin(String jsonText){
        Map<String,Map<String,Object>> json = JSON.decode(jsonText);
        int count = Integer.parseInt(json.get("ResultSet").get("totalResultsReturned").toString());
        ArrayList<Syouhindatabeans> shb = new ArrayList();
        try{
        if( !Integer.valueOf(json.get("ResultSet").get("totalResultsReturned").toString()).equals(0) ){
            Map<String,Object> result;
            for(int i=0;i<count;i++){
            result = ((Map<String,Object>)((Map<String,Map<String,Object>>)json.get("ResultSet").get("0")).get("Result").get(String.valueOf(i)));
            
            String name = result.get("Name").toString();
            String imageUrl =((Map<String,Object>)result.get("Image")).get("Medium").toString();
            String sinaurl = result.get("Url").toString();
            String price = ((Map<String,Object>)result.get("Price")).get("_value").toString();
            String code = result.get("Code").toString();
            String headline= result.get("Headline").toString();
            //格納
            Syouhindatabeans shd =new Syouhindatabeans();
            shd.setName(name);
            shd.setImage(imageUrl);
            shd.setUrl(sinaurl);
            shd.setPrice(price);
            shd.setCode(code);
            shd.setHeadline(headline);
            shb.add(shd);
            
            }
            System.out.print("完了しました");
        }
        }catch(JSONException e){
            System.out.print(e);
        }
    return shb;
    
    }
    public Syouhindatabeans codeSyouhin(String jsonText){
        Map<String,Map<String,Object>> json = JSON.decode(jsonText);
       
        Syouhindatabeans shd =new Syouhindatabeans();
        try{
        if( !Integer.valueOf(json.get("ResultSet").get("totalResultsReturned").toString()).equals(0) ){
            Map<String,Object> result;
            
            result = ((Map<String,Object>)((Map<String,Map<String,Object>>)json.get("ResultSet").get("0")).get("Result").get("0"));
            
            String name = result.get("Name").toString();
            String imageUrl =((Map<String,Object>)result.get("Image")).get("Small").toString();
            String sinaurl = result.get("Url").toString();
            String price = ((Map<String,Object>)result.get("Price")).get("_value").toString();
            String headline= result.get("Headline").toString();
            
            result =  ((Map<String,Object>)((Map<String,Map<String,Object>>)json.get("ResultSet").get("0")).get("Result").get("ItemCode"));
            
            String code = ((Map<String,Object>)result.get("0")).get("Code").toString();
            //格納
            
            shd.setName(name);
            shd.setImage(imageUrl);
            shd.setUrl(sinaurl);
            shd.setPrice(price);
            shd.setCode(code);
            shd.setHeadline(headline);
          
            
            System.out.print("完了しました");
        }
        }catch(JSONException e){
            System.out.print(e);
        }
    return shd;
    
    }
}