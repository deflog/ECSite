/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import jums.DatabaseManager;

class UserDataDAO{
    //データベース接続してログインチェックします
    UserDataDTO checkLogin(UserData ud) throws SQLException{
        Connection con =null;
        PreparedStatement st = null;
        UserDataDTO udd = new UserDataDTO();
        try{
            con = DatabaseManager.getConnection();
            
            String sql = "SELECT * from user_t WHERE name = ?";
            
            st = con.prepareStatement(sql);
            
            st.setString(1,ud.getName());
            
            ResultSet rs = st.executeQuery();
            if(rs!=null){
            rs.next();
            String pass = rs.getString("password");
            String id = rs.getString("name");
            int del = rs.getInt("deleteFlg");
            if(del==1){
                udd.setName("");
                udd.setPassword("");
                return udd;
            }
            udd.setName(id);
            udd.setPassword(pass);
            }
            
        }catch(SQLException e){
        System.out.print(e.getMessage());
        throw new SQLException(e);
        }finally{
            if(con!=null){
            con.close();
            }
        }
        return udd;
    }
    void Insert(UserDataDTO udd) throws SQLException{
        Connection con=null;
        PreparedStatement st=null;
        try{
        con = DatabaseManager.getConnection();
        String sql = "INSERT into user_t(name,password,mail,address,total,newDate) values(?,?,?,?,?,?)";
        st=con.prepareStatement(sql);
        st.setString(1, udd.getName());
        st.setString(2, udd.getPassword());
        st.setString(3, udd.getMail());
        st.setString(4, udd.getAddress());
        st.setInt(5, 0);
        st.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
        /* int num = */st.executeUpdate();
        
        }catch(SQLException e){
        System.out.print(e.getMessage());
        }finally{
        if(con!=null){
            con.close();
        }
        }
    
    }
    UserDataDTO SearchID(String name) throws SQLException{
        Connection con =null;
        PreparedStatement st=null;
         UserDataDTO udd = new UserDataDTO();
        try{
        con = DatabaseManager.getConnection();
        String sql = "SELECT * from user_t WHERE name = ?";
        st = con.prepareStatement(sql);
        st.setString(1,name);
        ResultSet rs = st.executeQuery();
       
        rs.next();
        udd.setUserID(rs.getInt("userID"));
        udd.setName(rs.getString("name"));
        udd.setPassword(rs.getString("password"));
        udd.setMail(rs.getString("mail"));
        udd.setAddress(rs.getString("address"));
        udd.setTotal(rs.getInt("total"));
        udd.setNewDate(rs.getTimestamp("newDate"));
       
        }catch(SQLException e){
        System.out.print(e.getMessage());
        }finally{
        if(con!=null){
        con.close();
        }
        }
       return udd;
    }
    //商品購入
    void Buyitem(String user,String type,int num,ArrayList<Syouhindatabeans> shd) throws SQLException{
        Connection con = null;
        PreparedStatement st=null;
        try{
        con = DatabaseManager.getConnection();
        String sql = "SELECT * from user_t WHERE name = ?";
        st = con.prepareStatement(sql);
        st.setString(1,user);
        ResultSet rs = st.executeQuery();
        rs.next();
        int userID = rs.getInt("userID");
        int total = rs.getInt("total");
        num=num+total;
        rs.close();
        
        sql = "UPDATE user_t SET total = ? WHERE userID = ?";
        st = con.prepareStatement(sql);
        st.setInt(1,num);
        st.setInt(2,userID);
        st.executeUpdate();
        for(int i = 0;i<shd.size();i++){
        sql = "INSERT into buy_t(userID,itemCode,type,buyDate)values(?,?,?,?)";
        st = con.prepareStatement(sql);
        st.setInt(1,userID);
        st.setString(2,shd.get(i).getCode());
        st.setInt(3,Integer.parseInt(type));
        st.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
        st.executeUpdate();
        }
        
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }finally{
        if(con!=null){
            con.close();
        }
        }
    }
    UserData UpdateID(UserData ud) throws SQLException{
     Connection con=null;
        PreparedStatement st=null;
        try{
        con = DatabaseManager.getConnection();
        String sql = "UPDATE user_t SET name=?,password=?,mail=?,address=?,newDate=? WHERE userID = ?";
        st=con.prepareStatement(sql);
        st.setString(1, ud.getName());
        st.setString(2, ud.getPassword());
        st.setString(3, ud.getMail());
        st.setString(4, ud.getAddress());
        Timestamp tm =new Timestamp(System.currentTimeMillis());
        st.setTimestamp(5,tm);
        st.setInt(6,ud.getUserID());
        st.executeUpdate();
        ud.setNewDate(tm);
        }catch(SQLException e){
        System.out.print(e.getMessage());
        }finally{
        if(con!=null){
            con.close();
        }
        }
        return ud;
    }
  void UserDelete(int userID) throws SQLException{
      Connection con = null;
      PreparedStatement st =null;
      
     con = DatabaseManager.getConnection();
     String sql = "UPDATE user_t SET deleteFlg = 1 WHERE userID = ?";
     try{
     st=con.prepareStatement(sql);
     st.setInt(1, userID);
     st.executeUpdate();
     
     }catch(SQLException e){
         System.out.print(e.getMessage());
     }finally{
         if(con!=null){
         con.close();
         }
     }
  }
  ArrayList<UserDataDTO> BuyHistory(String user) throws SQLException{
      Connection con = null;
      PreparedStatement st = null;
      ArrayList<UserDataDTO> result = new ArrayList();
      con = DatabaseManager.getConnection();
      String sql = "SELECT * from user_t WHERE name = ?";
      try{
      st = con.prepareStatement(sql);
      st.setString(1,user);
      ResultSet rs = st.executeQuery();
      rs.next();
      int userID = rs.getInt("userID");
      rs.close();
      
      sql = "SELECT * from buy_t WHERE userID = ?";
      st = con.prepareStatement(sql);
      st.setInt(1,userID);
      
      rs = st.executeQuery();
      
      while(rs.next()){
      UserDataDTO dto = new UserDataDTO();
      String itemcode = rs.getString("itemCode");
      int type = rs.getInt("type");
      Timestamp buydate = rs.getTimestamp("buyDate");
      dto.setItemCode(itemcode);
      dto.setType(type);
      dto.setBuyDate(buydate);
      result.add(dto);
      }
      
      }catch(SQLException e){
          System.out.print(e.getMessage());
      }finally{
          if(con!=null){
          con.close();
          }
      }
  return result;
  }
}