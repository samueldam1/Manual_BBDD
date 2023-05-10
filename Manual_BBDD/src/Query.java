
import java.sql.*; // Importamos los requerimientos


public class Query {
    
    static final String URL_BBDD = "";
    static final String USER = "guest";
    static final String PASS = "";
    
    static final String QUERY = "QUERY";
    
    
    public static void Consulta(){
    
        // Establecer conexion
        try(Connection conn = DriverManager.getConnection(URL_BBDD, USER, PASS);
            
                Statement stmt = conn.createStatement();
            
                ResultSet rs = stmt.executeQuery(QUERY);) {
            
            while (rs.next()) {
                
                System.out.print("Alimento: " + rs.getString(""));
                System.out.print(", Tipo: " + rs.getString(""));
                System.out.print(", Variedad: " + rs.getString(""));
                System.out.println(", Stock: " + rs.getInt(""));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    
    }
    
    
}
