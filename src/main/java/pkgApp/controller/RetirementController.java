package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturnWork;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private TextField txtSaveEachMonth;
	@FXML
	private TextField txtNeedToSave;
	

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
		txtRequiredIncome.clear();
		txtAnnualReturnRetired.clear();
		txtMonthlySSI.clear();
		txtAnnualReturnWork.clear();
		txtYearsRetired.clear();
		txtYearsToWork.clear();
		txtSaveEachMonth.setText("");
		txtNeedToSave.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		if (!validate()) {
			return;
		}
		Retirement retirement = new Retirement(Integer.parseInt(txtYearsToWork.getText()), Double.parseDouble(txtAnnualReturnWork.getText())
				, Integer.parseInt(txtYearsRetired.getText()), Double.parseDouble(txtAnnualReturnRetired.getText()), Double.parseDouble(txtRequiredIncome.getText())
				, Double.parseDouble(txtMonthlySSI.getText()));
		txtNeedToSave.setText("$ "+String.format("%.2f",retirement.TotalAmountSaved()));
		txtSaveEachMonth.setText("$ "+String.format("%.2f",retirement.AmountToSave()));
	}
	
	private boolean validate(){
		if (txtAnnualReturnWork.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of work can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			double workReturn = Double.parseDouble(txtAnnualReturnWork.getText());
			if (workReturn<0||workReturn>0.2) {
				Alert _alert = new Alert(Alert.AlertType.INFORMATION);
				 _alert.setContentText("Annual Return of work must between 0 and 0.2!");
				 _alert.show();
				 return false;
			}
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of work must be a valid number!");
			 _alert.show();
			 return false;
		}
		
		if (txtYearsToWork.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to work can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Integer.parseInt(txtYearsToWork.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to work must be a valid integer!");
			 _alert.show();
			 return false;
		}
		
		if (txtYearsRetired.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to retire can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Integer.parseInt(txtYearsRetired.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to retire must be a valid integer!");
			 _alert.show();
			 return false;
		}
		
		if (txtAnnualReturnRetired.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of retire can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			double retireReturn = Double.parseDouble(txtAnnualReturnRetired.getText());
			if (retireReturn<0||retireReturn>0.03) {
				Alert _alert = new Alert(Alert.AlertType.INFORMATION);
				 _alert.setContentText("Annual Return of retire must between 0 and 0.03!");
				 _alert.show();
				 return false;
			}
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of retire must be a valid number!");
			 _alert.show();
			 return false;
		}
		
		if (txtRequiredIncome.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Required Income can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(txtRequiredIncome.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Required Income must be a valid number!");
			 _alert.show();
			 return false;
		}
		
		if (txtMonthlySSI.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Monthly SSI can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(txtMonthlySSI.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Monthly SSI must be a valid number!");
			 _alert.show();
			 return false;
		}
		
		return true;
	}
	
}
