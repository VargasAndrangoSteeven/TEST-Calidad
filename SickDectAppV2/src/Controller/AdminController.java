package Controller;

import Model.*;
import View.JFAdminManagementMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class AdminController implements ActionListener{
    
    JFAdminManagementMenu objVista = new JFAdminManagementMenu();
    AdminDAO objDAO= new AdminDAO();
    AdminVO objVO= new AdminVO();
    
    public AdminController(JFAdminManagementMenu objVista)
    {
        this.objVista = objVista;
        this.objVista.btnEnter.addActionListener(this);
        this.objVista.btnDelete.addActionListener(this);
        this.objVista.btnModify.addActionListener(this);
        this.objVista.btnShow.addActionListener(this);
        this.objVista.btnSearch.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVista.btnEnter)
        {
            String nombre = objVista.txtName.getText();
            String apellido = objVista.txtLastName.getText();
            int edad = Integer.parseInt(objVista.txtAge.getText());
            String genero = objVista.jcbGender.getItemAt(objVista.jcbGender.getSelectedIndex());
            String location = objVista.jcbLocality.getItemAt(objVista.jcbLocality.getSelectedIndex());
            
            objVO = new AdminVO(nombre,apellido,edad, genero, location);
            objDAO.insertAdmin(objVO);
            
            objVista.txtName.setText("");
            objVista.txtLastName.setText("");
            objVista.txtAge.setText("");
            objVista.jcbGender.setSelectedIndex(0);
            objVista.jcbLocality.setSelectedIndex(0);
 
            
        }else if(e.getSource()==objVista.btnDelete)
        {
        int numerofila = objVista.jTable1.getSelectedRow();
        ArrayList<AdminVO> arr = new ArrayList<>();
        arr = objDAO.showAdmins();
        objVO = arr.get(numerofila);
        objDAO.deleteAdmin(objVO);
            
        }else if(e.getSource()==objVista.btnSearch)
        {
            String codigo = objVista.txtName.getText();
            AdminVO aux = objDAO.searchAdmin(codigo);
            if(aux.getName().equals(codigo)){
                objVista.txtLastName.setText(aux.getLastName());
                objVista.txtAge.setText(Integer.toString(aux.getAge()));
                objVista.jcbGender.setSelectedItem(aux.getGender());
                objVista.jcbLocality.setSelectedItem(aux.getLocation());
            }
            else{
                System.out.println("No existe el administrador con ese codigo");
            }
        }else if (e.getSource()==objVista.btnModify)
        {
            String nombre = objVista.txtName.getText();
            String apellido = objVista.txtLastName.getText();
            int edad = Integer.parseInt(objVista.txtAge.getText());
            String genero = objVista.jcbGender.getItemAt(objVista.jcbGender.getSelectedIndex());
            String location = objVista.jcbLocality.getItemAt(objVista.jcbLocality.getSelectedIndex());
            
            objVO = new AdminVO(nombre,apellido,edad, genero, location);
            objDAO.modifyAdmin(objVO);
            
         
        }else if (e.getSource()==objVista.btnShow)
        {
             ArrayList<AdminVO> arr = new ArrayList<>();
             arr = objDAO.showAdmins();
            DefaultTableModel modelo = new DefaultTableModel();
            objVista.jTable1.setModel(modelo);
            modelo.addColumn("NOMBRE");
            modelo.addColumn("APELLIDO");
            modelo.addColumn("EDAD");
            modelo.addColumn("GENERO");
            modelo.addColumn("LOCALIDAD");
            
            Object[] columna = new Object[5];
            for( int i=0; i<arr.size();i++){
                columna[0] = arr.get(i).getName();
                columna[1] = arr.get(i).getLastName();
                columna[2] = arr.get(i).getAge();
                columna[3] = arr.get(i).getGender();
                columna[4] = arr.get(i).getLocation();
                modelo.addRow(columna);
         
        }
             objVista.txtName.setText("");
            objVista.txtLastName.setText("");
            objVista.txtAge.setText("");
            objVista.jcbGender.setSelectedIndex(0);
            objVista.jcbLocality.setSelectedIndex(0);
        }
    }
}
