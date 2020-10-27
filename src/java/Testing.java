/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arpit mishra
 */
import java.sql.*;
public class Testing {
    public static void main(String[] args) {
        System.out.println("ok"); 
        try{
           Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection established");
        }
        catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
}
