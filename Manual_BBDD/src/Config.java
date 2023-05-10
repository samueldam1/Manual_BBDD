
import java.sql.*; // Importamos los requerimientos


public class Config {
    
    static final String DB_URL = "localhost";
    static final String USER = "guest";
    static final String PASS = "";
    
    
    public static void Crear_Database() {
    
        System.out.println("Creando base de datos...");
        
        // Establecer conexion
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ){		      
            String sql = "CREATE DATABASE FRUTAS"; // QUERY
            stmt.executeUpdate(sql); // Metodo que ejecuta la query
            System.out.println("Base de datos creada con exito!"); 
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public static void Select_Database(){        
        
        System.out.println("Estableciendo conexion...");
        
        // Establecer conexion
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {		      
            System.out.println("Conexion establecida con exito!");  
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
      
    }
    
}
