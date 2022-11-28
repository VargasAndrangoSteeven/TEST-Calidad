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

public class ClientDataDAO {

    Conexion objConexion = new Conexion();

    public void insertClientData(ClientVO cdVO) {
        try {
            String temp = "";

            Connection acceso = objConexion.obtenerConexion();
            String sql1 = "SELECT user from temp";
            PreparedStatement pa1 = acceso.prepareStatement(sql1);
            ResultSet rs = pa1.executeQuery();
            while (rs.next()) {
                temp = rs.getString(1);
            }


            String sql = "UPDATE client SET "
                    + "name = ?"
                    + ",lastName = ?"
                    + ",age = ?"
                    + ",gender = ?"
                    + ",weight = ? "
                    + ",texture = ? "
                    + ",height = ? "
                    + ",location = ? "
                    + "WHERE user=?";

            PreparedStatement pa = acceso.prepareStatement(sql);
            pa.setString(1, cdVO.getName());
            pa.setString(2, cdVO.getLastName());
            pa.setInt(3, cdVO.getAge());
            pa.setString(4, cdVO.getGender());
            pa.setDouble(5, cdVO.getWeight());
            pa.setString(6, cdVO.getTexture());
            pa.setDouble(7, cdVO.getHeight());
            pa.setString(8, cdVO.getLocation());
            pa.setString(9, temp);

            pa.executeUpdate();
            
            String drop = "DROP TABLE temp";
            PreparedStatement dropPS = acceso.prepareStatement(drop);
            
            dropPS.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<ClientDataVO> showClientData() {
        ArrayList<ClientDataVO> arr = new ArrayList<ClientDataVO>();
        ClientDataVO cdVO;
        try {
            Connection acceso = objConexion.obtenerConexion();
            PreparedStatement pa = acceso.prepareStatement("SELECT * from client");
            ResultSet rs = pa.executeQuery();
            while (rs.next()) {
                cdVO = new ClientDataVO();
                cdVO.setName(rs.getString(3));
                cdVO.setLastName(rs.getString(4));
                cdVO.setAge(Integer.parseInt(rs.getString(5)));
                cdVO.setGender(rs.getString(6));
                cdVO.setWeight(Double.parseDouble(rs.getString(7)));
                cdVO.setTexture(rs.getString(8));
                cdVO.setHeight(Double.parseDouble(rs.getString(9)));
                cdVO.setLocation(rs.getString(10));
                arr.add(cdVO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public void deleteClientData(ClientDataVO cdVO) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.obtenerConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM client WHERE name='" + cdVO.getName() + "'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente", "InformaciÛn", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Elimino");
        }
    }

    public void modifyClientData(ClientDataVO cdVO) {

        Conexion conex = new Conexion();
        try {
            String consulta = "UPDATE client SET name= ?, lastName= ? , age= ?, gender= ?, weight= ?, texture= ?, height= ?, location= ?  WHERE name= ? ";
            PreparedStatement estatuto = conex.obtenerConexion().prepareStatement(consulta);

            estatuto.setString(1, cdVO.getName());
            estatuto.setString(2, cdVO.getLastName());
            estatuto.setString(3, Integer.toString(cdVO.getAge()));
            estatuto.setString(4, cdVO.getGender());
            estatuto.setString(5, Double.toString(cdVO.getWeight()));
            estatuto.setString(6, cdVO.getTexture());
            estatuto.setString(7, Double.toString(cdVO.getHeight()));
            estatuto.setString(8, cdVO.getLocation());

            estatuto.executeUpdate();

            JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ", "ConfirmaciÛn", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public ClientDataVO searchClientData(String codigo) {

        String consulta = "SELECT * FROM client WHERE name = '" + codigo + "'";
        ClientDataVO objVO = new ClientDataVO("", "", 0, "", 0, "", 0, "");
        try {
            Statement ps = objConexion.obtenerConexion().createStatement();
            ResultSet rs = ps.executeQuery(consulta);

            while (rs.next()) {
                objVO.setName(rs.getString("name"));
                objVO.setLastName(rs.getString("lastName"));
                objVO.setAge(Integer.parseInt(rs.getString("age")));
                objVO.setGender(rs.getString("gender"));
                objVO.setWeight(Double.parseDouble(rs.getString("weight")));
                objVO.setTexture(rs.getString("texture"));
                objVO.setHeight(Double.parseDouble(rs.getString("height")));
                objVO.setLocation(rs.getString("location"));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return objVO;
    }
}
