# JavaFX Bonus Tracker Generator

This project is a JavaFX application designed to generate bonus tracker reports based on sales data and bonus campaign information. It provides a user-friendly graphical interface for importing sales data and bonus campaign data from CSV files, processing the data, and generating a new CSV file containing bonus tracker information.

## Features:
- User-friendly graphical interface built with JavaFX.
- Imports sales data and bonus campaign data from CSV files.
- Matches sales data with corresponding bonus campaigns to calculate bonus tracker information.
- Calculates auto-approved bonuses based on predefined maximum MF (Manufacturer's Factor) values.
- Generates a CSV file containing bonus tracker information including auto-approved bonuses, cut bonuses, and additional notes.

## Usage:
1. Run the JavaFX application.
2. Use the graphical interface to import sales data CSV files containing columns such as PRODUCT NAME, BARCODE, PRICE, etc.
3. Import bonus campaign data CSV files containing columns such as PRODUCT_1_NAME, PRODUCT_1_BARCODE, PRODUCT_1_MF, etc.
4. Follow the on-screen instructions to generate the bonus tracker report.
5. View the generated CSV file for bonus tracker information.

## Instructions for Eclipse:
1. Clone the repository to your local machine.
2. Import the project into Eclipse: 
   - Open Eclipse IDE.
   - Go to File > Import.
   - Select General > Existing Projects into Workspace.
   - Browse to the directory where you cloned the repository and select the project folder.
   - Click Finish.
3. Configure JavaFX in Eclipse:
   - Right-click on the project in the Package Explorer.
   - Go to Build Path > Configure Build Path.
   - Click on the Libraries tab.
   - Click on Add Library.
   - Select User Library, then click Next.
   - Click on User Libraries... button.
   - Click on New, name it "JavaFX", and add the necessary JavaFX jars.
   - Click Finish and then OK.
4. Run the JavaFX application:
   - Right-click on the main class (the one with the main method).
   - Select Run As > Java Application.
5. Use the graphical interface to interact with the application and generate bonus tracker reports.

## Dependencies:
- JavaFX
- Java 8 or higher

## Contributing:
Contributions are welcome! If you encounter any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.

## License:
This project is licensed under the MIT License - see the [LICENSE](LICENSE.md) file for details.
