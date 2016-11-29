package com.generallycloud.nio.common;

import java.util.UUID;

public class UUIDGenerator {

	
	public static String random(){
		
		UUID uuid = UUID.randomUUID();
		
		long mostSigBits = uuid.getMostSignificantBits();
		long leastSigBits = uuid.getLeastSignificantBits();
		
		return new StringBuilder()
			.append(digits(mostSigBits >> 32, 8))
			.append(digits(mostSigBits >> 16, 4))
			.append(digits(mostSigBits, 4))
			.append(digits(leastSigBits >> 48, 4))
			.append(digits(leastSigBits, 12))
			.toString();
	}
	
	private static String digits(long val, int digits) {
		long hi = 1L << (digits * 4);
		return Long.toHexString(hi | (val & (hi - 1))).substring(1);
	}
	
}
