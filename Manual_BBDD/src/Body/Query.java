
package Body;

import GUI.*;
import java.sql.*; // Importamos los requerimientos


public class Query {
    
    static final String URL = "jdbc:mysql://localhost:3306/productos";
    static final String USER = "root";
    static final String PASS = "";  
    
    static String QUERY;
    static String RESULTADO = "";
    
    public static void Conexion_BBDD(){
        
        
    
    }
    
    public static String QUERY(String alimento, String tipo, String id, String calorias, String tipo_query){
        
        try{  
            
            // Driver especifico para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");  
            
            // Iniciar conexion con BBDD
            Connection connection = DriverManager.getConnection(URL,USER,PASS);  
            
            // Statement permite mandar consultas SQL a la BBDD
            Statement statement = connection.createStatement();  
            
            
            switch (tipo_query) {
                case "SELECT":
                    QUERY = "SELECT * FROM ALIMENTOS WHERE Alimento LIKE '"+alimento
                            +"' AND Tipo LIKE '"+tipo
                            +"' AND Id LIKE '"+id
                            +"' AND Calorias LIKE '"+calorias
                            +"'";   
                    // ResultSet nos permite recoger el resultado de nuestra consulta
                    ResultSet resultSet = statement.executeQuery(QUERY);
                    
                    // Mientras haya resultados
                    while (resultSet.next()) {

                        RESULTADO = (resultSet.getString(1)+" "
                                +resultSet.getString(2)+" "
                                +resultSet.getString(3)+" "
                                +resultSet.getString(4))+"\n"
                                +RESULTADO;

                    }
                    break;
                    
                case "INSERT":
                    QUERY = "INSERT INTO `ALIMENTOS`(`Alimento`, `Tipo`, `id`, `Calorias`) VALUES ('"+alimento
                            +"','"+tipo
                            +"','"+id
                            +"','"+calorias
                            +"')";                        
                    
                    statement.executeUpdate(QUERY);
                    
                    RESULTADO = "Entrada creada con exito.";
                    
                    break;
                    
                case "DELETE":
                    // Usamos '=' frente a 'LIKE' porque sí distingue mayus a la hora de comparar.
                    QUERY = "DELETE FROM `ALIMENTOS` WHERE Alimento = '"+alimento
                            +"' AND Tipo = '"+tipo
                            +"' AND id = '"+id
                            +"' AND calorias = '"+calorias
                            +"' LIMIT 1";  // Solo borra 1             
                    
                    statement.executeUpdate(QUERY);
                    RESULTADO = "Borrado 1 entrada con exito.";
                    
                    break;                    
             }
            
            // Cerramos conexión
            connection.close();   
            
        }catch(Exception e){ 
            System.out.println(e);
        }
        
        return RESULTADO;
        
    } 
    
    public static String UPDATE_QUERY(String alimento, String tipo, String id, String calorias, 
            String new_alimento, String new_tipo, String new_id, String new_calorias){
        
        QUERY = "UPDATE `ALIMENTOS` SET "
                + "alimento = '"+new_alimento
                +"',tipo = '"+new_tipo
                +"',id = '"+new_id
                +"',calorias = '"+new_calorias
                +"' WHERE alimento LIKE '"+alimento
                +"' AND tipo LIKE '"+tipo
                +"' AND id LIKE '"+id
                +"' AND calorias LIKE '"+calorias
                +"'";
        
        try{  
            // Driver especifico para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");  
            
            // Iniciar conexion con BBDD
            Connection connection = DriverManager.getConnection(URL,USER,PASS);  
            
            // Statement permite mandar consultas SQL a la BBDD
            Statement statement = connection.createStatement();  
            
            // ExecuteUpdate permite ejecutar la consulta en la BBDD
            statement.executeUpdate(QUERY);
            
            // Cerramos conexión
            connection.close();
            
            RESULTADO = alimento+" "+tipo+" "+id+" "+calorias+" cambiado a "+new_alimento+" "+new_tipo+" "+new_id+" "+new_calorias+"'";
        
        }catch(Exception e){ 
            System.out.println(e);
        }
        return RESULTADO;
    } 
    
       
}
    

