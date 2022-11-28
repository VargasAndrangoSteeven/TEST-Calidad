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

public class AdminDAO {
    
Conexion objConexion = new Conexion();

    public void insertAdmin(AdminVO admin) {
        try {
            Connection acceso = objConexion.obtenerConexion();
            String sql = "INSERT INTO admin (name, lastName, age, gender, location) VALUES(?,?,?,?,?)";
            PreparedStatement pa = acceso.prepareStatement(sql);
            pa.setString(1, admin.getName());
            pa.setString(2, admin.getLastName());
            pa.setInt(3, admin.getAge());
            pa.setString(4, admin.getGender());
            pa.setString(5, admin.getLocation());
            
            pa.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    

    public ArrayList<AdminVO> showAdmins() {
        ArrayList<AdminVO> arr = new ArrayList<AdminVO>();
        AdminVO adm;
        try {
            Connection acceso = objConexion.obtenerConexion();
            PreparedStatement pa = acceso.prepareStatement("SELECT * from admin");
            ResultSet rs = pa.executeQuery();
            while (rs.next()) {
                adm = new AdminVO();
                adm.setName(rs.getString(1));
                adm.setLastName(rs.getString(2));
                adm.setAge(rs.getInt(3));
                adm.setGender(rs.getString(4));
                adm.setLocation(rs.getString(5));
                arr.add(adm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public void deleteAdmin(AdminVO adm)
    {
        Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.obtenerConexion().createStatement();
			estatuto.executeUpdate("DELETE FROM admin WHERE name='"+adm.getName()+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","InformaciÛn",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
                }
    }
    public void modifyAdmin(AdminVO adm) {
		
		Conexion conex= new Conexion();
		try{
                        String consulta="UPDATE admin SET name= ? , lastName= ? , age= ? , gender= ? , location= ? WHERE name= ? ";
			PreparedStatement estatuto = conex.obtenerConexion().prepareStatement(consulta);
			
            estatuto.setString(1, adm.getName());
            estatuto.setString(2, adm.getLastName());
            estatuto.setInt(3, adm.getAge());
            estatuto.setString(4, adm.getGender());
            estatuto.setString(5, adm.getLocation());
            estatuto.executeUpdate();

          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","ConfirmaciÛn",JOptionPane.INFORMATION_MESSAGE);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}
          
    public AdminVO searchAdmin(String codigo)
    {
        
        String consulta="SELECT * FROM admin WHERE name = '"+codigo+"'";
        AdminVO objVO = new AdminVO("","",0,"","");
        try{
            Statement ps = objConexion.obtenerConexion().createStatement();
            ResultSet rs = ps.executeQuery(consulta);

            while(rs.next()){
                objVO.setName(rs.getString("name"));
                objVO.setLastName(rs.getString("lastName"));
                objVO.setAge(rs.getInt("age"));
                objVO.setGender(rs.getString("gender"));
                objVO.setLocation(rs.getString("location"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return objVO;
    }
}
