package program.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class outputContoller {

    @FXML
    private TableView<String[]> tableView;

    @FXML
    public void initialize() {
        File file = new File("Output12.csv");
        displayCsvData(file);
    }
    @FXML
    private void handleExitButtonAction() {
        Platform.exit(); // Shut down the JavaFX application
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
}