package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientDAO {
    Conexion objConexion = new Conexion();

    public void insertClient(ClientVO cli) {
        try {
            Connection acceso = objConexion.obtenerConexion();
            String sql = "INSERT INTO client (user,password) VALUES(?,?)";
            PreparedStatement pa = acceso.prepareStatement(sql);
            pa.setString(1, cli.getUser());
            pa.setString(2, cli.getPassword());
            
            
            String temp = "CREATE TABLE temp (user VARCHAR(32))";
            PreparedStatement patemp = acceso.prepareStatement(temp);
            String sqltemp = "INSERT INTO temp (user) VALUES(?)";
            PreparedStatement patempUser = acceso.prepareStatement(sqltemp);
            patempUser.setString(1, cli.getUser());
            
            pa.executeUpdate();
            patemp.executeUpdate();
            patempUser.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    

    public ArrayList<ClientVO> showClients() {
        ArrayList<ClientVO> arr = new ArrayList<ClientVO>();
        ClientVO cli;
        try {
            Connection acceso = objConexion.obtenerConexion();
            PreparedStatement pa = acceso.prepareStatement("SELECT * from client");
            ResultSet rs = pa.executeQuery();
            while (rs.next()) {
                cli = new ClientVO();
                cli.setUser(rs.getString(1));
                cli.setPassword(rs.getString(2));
                arr.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public void deleteClient(ClientVO cli)
    {
        Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.obtenerConexion().createStatement();
			estatuto.executeUpdate("DELETE FROM client WHERE user='"+cli.getUser()+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","InformaciÛn",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
                }
    }
    public void modifyClient(ClientVO cli) {
		
		Conexion conex= new Conexion();
		try{
                        String consulta="UPDATE cli SET user= ? , password= ? WHERE user= ? ";
			PreparedStatement estatuto = conex.obtenerConexion().prepareStatement(consulta);
			
            estatuto.setString(1, cli.getUser());
            estatuto.setString(2, cli.getPassword());
            estatuto.executeUpdate();

          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","ConfirmaciÛn",JOptionPane.INFORMATION_MESSAGE);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}
          
    public ClientVO searchClient(String codigo)
    {
        
        String consulta="SELECT * FROM client WHERE user = '"+codigo+"'";
        ClientVO objVO = new ClientVO("","","","",0,"",0,"",0,"");
        try{
            Statement ps = objConexion.obtenerConexion().createStatement();
            ResultSet rs = ps.executeQuery(consulta);

            while(rs.next()){
                objVO.setUser(rs.getString("user"));
                objVO.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return objVO;
    }
}
