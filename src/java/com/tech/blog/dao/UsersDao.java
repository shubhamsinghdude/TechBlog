package com.tech.blog.dao;

import com.tech.blog.entities.Users;
import com.tech.blog.helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDao {
    
    private Connection conn;
    
    public static boolean addUsers(Users e) throws SQLException
    {
        try{
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement("insert into users(name,email,password,gender,about,rdate) values (?,?,?,?,?,?)");
            //ps.setInt(1,e.getId());
            ps.setString(1,e.getName());
            ps.setString(2,e.getEmail());
            ps.setString(3,e.getPassword());
            ps.setString(4,e.getGender());
            ps.setString(5,e.getAbout());
            ps.setString(6,e.getDateTime().toString());
        
            int result = ps.executeUpdate();
            if(result == 1)
                return true;
        
            return false; 
        } catch(Exception ex){
            ex.printStackTrace();
        } 
        return false; 
        
    }
    
}
