package com.ydpay.business.serviceimpl.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresqlTest {
	public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        try{  
            Class.forName("org.postgresql.Driver").newInstance();  
            String connectUrl ="jdbc:postgresql://localhost:5432/postgres";  
            Connection conn = DriverManager.getConnection(connectUrl, "postgres", "postgres");  
            Statement st = conn.createStatement();  
            String sql = " SELECT 1;";  
            ResultSet rs = st.executeQuery(sql);  
            while(rs.next()){  
                System.out.println(rs.getInt(1));  
            }  
            rs.close();  
            st.close();  
            conn.close();  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
  
    }  
}

