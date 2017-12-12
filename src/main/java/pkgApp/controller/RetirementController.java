package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturnWork;
	
	
	@FXML
	private TextField txtAnnualReturnRetired;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtSaveEachMonth;
	
	@FXML
	private TextField txtNeedToSave;
	
	@FXML
	private TextField txtMonthlySSI;
	

	public RetirementApp getMainApp() {
		
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		
		System.out.println("Clear pressed");
		txtYearsRetired.clear();
		txtYearsToWork.clear();
		txtRequiredIncome.clear();
		txtAnnualReturnRetired.clear();
		txtAnnualReturnWork.clear();
		txtSaveEachMonth.setText("");
		txtNeedToSave.setText("");
		txtMonthlySSI.clear();
		
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		this.format();
		if (isInputValid()) {
			
			Retirement retirement = new Retirement(Integer.parseInt(txtYearsToWork.getText())
				, Double.parseDouble(txtAnnualReturnWork.getText())
				, Integer.parseInt(txtYearsRetired.getText())
				, Double.parseDouble(txtAnnualReturnRetired.getText())
				, Double.parseDouble(txtRequiredIncome.getText())
				, Double.parseDouble(txtMonthlySSI.getText()));
		
		txtNeedToSave.setText("$"+ Double.toString(retirement.TotalAmountSaved()));
		
		txtSaveEachMonth.setText("$"+ Double.toString(retirement.AmountToSave()));
	}}
	
	private void format() {
		
		if (txtAnnualReturnWork.getText().contains("%")) {
			
			txtAnnualReturnWork.setText(Double.toString(Double.parseDouble(txtAnnualReturnWork.getText().replace("%",""))/100));
		}
		if (txtAnnualReturnRetired.getText().contains("%")) {
			
			txtAnnualReturnRetired.setText(Double.toString(Double.parseDouble(txtAnnualReturnRetired.getText().replace("%",""))/100));
		}
		if (txtRequiredIncome.getText().contains(",") || txtRequiredIncome.getText().contains("$")) {
			
			txtRequiredIncome.setText(txtRequiredIncome.getText().replace(",",""));
			txtRequiredIncome.setText(txtRequiredIncome.getText().replace("$",""));
		}
		if (txtMonthlySSI.getText().contains(",") || txtMonthlySSI.getText().contains("$")) {
			
			txtMonthlySSI.setText(txtMonthlySSI.getText().replace(",",""));
			txtMonthlySSI.setText(txtMonthlySSI.getText().replace("$",""));}
		}
		
	private boolean isInputValid(){
		
		
		if (txtYearsToWork.getText().isEmpty()) {
			
			 Alert alert = new Alert(AlertType.ERROR);
			 
			 alert.setContentText("Years to Work is empty!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		try {
			
			Integer.parseInt(txtYearsToWork.getText());
			
		} 
		
		catch (NumberFormatException e) {
			
			 Alert alert = new Alert(AlertType.ERROR);
			 
			 alert.setContentText("Years to Work is not valid, it must be integer!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		
		if (txtYearsRetired.getText().isEmpty()) {
			
			 Alert alert = new Alert(AlertType.ERROR);
			 
			 alert.setContentText("Years to Retire is empty!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		
		try {
			
			Integer.parseInt(txtYearsRetired.getText());
			
		} 
		
		catch (NumberFormatException e) {
			
			 Alert alert = new Alert(AlertType.ERROR);
			
			 alert.setContentText("Years to Retire is not valid, it should be integer!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		
		if (txtAnnualReturnWork.getText().isEmpty()) {
			
			 Alert alert = new Alert(AlertType.ERROR);
			 
			 alert.setContentText("Annual Return of Work is empty!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		try {
			
			double workReturn = Double.parseDouble(txtAnnualReturnWork.getText());
			
			if (workReturn>0.2||workReturn<0) {
				
				Alert alert = new Alert(AlertType.ERROR);
				
				 alert.setContentText("Annual Return of Work should between 0 and 0.2!");
				 
				 alert.showAndWait();
				 
				 return false;
			}
			
		} 
		
		catch (NumberFormatException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			
			 alert.setContentText("Annual Return of Work is not valid!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		
		if (txtAnnualReturnRetired.getText().isEmpty()) {
			
			 Alert alert = new Alert(AlertType.ERROR);
			 
			 alert.setContentText("Annual Return of Retire is empty!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		
		try {
			
			double retireReturn = Double.parseDouble(txtAnnualReturnRetired.getText());
			
			if (retireReturn>0.03||retireReturn<0) {
				
				 Alert alert = new Alert(AlertType.ERROR);
				 
				 alert.setContentText("Annual Return of Retire should between 0 and 0.03!");
				 
				 alert.showAndWait();
				 
				 return false;
			}
		} 
		
		catch (NumberFormatException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			
			 alert.setContentText("Annual Return of Retire is not valid!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		
		if (txtRequiredIncome.getText().isEmpty()) {
			
			 Alert alert = new Alert(AlertType.ERROR);
			 
			 alert.setContentText("Required Income is empty!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		try {
			
			Double.parseDouble(txtRequiredIncome.getText());
			
		} 
		
		catch (NumberFormatException e) {
			
		     Alert alert = new Alert(AlertType.ERROR);
			
			 alert.setContentText("Required Income is not valid!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		
		if (txtMonthlySSI.getText().isEmpty()) {
			
			 Alert alert = new Alert(AlertType.ERROR);
			 
			 alert.setContentText("Monthly SSI is empty!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		
		try {
			
			Double.parseDouble(txtMonthlySSI.getText());
			
		} 
		
		catch (NumberFormatException e) {
			
			 Alert alert = new Alert(AlertType.ERROR);
			
			 alert.setContentText("Monthly SSI is not valid!");
			 
			 alert.showAndWait();
			 
			 return false;
		}
		
		return true;
	}
	
}
