package code;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import javax.swing.*;


public class Controller implements Initializable{

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNim;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfFalkultas;

    @FXML
    private TextField tfJurusan;

    @FXML
    private TextField tfAlamat;

    @FXML
    private TextField tfKota;

    @FXML
    private TextField tfHobby;

    @FXML
    private TableView<DataMahasiswa> tvMahasiswa;

    @FXML
    private TableColumn<DataMahasiswa, Integer> colId;

    @FXML
    private TableColumn<DataMahasiswa, String> colNim;

    @FXML
    private TableColumn<DataMahasiswa, String> colNama;

    @FXML
    private TableColumn<DataMahasiswa, String> colFalkultas;

    @FXML
    private TableColumn<DataMahasiswa, String> colJurusan;

    @FXML
    private TableColumn<DataMahasiswa, String> colAlamat;

    @FXML
    private TableColumn<DataMahasiswa, String> colKota;

    @FXML
    private TableColumn<DataMahasiswa, String> colHobby;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btn_simpan;

    @FXML
    private Button btn_pilihFoto;

    @FXML
    private ImageView tfImage;



    @FXML
    void HandleButtonAction(ActionEvent event) {

        if(event.getSource() == btnInsert){
            insertRecord();
        }else if(event.getSource() == btnUpdate){
            updateRecord();
        }else if(event.getSource() == btnDelete){
            deleteButton();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        showDataMahasiswa();

    }

    public static Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            return conn;
        }catch (Exception ex){
            System.out.println("Error : " + ex.getMessage());
            return null;
        }
    }
    public ObservableList<DataMahasiswa>getDataMahasiswaList(){
        ObservableList<DataMahasiswa>DataMahasiswaList= FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM DataMahasiswa";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            DataMahasiswa datamahasiswa;
            while(rs.next()){
                datamahasiswa = new DataMahasiswa(rs.getInt("id"), rs.getString("nim"), rs.getString("nama"), rs.getString("falkultas"),
                        rs.getString("jurusan"), rs.getString("alamat"), rs.getString("kota"), rs.getString("hobby"));
                DataMahasiswaList.add(datamahasiswa);
            }

        }catch (Exception ex){
            ex.printStackTrace();

        }
        return  DataMahasiswaList;
    }

    public void showDataMahasiswa(){
        ObservableList<DataMahasiswa> list = getDataMahasiswaList();

        colId.setCellValueFactory(new PropertyValueFactory<DataMahasiswa, Integer>("id"));
        colNim.setCellValueFactory(new PropertyValueFactory<DataMahasiswa, String>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<DataMahasiswa, String>("nama"));
        colFalkultas.setCellValueFactory(new PropertyValueFactory<DataMahasiswa, String>("falkultas"));
        colJurusan.setCellValueFactory(new PropertyValueFactory<DataMahasiswa, String>("jurusan"));
        colAlamat.setCellValueFactory(new PropertyValueFactory<DataMahasiswa, String>("alamat"));
        colKota.setCellValueFactory(new PropertyValueFactory<DataMahasiswa, String>("kota"));
        colHobby.setCellValueFactory(new PropertyValueFactory<DataMahasiswa, String>("hobby"));

        tvMahasiswa.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO datamahasiswa VALUES (" + tfId.getText() + ",'"+ tfNim.getText() + "','" + tfNama.getText() + "','" + tfFalkultas.getText() + "','" + tfJurusan.getText() + "','" +
                tfAlamat.getText() + "','" + tfKota.getText() + "','" + tfHobby.getText() + "')";

        executeQuery(query);
        showDataMahasiswa();
    }
    private void updateRecord(){
        String query = "UPDATE datamahasiswa SET nim = '" + tfNim.getText() + "', nama =  '" + tfNama.getText() + "', falkultas =  '" + tfFalkultas.getText() + "', jurusan =  '" +
                tfJurusan.getText() + "', alamat =  '" + tfAlamat.getText() + "', kota =  '" + tfKota.getText() + "', hobby =  '" + tfHobby.getText() + "', gambar =  '" + tfImage.getImage() + "' WHERE id = " + tfId.getText() + "";
        executeQuery(query);
        showDataMahasiswa();
    }
    private void deleteButton(){
        String query = "DELETE FROM datamahasiswa WHERE id =" + tfId.getText() + "";
        executeQuery(query);
        showDataMahasiswa();
    }

    private void executeQuery(String query){
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);

        }catch (Exception ex){
            ex.printStackTrace();

        }
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        DataMahasiswa dataMahasiswa = tvMahasiswa.getSelectionModel().getSelectedItem();
        tfId.setText("" +dataMahasiswa.getId());
        tfNim.setText(dataMahasiswa.getNim());
        tfNama.setText(dataMahasiswa.getNama());
        tfFalkultas.setText(dataMahasiswa.getFalkultas());
        tfJurusan.setText(dataMahasiswa.getJurusan());
        tfAlamat.setText(dataMahasiswa.getAlamat());
        tfKota.setText(dataMahasiswa.getKota());
        tfHobby.setText(dataMahasiswa.getHobby());

    }

    FileChooser milih = new FileChooser();
    Path lokasi = Paths.get("D:\\");

    @FXML
    void simpan_Foto(ActionEvent event) {
        btn_simpan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String query = "INSERT INTO datamahasiswa VALUES (" + tfId.getText() + ",'"+ tfNim.getText() + "','" + tfNama.getText() + "','" + tfFalkultas.getText() + "','" + tfJurusan.getText() + "','" +
                        tfAlamat.getText() + "','" + tfKota.getText() + "','" + tfHobby.getText() + "','" + tfImage.getImage() + "')";

                executeQuery(query);
                showDataMahasiswa();

                    JOptionPane.showMessageDialog(null, "Data telah disimpan");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data tidak disimpan");
                }
            }
        });

    }

    @FXML
    void uploadFoto(ActionEvent event) {
        btn_pilihFoto.setOnAction(event1 -> {
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg");
            milih.getExtensionFilters().add(extFilter);
            File file = milih.showOpenDialog(btn_pilihFoto.getParent().getScene().getWindow());
            if(file != null){
                tfImage.setImage(Image.impl_fromPlatformImage(file.getPath()));
                String namaPorto = file.getName();
                Path lokasiFilePorto = lokasi.resolve(namaPorto);
                File writePorto = new File(String.valueOf(lokasiFilePorto));
                try {
                    Files.copy(file.toPath(), writePorto.toPath());
                } catch (IOException e){
                    e.printStackTrace();
                }
                tfImage.setImage(Image.impl_fromPlatformImage(file.getName()));
            }
        });

    }



}
