package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdministratorDAO {
Conexion objConexion = new Conexion();

    public void insertAdministrator(AdministratorVO administrator) {
        try {
            Connection acceso = objConexion.obtenerConexion();
            String sql = "INSERT INTO administrator (user, password) VALUES(?,?)";
            PreparedStatement pa = acceso.prepareStatement(sql);
            pa.setString(1, administrator.getUser());
            pa.setString(2, administrator.getPassword());
            
            pa.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    

    public ArrayList<AdministratorVO> showAdministrators() {
        ArrayList<AdministratorVO> arr = new ArrayList<AdministratorVO>();
        AdministratorVO adm;
        try {
            Connection acceso = objConexion.obtenerConexion();
            PreparedStatement pa = acceso.prepareStatement("SELECT * from administrator");
            ResultSet rs = pa.executeQuery();
            while (rs.next()) {
                adm = new AdministratorVO();
                adm.setUser(rs.getString(1));
                adm.setPassword(rs.getString(2));
                arr.add(adm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public void deleteAdministrator(AdministratorVO adm)
    {
        Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.obtenerConexion().createStatement();
			estatuto.executeUpdate("DELETE FROM administrator WHERE user='"+adm.getUser()+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","InformaciÛn",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
                }
    }
    public void modifyAdministrator(AdministratorVO adm) {
		
		Conexion conex= new Conexion();
		try{
                        String consulta="UPDATE administrator SET user= ? , password= ? WHERE user= ? ";
			PreparedStatement estatuto = conex.obtenerConexion().prepareStatement(consulta);
			
            estatuto.setString(1, adm.getUser());
            estatuto.setString(2, adm.getPassword());
            estatuto.executeUpdate();

          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","ConfirmaciÛn",JOptionPane.INFORMATION_MESSAGE);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}
          
    public AdministratorVO searchAdministrator(String codigo)
    {
        
        String consulta="SELECT * FROM administrator WHERE user = '"+codigo+"'";
        AdministratorVO objVO = new AdministratorVO("","");
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

   
