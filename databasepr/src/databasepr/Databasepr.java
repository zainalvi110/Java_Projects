package Databasepr;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Databasepr {

  Connection con;
  Statement st;
  ResultSet rs;
  
  Databasepr(){

     //connectivity
     try{
     Class.forName("com.mysql.cj.jdbc.Driver");
     
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","");
     st=con.createStatement();
     System.out.println("DB is connected");
     
     }catch(ClassNotFoundException | SQLException e){
     
     System.out.println(e);
     }
     
     
   }

   
   public ResultSet matchLogin(String id, String pass){
     
          
       String sql="SELECT * FROM `userdata`  where student_id='"+id+"' and student_password='"+pass+"'";
       //System.out.println(sql);
      try {
          rs=st.executeQuery(sql);
          
      } catch (SQLException ex) {
          Logger.getLogger(Databasepr.class.getName()).log(Level.SEVERE, null, ex);
      }
      
          
   return rs;
   }
   

   public static void main(String []args){
   
   Databasepr db=new Databasepr();
   
   }    
}
