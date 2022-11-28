package Model;
/**
 *
 * @author SickDectTeam
 */
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArchiveManager{
    /*
        Se añade un cliente al archivo ClientsArchive con informacion ingresada como parametro y 
        desde un archivo auxiliar AuxArchive, posteriormente borra el archivo auxiliar
    */
    public void createClientsArchive(ClientDataVO newClientData) throws IOException{
        File archive = new File("Archives/ClientsArchive.txt");
        File auxArchive = new File("Archives/AuxArchive.txt");
        FileWriter fw;
        BufferedWriter bw;
        FileReader fr;
        BufferedReader br;
        
        if(!archive.exists()){
            archive.createNewFile();
        }
        fw = new FileWriter(archive,true);
        bw = new BufferedWriter(fw);
        fr = new FileReader(auxArchive);
        br = new BufferedReader(fr);
        
        String line = br.readLine();        
        String [] contact = line.split("%");
        ClientVO auxClient = new ClientVO();
        auxClient.setUser(contact[0]);
        auxClient.setPassword(encrypt(contact[1]));
        br.close();
        
        Gson gson = new Gson();
        String gsonClient = gson.toJson(auxClient);
        String gsonClientData = gson.toJson(newClientData);
        
        bw.write(gsonClient+"%"+gsonClientData);
        bw.newLine();
        bw.close();
        if (!auxArchive.delete()) {
            System.out.println("Could not delete aux file");
        }
    }
    /*
        Lee el archivo AdminsArchive y devuelve un ArrayList con todos los administradores registrados
    */
    public AdminsList readAdmins() throws FileNotFoundException, IOException{
        File archive = new File("Archives/AdminsArchive.txt");
        FileReader fr = new FileReader(archive);
        BufferedReader br = new BufferedReader(fr);
        AdminsList al = new AdminsList();
        
        if(!archive.exists()){
            archive.createNewFile();
        }
        
        String line;
        while((line = br.readLine())!=null){
            String [] contact = line.split("%");
            Gson gson = new Gson();
            AdministratorVO aux = (AdministratorVO)gson.fromJson(contact[0], AdministratorVO.class);
            al.listA.add(aux);
        }
        return al;
    }
    /*
        Lee el archivo ClientsArchive y devuelve un ArrayList con todos los usuarios registrados
    */
    public ClientsList readUsers() throws FileNotFoundException, IOException{
        File archive = new File("Archives/ClientsArchive.txt");
        FileReader fr = new FileReader(archive);
        BufferedReader br = new BufferedReader(fr);
        ClientsList cl = new ClientsList();
              
        if(!archive.exists()){
            archive.createNewFile();
        }
        
        String line;
        while((line = br.readLine())!=null){
            String [] contact = line.split("%");
            Gson gson = new Gson();
            ClientVO aux = (ClientVO)gson.fromJson(contact[0], ClientVO.class);
            cl.listC.add(aux);
        }
        return cl;
    }
    /*
        Crea un archivo auxiliar auxArchive donde se guarda momentaneamente la informacion de un usuario
        para no perderla entre el movimiento de interfaces
    */
    public void createAuxArchive(ClientVO newClient) throws IOException{
        File archive = new File("Archives/AuxArchive.txt");
        FileWriter fw;
        BufferedWriter bw;
        
        if(!archive.exists()){
            archive.createNewFile();
        }
        fw = new FileWriter(archive,true);
        bw = new BufferedWriter(fw);
        bw.write(newClient.getUser()+"%"+newClient.getPassword());
        bw.close();
    }
    /*
        Crea un archivo auxiliar AdminAuxArchive donde se guarda momentaneamente la informacion de un administrador
        para no perderla entre el movimiento de interfaces
    */
    public void createAdminAuxArchive(AdministratorVO newAdmin) throws IOException{
        File archive = new File("Archives/AdminAuxArchive.txt");
        FileWriter fw;
        BufferedWriter bw;
        
        if(!archive.exists()){
            archive.createNewFile();
        }
        fw = new FileWriter(archive,true);
        bw = new BufferedWriter(fw);
        bw.write(newAdmin.getUser()+"%"+newAdmin.getPassword());
        bw.close();
    }
    /*
        Se añade un administrador al archivo AdminsArchive con informacion ingresada como 
        parametro y desde un archivo auxiliar AdminAuxArchive, possteriormente borra el 
        archivo auxiliar
    */
    public void createAdminsArchive(AdminVO newAdminData) throws IOException{
        File archive = new File("Archives/AdminsArchive.txt");
        File auxArchive = new File("Archives/AdminAuxArchive.txt");
        FileWriter fw;
        BufferedWriter bw;
        FileReader fr;
        BufferedReader br;
        
        if(!archive.exists()){
            archive.createNewFile();
        }
        fw = new FileWriter(archive,true);
        bw = new BufferedWriter(fw);
        fr = new FileReader(auxArchive);
        br = new BufferedReader(fr);
        
        String line = br.readLine();        
        String [] contact = line.split("%");
        AdministratorVO auxAdmin = new AdministratorVO();
        auxAdmin.setUser(contact[0]);
        auxAdmin.setPassword(encrypt(contact[1]));
        br.close();
        
        Gson gson = new Gson();
        String gsonAdmin = gson.toJson(auxAdmin);
        String gsonAdminData = gson.toJson(newAdminData);
        
        bw.write(gsonAdmin+"%"+gsonAdminData);
        bw.newLine();
        bw.close();
        if (!auxArchive.delete()) {
            System.out.println("No se puede borrar el archivo");
        }
    }
    /*
        Verifica si un cliente ingresado existe en el archivo ClientsArchive para permitir
        su ingreso al sistema
    */
    public boolean verifyUser(ClientVO auxClient) throws IOException{
         boolean flagUser = false;
        ClientDAO cliDAO = new ClientDAO();
        ArrayList<ClientVO> arr = new ArrayList<>();
        arr = cliDAO.showClients();
        
        for(int i = 0; i<arr.size();i++ ) 
        {
            if((arr.get(i).getUser().equals(auxClient.getUser()))&&
               (arr.get(i).getPassword().equals(auxClient.getPassword())))
            {
                flagUser = true;
            }
        }
        return flagUser;
        
    }
    /*
        Verifica si un administrador ingresado existe en el archivo AdminsArchive para permitir
        su ingreso al sistema
    */
    public boolean verifyAdmin(AdministratorVO auxAdmin) throws IOException{
          boolean flagAdmin = false;
        AdministratorDAO admDAO = new AdministratorDAO();
        ArrayList<AdministratorVO> arr = new ArrayList<>();
        arr = admDAO.showAdministrators();
        
        for(int i = 0; i<arr.size();i++ ) 
        {
            if((arr.get(i).getUser().equals(auxAdmin.getUser()))&&
               (arr.get(i).getPassword().equals(auxAdmin.getPassword())))
            {
                flagAdmin = true;
            }
        }
        return flagAdmin;
        
    }
    /*
        Verifica si el nombre de usuario de un cliente ya a sido utilizado antes para evitar que existan dos
        clientes con el mismo nombre de usuario
    */
    public boolean verifyClientExistant(ClientVO auxClient) throws IOException{
        boolean flagClient = true;
        ClientDAO cliDAO = new ClientDAO();
        ArrayList<ClientVO> arr = new ArrayList<>();
        arr = cliDAO.showClients();
        
        for(int i = 0; i<arr.size();i++ ) 
        {
            if(arr.get(i).getUser().equals(auxClient.getUser()))
            {
                flagClient = false;
            }
        }
        return flagClient;
    }
    /*
        Verifica si el nombre de usuario de un administrador ya a sido utilizado para evitar que existan dos
        administradores con el mismo nombre de usuario
    */
    public boolean verifyAdminExistant(AdministratorVO auxAdministrator) throws IOException{
        boolean flagAdmin = true;
        AdministratorDAO admDAO = new AdministratorDAO();
        ArrayList<AdministratorVO> arr = new ArrayList<>();
        arr = admDAO.showAdministrators();
        
        for(int i = 0; i<arr.size();i++ ) 
        {
            if(arr.get(i).getUser().equals(auxAdministrator.getUser()))
            {
                flagAdmin = false;
            }
        }
        return flagAdmin;
    }
    /*
        Encripta las contraseñas para brindar seguridad al cliente o administrador
    */
    public static String encrypt(String password){
        String encryptPassword;  
        List<String> list = new ArrayList<>(Arrays.asList(password.split("")));

        for(int i=0; i<list.size();i++){
            String tempString = list.get(i);
            char tempChar = tempString.charAt(0);  
            int asciiValue = (int) tempChar;
            asciiValue = asciiValue+8;
            char newChar = (char)asciiValue;
            list.set(i, String.valueOf(newChar));
        }
        encryptPassword = String.join("", list);

        return encryptPassword;
    }
    /*
        Desencripta la contraseña para volverla a su estado inicial
    */
    public static String decrypt(String encryptPassword){
        String decryptPassword;
        List<String> list = new ArrayList<>(Arrays.asList(encryptPassword.split("")));

        for(int i=0; i<list.size();i++){
            String tempString = list.get(i);
            char tempChar = tempString.charAt(0);  
            int asciiValue = (int) tempChar;
            asciiValue = asciiValue-8;
            char newChar = (char)asciiValue;
            list.set(i, String.valueOf(newChar));
        }
        decryptPassword = String.join("", list);

        return decryptPassword;
    }
    /*
        Lista todos los sintomas encontrados en la primera linea de cada archivo en la carpeta symptoms
        y los devuelve en un ArrayList para colocarlos en un ComboBox de seleccion
    */
    public ArrayList<String> listSymptoms() throws FileNotFoundException, IOException{
        File bigPath = new File("Archives/Bases/symptoms");
        FileReader fr;
        BufferedReader br;
        ArrayList<String> arrFiles = new ArrayList<>();
        
        if(bigPath.exists()){
            File[] files = bigPath.listFiles();
            for(File aux : files){
                fr = new FileReader(aux);
                br = new BufferedReader(fr);
                String symptom = br.readLine();
                arrFiles.add(symptom);
            }
        }
        return arrFiles;
    }
    /*
        Devuelve el archivo en donde se encuentra el sintoma ingresado como argumento
    */
    public File getFile(String line) throws FileNotFoundException, IOException{
        File bigPath = new File("Archives/Bases/symptoms");
        FileReader fr;
        BufferedReader br;
        
        if(bigPath.exists()){
            File[] files = bigPath.listFiles();
            for(File aux : files){
                fr = new FileReader(aux);
                br = new BufferedReader(fr);
                String symptom = br.readLine();
                if(line.equals(symptom)){
                    return aux;
                }
            }
        }
        System.out.println("No se ha encontrado la linea en los archivo del Path");
        return null;
    }
    /*
        Guarda el sintoma principal del cliente en un archivo plano auxiliar para evitar perdida de
        informacion durante el cambio de interfaces
    */
    public void createMainSymptomArchive(String symptom) throws IOException{
        File archive = new File("Archives/AuxMainSymptom.txt");
        FileWriter fw;
        BufferedWriter bw;
        
        if(!archive.exists()){
            archive.createNewFile();
        }
        fw = new FileWriter(archive,true);
        bw = new BufferedWriter(fw);
        bw.write(symptom);
        bw.close();
    }
    /*
        Devuelve el sintoma principal guardado en el archivo auxiliar AuxMainSymptom, 
        posteriormente borra el archivo auxiliar
    */
    public String readMainSymptomArchive() throws IOException{
        File archive = new File("Archives/AuxMainSymptom.txt");
        FileReader fr;
        BufferedReader br;
        String line = null;
        
        if(archive.exists()){
            fr = new FileReader(archive);
            br = new BufferedReader(fr);
           line = br.readLine();
           br.close();
        }
        if (!archive.delete()) {
            System.out.println("Could not delete aux file");
        }
        return line;
    }
    /*
        Guarda la direccion ingresada como parametro en un archivo auxiliar para evitar la perdida
        de informacion durante el cambio de interfaces
    */
    public void createQuestionsPathArchive(String path) throws IOException{
        File archive = new File("Archives/auxQuestionsPath.txt");
        FileWriter fw;
        BufferedWriter bw;
        
        if(!archive.exists()){
            archive.createNewFile();
        }
        fw = new FileWriter(archive,true);
        bw = new BufferedWriter(fw);
        bw.write(path);
        bw.close();
    }
    /*
        Devuelve la direccion guardada en el archivo auxiliar auxQuestionsPath y posteriormente 
        borra el archvo auxiliar
    */
    public String readQuestionsPath() throws FileNotFoundException, IOException{
        File archive = new File("Archives/auxQuestionsPath.txt");
        FileReader fr = new FileReader(archive);
        String path;
        try (BufferedReader br = new BufferedReader(fr)) {
            path = br.readLine();
            br.close();
        }
        if (!archive.delete()) {
            System.out.println("Could not delete aux file");
        }
        
        return path;
    }
    /*
        Guarda la informacion de ENFERMEDAD, DESCRIPCION y TRATAMIENTO en el archivo auxiliar
        auxResults una vez identificada la enfermedad, posteriormente borra el archivo auxiliar auxQuestions
    */
    public void createTreatmentArchive(String question) throws IOException{
        ArchiveManager am = new ArchiveManager();
        File questions = new File("Archives/auxQuestions.txt");
        FileReader fr = new FileReader(questions);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine())!=null){
                String[] contact = line.split("%");
                if(contact[0].equals(question)){
                    am.saveInAuxResults(contact[1]);
                    am.saveInAuxResults(contact[2]);
                    am.saveInAuxResults(contact[3]);
                }
            }
            br.close();
            if(!questions.delete()){
                System.out.println("auxQuestions no se ha podido borrar");
            }
        }
    }
    /*
        Archivo auxiliar donde se guarda la informacion mas importante de cada ingreso de enfermedad tal como:
        USUARIO, ENFERMEDAD, DESCRIPCION, TRATAMIENTO para posteriormente crear un objeto Result
        con dicha informacion
    */
    public void saveInAuxResults(String result) throws IOException{
        File resultFile = new File("Archives/auxResults.txt");
        FileWriter fw = new FileWriter(resultFile,true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(result);
            bw.newLine();
            bw.close();
        }
    }
    /*
        Recoge la informacion del archivo auxiliar auxResult y crea un objeto con dicha informacion, guarda el objeto
        de tipo Gson en el archivo Results y posteriormente borra el archivo auxiliar auxResults
    */
    public void createResultFile() throws IOException{
        File result = new File("Archives/auxResults.txt");
        File archive = new File("Archives/auxQuestions.txt");
        File RESULT = new File("Archives/Results.txt");
        FileReader fr = new FileReader(result);
        FileWriter fw = new FileWriter(RESULT,true);
        BufferedReader br = new BufferedReader(fr);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            Result newResult = new Result();
            newResult.setUser(br.readLine());
            newResult.setSickness(br.readLine());
            newResult.setDescription(br.readLine());
            newResult.setTreatment(br.readLine());
            
            if(!RESULT.exists()){
                RESULT.createNewFile();
            }
            bw.write(newResult.getUser()+"%"+newResult.getSickness()+"%"+newResult.getDescription()+"%"+newResult.getTreatment());
            bw.newLine();
            bw.close();
            br.close();
            
            if(!result.delete()){
                System.out.println("No se puede borrar auxResults");
            }
            if(!archive.delete()){
                System.out.println("No se puede borrar auxQuestions");
            }   
        }
    }
    /*
        Crea un archivo auxiliar auxQuestions en donde se detallan las preguntas mas importantes una vez 
        determinado el sintoma principal
        El archivo auxQuestions cumple con condiciones que poseen los archivos donde toma papel importante
        el parametro boolean tool, que determina que preguntas van a ser creadas y cuales no
    */
    public void createAuxQuestions(boolean tool) throws IOException{
        ArchiveManager am = new ArchiveManager();
        File questionsPath = am.getFile(am.readQuestionsPath());
        File questions = new File("Archives/auxQuestions.txt");
        FileReader fr = new FileReader(questionsPath);
        try (BufferedReader br = new BufferedReader(fr)) {
            FileWriter fw = new FileWriter(questions,true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                String symptom = br.readLine();
                String principalQuestion = br.readLine();
                String line;
                
                while((line = br.readLine())!=null){
                    String [] contact = line.split("%");
                    if(tool==false) {
                        if(contact[4].equals("F")){
                            bw.write(contact[0]+"%"+contact[1]+"%"+contact[2]+"%"+contact[3]);
                            bw.newLine();
                        }
                    }
                    if(tool == true){
                        bw.write(contact[0]+"%"+contact[1]+"%"+contact[2]+"%"+contact[3]);
                        bw.newLine();
                    }
                }
                bw.close();
            }
        }
    }
    /*
        Esta funcion sirve para recrear el archivo auxQuestions al momento de ir ingresando las preguntas
        y segun el cliente las vaya respondiendo.
    */
    public void recreateAuxQuestions() throws FileNotFoundException, IOException{
        File archive = new File("Archives/auxQuestions.txt");
        File archTemp = new File("Archives/archTemp.txt");
        FileReader fr = new FileReader(archive);
        FileWriter fw = new FileWriter(archTemp,true);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
        String previousQuestion = br.readLine();
        String contact;
        
        while((contact = br.readLine())!=null){
            bw.write(contact);
            bw.newLine();
        }
        br.close();
        bw.close();
        
        if(!archive.delete()){
            System.out.println("No se puede borrar auxQuestions");
        }
        if(!archTemp.renameTo(archive)){
            System.out.println("No se puede renombrar auxQ");
        }
    }
    /*
        Esta funcion sirve para determinar la enfermedad del cliente segun haya respondido SI a 
        la pregunta, la misma que se envia como parametro para hacer una busqueda de archivos.
    */
    public String getSicknessReferingQuestion(String question) throws FileNotFoundException, IOException{
        File archive = new File("Archives/auxQuestions.txt");
        FileReader fr = new FileReader(archive);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String sickness = "";
        
        while((line = br.readLine())!= null){
            String [] contact = line.split("%");
            if(contact[0].equals(question)){
                sickness = contact[1]+"%"+contact[2]+"%"+contact[3];
            }
        }
        br.close();
        return sickness;
    }
    
    /*
        Esta funcion permite devolver los sintomas registrados en el archivo plano Results.txt
    */
    public ArrayList<String> getRegisteredSickness() throws FileNotFoundException, IOException{
        File result = new File("Archives/Results.txt");
        FileReader fr = new FileReader(result);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> arrStr = new ArrayList<>();
        
        String line;
        while((line = br.readLine())!= null){
            String[] contact = line.split("%");
            arrStr.add(contact[1]);
        }
        br.close();
        
        return arrStr;
    }
    
    public void auxArchivesDelet(){
        File result = new File("Archives/auxResults.txt");
        File archive = new File("Archives/auxQuestions.txt");
        
        if(!result.delete()){
            System.out.println("No se ha borrado auxResults");
        }
        if(archive.exists()){
            if(!archive.delete()){
                System.out.println("No se ha borrado auxQuestions");
            }
        }
    }
}