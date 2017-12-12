package pkgCore;


public class Retirement {

	private int iYearsToWork;
	
	private int iYearsRetired;
	
	private double dAnnualReturnWorking;
	
	private double dAnnualReturnRetired;
	
	private double dRequiredIncome;
	
	private double dMonthlySSI;
	
	
	
	public int getiYearsToWork() {
		
		return iYearsToWork;
	}

	public void setiYearsToWork(int iYearsToWork) {
		
		this.iYearsToWork = iYearsToWork;
	}

	public double getdAnnualReturnWorking() {
		
		return dAnnualReturnWorking;
	}

	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	public int getiYearsRetired() {
		
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		
		return dAnnualReturnRetired;
	}

	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	public double getdRequiredIncome() {
		
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		
		this.dMonthlySSI = dMonthlySSI;
	}
	
	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI) {
		
		super();
		
		this.iYearsToWork = iYearsToWork;
		
		this.iYearsRetired = iYearsRetired;
		
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		
		this.dRequiredIncome = dRequiredIncome;
		
		this.dMonthlySSI = dMonthlySSI;
	}
	
	public double AmountToSave()
	{
		
		double returnVal = 0;
		
		if (dAnnualReturnWorking / 12 == 0) {
			
			returnVal = TotalAmountSaved() / iYearsToWork * 12;	
	    }
		
		else {
			
	    	returnVal = (dAnnualReturnWorking / 12) * TotalAmountSaved()
	                  /(Math.pow((dAnnualReturnWorking / 12) + 1, iYearsToWork * 12) - 1);
		}
		
		return returnVal;
	}
	

	public double TotalAmountSaved()
	{
		
		
		double returnVal = 0;
		
		if ((dAnnualReturnRetired / 12) == 0) {
			
			returnVal = iYearsRetired * (dRequiredIncome - dMonthlySSI);
		}
		
		else {
			
			returnVal = ((Math.pow((dAnnualReturnRetired / 12) + 1,(12 * iYearsRetired)) - 1) / (dAnnualReturnRetired / 12))
					 / Math.pow((dAnnualReturnRetired / 12) + 1, (12 * iYearsRetired)) * (dRequiredIncome - dMonthlySSI);
		}
		return returnVal;
	}
}
