package com.example.form_javafx;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private TableView<Mahasiswa> table = new TableView<Mahasiswa>();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        stage.setTitle("Test Table View");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Arial", 30));

        table.setEditable(true);

        TableColumn tcName = new TableColumn("Name");
        tcName.setMinWidth(100);



        TableColumn tcNim = new TableColumn("NIM");
        tcNim.setMinWidth(130);


        TableColumn tcEmail = new TableColumn("Email");
        tcEmail.setMinWidth(180);

        table.getColumns().addAll(tcName,tcNim,tcEmail);


        final VBox vbox = new VBox();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20,10,10,10));

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        final ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
                new Mahasiswa("Krisna","202210370311254","krisnabmntr@gmail.com"),
                new Mahasiswa("Irfan", "202210370311246","irfan@gmail.com")

        );

        tcName.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa,String>("name")
        );
        tcNim.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa,String>("nim")
        );
        tcEmail.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa,String>("email")
        );




        final TextField addName = new TextField();
        addName.setMaxWidth(tcName.getPrefWidth());
        addName.setPromptText("Nama Mahasiswa");

        final TextField addNim = new TextField("");
        addNim.setMaxWidth(tcNim.getPrefWidth());
        addNim.setPromptText("NIM");

        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(tcEmail.getPrefWidth());
        addEmail.setPromptText("Email");

        final Button addButton = new Button("Add");

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.add(new Mahasiswa(addName.getText(),addNim.getText(),addEmail.getText()));
                addName.clear();
                addNim.clear();
                addEmail.clear();
            }


        });

        final HBox hboxInput = new HBox();
        hboxInput.getChildren().addAll(addName,addNim,addEmail,addButton);
        hboxInput.setSpacing(10);

       vbox.getChildren().addAll(label,table,hboxInput);

        table.setItems(data);
        stage.setScene(scene);
        stage.show();

    }


    public static class Mahasiswa{

        private final SimpleStringProperty name;
        private final SimpleStringProperty nim;
        private final SimpleStringProperty email;

        private Mahasiswa(String name, String nim, String email) {
            this.name = new SimpleStringProperty(name);
            this.nim = new SimpleStringProperty(nim);
            this.email = new SimpleStringProperty(email);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getNim() {
            return nim.get();
        }

        public void setNim(String nim) {
            this.nim.set(nim);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String email) {
            this.email.set(email);
        }




    }
}