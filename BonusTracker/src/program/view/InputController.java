package program.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import program.controller.Controller;
import program.model.BonusCampaign;
import program.model.BonusTracker;
import program.model.SalesData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class InputController {
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private TableView<String[]> tableView;

    @FXML
    private TextField filePathTextField;
    @FXML
    private TableView<String[]> tableView1;

    @FXML
    private TextField filePathTextField1;
    
    Controller controller = new Controller();
    @FXML
    private void handleBrowseButtonAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Importing the Sales Data");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            filePathTextField.setText(file.getAbsolutePath());
            displayCsvData(file);
        }
        
    }
    @FXML
    private void handleBrowseButtonAction1() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Importing the Bonus Data");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            filePathTextField1.setText(file.getAbsolutePath());
            displayCsvData1(file);
        }
        controller.getbonusDetail(filePathTextField1.getText()); 
        
    }
    @FXML
    private void handleTrackBonusButtonAction(ActionEvent e) 
    {
    	
    	
    	controller.getSalesDetails(filePathTextField.getText());
        // Retrieve sales data and bonus campaigns
        List<SalesData> salesData = controller.getSalesData();
        List<BonusCampaign> bonusCampaigns = controller.getBonusCampaign();

        // Check if sales data and bonus campaigns are not empty
        if (!salesData.isEmpty() && !bonusCampaigns.isEmpty()) { 
            // Generate bonus tracker list using sales data and bonus campaigns
        	List<BonusTracker> bonusTrackerList =  controller.generateBonusTrackerList(salesData, bonusCampaigns);
                 
            
                 controller.writeBonusTrackerCSVFile("Output12.csv", bonusTrackerList);

            System.out.println("Bonus tracker data has been written to output.csv");
        } else {
            System.out.println("Sales data or bonus campaigns are empty. Cannot generate bonus tracker.");
        }
        try {
   		 root= FXMLLoader.load(getClass().getResource("output.fxml"));
   		stage=(Stage)((Node)e.getSource()).getScene().getWindow();
   		scene=new Scene(root);
   		stage.setScene(scene);
   		stage.show(); 
   		
   		
   	} catch (IOException e1) {
   		// TODO Auto-generated catch block
   		e1.printStackTrace();
   	}
   }
    
    
   
 
private void displayCsvData(File file) {
    // Clear previous data
    tableView.getColumns().clear();
    tableView.getItems().clear();

    // Read CSV file and add data to the table
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        // Read the header line
        String headerLine = br.readLine();
        String[] headers = headerLine.split(",");

        // Create TableColumn instances for each header
        for (String header : headers) {
            TableColumn<String[], String> column = new TableColumn<>(header);
            final int columnIndex = tableView.getColumns().size();
            column.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue()[columnIndex]));
            tableView.getColumns().add(column);
        }

        // Read and display data lines
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(","); // Assuming CSV fields are comma-separated

            // Make sure the data array has the same length as the number of columns
            if (data.length == headers.length) {
                tableView.getItems().add(data);
            } else {
                // Handle the case where the data length doesn't match the header length
                System.err.println("Data length doesn't match header length.");
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


private void displayCsvData1(File file) {
// Clear previous data
tableView1.getColumns().clear();
tableView1.getItems().clear();

// Read CSV file and add data to the table
try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    // Read the header line
    String headerLine = br.readLine();
    String[] headers = headerLine.split(",");

    // Create TableColumn instances for each header
    for (String header : headers) {
        TableColumn<String[], String> column = new TableColumn<>(header);
        final int columnIndex = tableView1.getColumns().size();
        column.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue()[columnIndex]));
        tableView1.getColumns().add(column);
    }

    // Read and display data lines
    String line;
    while ((line = br.readLine()) != null) {
        String[] data = line.split(","); // Assuming CSV fields are comma-separated

        // Make sure the data array has the same length as the number of columns
        if (data.length == headers.length) {
            tableView1.getItems().add(data);
        } else {
            // Handle the case where the data length doesn't match the header length
            System.err.println("Data length doesn't match header length.");
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}
}




}
