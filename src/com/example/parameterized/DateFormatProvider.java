package com.example.parameterized;

public class DateFormatProvider {

	public static final int OPERATION_TYPE_1 = 1;
	
	public static final int OPERATION_TYPE_2 = 2;
	
	public static final int OPERATION_TYPE_3 = 3;

	public String getDateFormatFor(int operationType) 
		throws IllegalArgumentException {

		switch (operationType) {
			case OPERATION_TYPE_1: {
				return "MMYY";
			}
			case OPERATION_TYPE_2: {
				return "YYMM";
			}
			case OPERATION_TYPE_3: {
				return "YYYYMM";
			}
			default: {
				throw new IllegalArgumentException("Unknown operation type");
			}
		}
	}
}
