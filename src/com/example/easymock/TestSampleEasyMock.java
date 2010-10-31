package com.example.easymock;

import static org.junit.Assert.assertTrue;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

import com.example.common.Principal;

/**
 * @author hiperion
 */

public class TestSampleEasyMock extends Principal {

	
	private IMultiplicationService multiplicatorServiceMock;
	private CalculationManager calculationManager;

		
	@Before
	public void setUp() throws Exception {
		multiplicatorServiceMock = EasyMock
				.createMock(IMultiplicationService.class);
		calculationManager = new CalculationManager();
		calculationManager.setMultiplicatorService(multiplicatorServiceMock);
	}

	@Test
	public void testCalculationManager() {
		Integer oneProductPrice = 12;
		Integer amount = 3;
		Integer reduction = 6;

		// inject behaviour of MultiplicatorService
		EasyMock.expect(
				multiplicatorServiceMock.multiply(oneProductPrice, amount))
				.andReturn(oneProductPrice * amount);

		// setting up the mock
		EasyMock.replay(multiplicatorServiceMock);

		// object to be tested
		Integer result = calculationManager.calculatePrice(oneProductPrice,
				amount, reduction);

		log.info("Testing: oneProductPrice * amount - reduction");
		assertTrue("It's equal", result == oneProductPrice * amount - reduction);

		EasyMock.verify(multiplicatorServiceMock);

	}
}
