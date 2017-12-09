package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class TestRetirement {

	@Test
	public void test() {
		int iYearsToWork = 40;
		double dAnnualReturnWorking = 0.07;
		int iYearsRetired = 20;
		double dAnnualReturnRetired = 0.02;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		
		Retirement retirement = new Retirement(iYearsToWork, dAnnualReturnWorking, iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
		
		assertEquals(1454485.55, retirement.TotalAmountSaved(), 0.01);
		assertEquals(554.13, retirement.AmountToSave(), 0.01);
	}

}
