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
	private TextField txtWorkReturn;
	@FXML
	private TextField txtYearsToRetire;
	@FXML
	private TextField txtRetireReturn;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtSSI;
	@FXML
	private Label monthSaveLabel;
	@FXML
	private Label totalSaveLabel;
	

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
		txtRetireReturn.clear();
		txtSSI.clear();
		txtWorkReturn.clear();
		txtYearsToRetire.clear();
		txtYearsToWork.clear();
		monthSaveLabel.setText("");
		totalSaveLabel.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		if (!validate()) {
			return;
		}
		Retirement retirement = new Retirement(Integer.parseInt(txtYearsToWork.getText()), Double.parseDouble(txtWorkReturn.getText())
				, Integer.parseInt(txtYearsToRetire.getText()), Double.parseDouble(txtRetireReturn.getText()), Double.parseDouble(txtRequiredIncome.getText())
				, Double.parseDouble(txtSSI.getText()));
		totalSaveLabel.setText("$ "+String.format("%.2f",retirement.TotalAmountSaved()));
		monthSaveLabel.setText("$ "+String.format("%.2f",retirement.AmountToSave()));
	}
	
	private boolean validate(){
		if (txtWorkReturn.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of work can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			double workReturn = Double.parseDouble(txtWorkReturn.getText());
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
		
		if (txtYearsToRetire.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to retire can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Integer.parseInt(txtYearsToRetire.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Years to retire must be a valid integer!");
			 _alert.show();
			 return false;
		}
		
		if (txtRetireReturn.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Annual Return of retire can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			double retireReturn = Double.parseDouble(txtRetireReturn.getText());
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
		
		if (txtSSI.getText().isEmpty()) {
			 Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Monthly SSI can not be empty!");
			 _alert.show();
			 return false;
		}
		try {
			Double.parseDouble(txtSSI.getText());
		} catch (NumberFormatException e) {
			Alert _alert = new Alert(Alert.AlertType.INFORMATION);
			 _alert.setContentText("Monthly SSI must be a valid number!");
			 _alert.show();
			 return false;
		}
		
		return true;
	}
	
}
