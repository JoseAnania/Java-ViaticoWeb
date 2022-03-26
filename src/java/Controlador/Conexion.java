
package Controlador;

import Dto.EmpleadoDto;
import Modelo.Empleado;
import Modelo.Viatico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
    
    private Connection C;
    private PreparedStatement PS;
    private Statement S;
    private  ResultSet RS;
    
    public void abrirConexion()
    {
        try {
            String url="jdbc:sqlserver://DESKTOP-E8FRIUV\\SQLEXPRESS:1433;databaseName=Viatico";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            C=DriverManager.getConnection(url, "sa", "giandjoe");
            System.out.println("Conectado a la BD");
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la BD");
        }
    }
    public void cerrarConexion()
    {
        try {
            C.close();
            System.out.println("Desconectado de la BD");
        } catch (Exception e) {
            System.out.println("No se pudo desconectar de la BD");
        }
    }
    public void agregarViatico(Viatico nuevoViatico)
    {
        try {
            abrirConexion();
            PS=C.prepareStatement("INSERT INTO Viatico (legajo, concepto, importe) VALUES (?,?,?)");
            
            PS.setInt(1, nuevoViatico.getLegajo());
            PS.setString(2, nuevoViatico.getConcepto());
            PS.setFloat(3, nuevoViatico.getImporte());
            
            PS.execute();
            PS.close();
            cerrarConexion();
        } catch (Exception e) {
        }
    }
    public ArrayList<Empleado>comboE()
    {
        ArrayList<Empleado>lista=new ArrayList<>();
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT * FROM Empleado");
            
            while(RS.next())
            {
                Empleado E=new Empleado();
                
                E.setLegajo(RS.getInt(1));
                E.setNombre(RS.getString(2));
                
                lista.add(E);
            }
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return lista;
    }
    public ArrayList<EmpleadoDto>listado()
    {
        ArrayList<EmpleadoDto>lista=new ArrayList<>();
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT e.nombre, v.concepto, v.importe FROM Empleado e INNER JOIN Viatico v ON e.legajo=v.legajo ORDER BY e.nombre, v.importe DESC ");
            
            while(RS.next())
            {
                EmpleadoDto E=new EmpleadoDto();
                
                E.setNombre(RS.getString(1));
                E.setConcepto(RS.getString(2));
                E.setImporte(RS.getFloat(3));
                
                lista.add(E);
            }
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return lista;
    }
    public ArrayList<EmpleadoDto>totalPorEmpleado()
    {
        ArrayList<EmpleadoDto>lista=new ArrayList<>();
        try {
            abrirConexion();
            S=C.createStatement();
            RS=S.executeQuery("SELECT e.nombre , SUM(v.importe) FROM Empleado e, Viatico v WHERE e.legajo=v.legajo GROUP BY e.nombre");
            
            while(RS.next())
            {
                EmpleadoDto E=new EmpleadoDto();
                
                E.setNombre(RS.getString(1));
                E.setImporte(RS.getFloat(2));
                
                lista.add(E);
            }
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return lista;
    }
}
