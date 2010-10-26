package com.example.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParametrizedJunitTest {

	private int operationType;
	private String dateFormat;

	public ParametrizedJunitTest(int operationType, String dateFormat) {
		super();
		this.operationType = operationType;
		this.dateFormat = dateFormat;
	}

	@Parameters
	public static Collection operationTypeValues() {

		return Arrays.asList(new Object[][] {
				{ DateFormatProvider.OPERATION_TYPE_1, "MMYY" },
				{ DateFormatProvider.OPERATION_TYPE_2, "YYMM" },
				{ DateFormatProvider.OPERATION_TYPE_3, "YYYYMM" } });
	}

	@Test
	public void verifyDateFormats() throws Exception {
		DateFormatProvider provider = new DateFormatProvider();

		String result = provider.getDateFormatFor(operationType);
		assertEquals(dateFormat, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verifyDateFormats_ShouldThrowIllegalArgumentException()
			throws Exception {
		DateFormatProvider provider = new DateFormatProvider();

		provider.getDateFormatFor(-1);
	}
}
