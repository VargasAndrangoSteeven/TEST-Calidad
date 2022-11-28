package Controller;

import Model.*;
import View.JFClientManagementMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ClientController implements ActionListener{
    JFClientManagementMenu objVista = new JFClientManagementMenu();
    ClientDataDAO objDAO = new ClientDataDAO();
    ClientDataVO objVO = new ClientDataVO();
    ClientVO cli = new ClientVO();
    public ClientController(JFClientManagementMenu objVista) {
        this.objVista = objVista;
        this.objVista.btnEnter.addActionListener(this);
        this.objVista.btnDelete.addActionListener(this);
        this.objVista.btnModify.addActionListener(this);
        this.objVista.btnSearch.addActionListener(this);
        this.objVista.btnShow.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVista.btnEnter)
        {
            String nombre = objVista.txtName.getText();
            String apellido = objVista.txtLastName.getText();
            int edad = Integer.parseInt(objVista.txtAge.getText());
            String genero = objVista.jcbGender.getItemAt(objVista.jcbGender.getSelectedIndex());
            double peso = Double.parseDouble(objVista.txtWeight.getText());
            String contextura = objVista.jcbTexture.getItemAt(objVista.jcbTexture.getSelectedIndex());
            double altura = Double.parseDouble(objVista.txtHeight.getText());
            String location = objVista.jcbLocality.getItemAt(objVista.jcbLocality.getSelectedIndex());
            
            objVO = new ClientDataVO(nombre,apellido,edad, genero, peso, contextura, altura, location);
            objDAO.insertClientData(cli);
            
            objVista.txtName.setText("");
            objVista.txtLastName.setText("");
            objVista.txtAge.setText("");
            objVista.jcbGender.setSelectedIndex(0);
            objVista.jcbLocality.setSelectedIndex(0);
 
            
        }else if(e.getSource()==objVista.btnDelete)
        {
        int numerofila = objVista.jTable1.getSelectedRow();
        ArrayList<ClientDataVO> arr = new ArrayList<>();
        arr = objDAO.showClientData();
        objVO = arr.get(numerofila);
        objDAO.deleteClientData(objVO);
            
        }else if(e.getSource()==objVista.btnSearch)
        {
            String codigo = objVista.txtName.getText();
            ClientDataVO aux = objDAO.searchClientData(codigo);
            if(aux.getName().equals(codigo)){
                objVista.txtLastName.setText(aux.getLastName());
                objVista.txtAge.setText(Integer.toString(aux.getAge()));
                objVista.jcbGender.setSelectedItem(aux.getGender());
                objVista.txtWeight.setText(Double.toString(aux.getWeight()));
                objVista.jcbTexture.setSelectedItem(aux.getTexture());
                objVista.txtHeight.setText(Double.toString(aux.getHeight()));
                objVista.jcbLocality.setSelectedItem(aux.getLocation());
            }
            else{
                System.out.println("No existe el cliente con ese codigo");
            }
        }else if (e.getSource()==objVista.btnModify)
        {
            String nombre = objVista.txtName.getText();
            String apellido = objVista.txtLastName.getText();
            int edad = Integer.parseInt(objVista.txtAge.getText());
            String genero = objVista.jcbGender.getItemAt(objVista.jcbGender.getSelectedIndex());
            double peso = Double.parseDouble(objVista.txtWeight.getText());
            String contextura = objVista.jcbTexture.getItemAt(objVista.jcbTexture.getSelectedIndex());
            double altura = Double.parseDouble(objVista.txtHeight.getText());
            String location = objVista.jcbLocality.getItemAt(objVista.jcbLocality.getSelectedIndex());
            
            objVO = new ClientDataVO(nombre,apellido,edad, genero, peso, contextura, altura, location);
            objDAO.modifyClientData(objVO);
            
         
        }else if (e.getSource()==objVista.btnShow)
        {
             ArrayList<ClientDataVO> arr = new ArrayList<>();
             arr = objDAO.showClientData();
            DefaultTableModel modelo = new DefaultTableModel();
            objVista.jTable1.setModel(modelo);
            modelo.addColumn("NOMBRE");
            modelo.addColumn("APELLIDO");
            modelo.addColumn("EDAD");
            modelo.addColumn("GENERO");
            modelo.addColumn("PESO");
            modelo.addColumn("CONTEXTURA");
            modelo.addColumn("ALTURA");
            modelo.addColumn("LOCALIDAD");
            
            Object[] columna = new Object[8];
            for( int i=0; i<arr.size();i++){
                columna[0] = arr.get(i).getName();
                columna[1] = arr.get(i).getLastName();
                columna[2] = arr.get(i).getAge();
                columna[3] = arr.get(i).getGender();
                columna[4] = arr.get(i).getWeight();
                columna[5] = arr.get(i).getTexture();
                columna[6] = arr.get(i).getHeight();
                columna[7] = arr.get(i).getLocation();
                
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