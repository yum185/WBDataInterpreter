package test;

import data.properties.WBDataProperties;
import data.structure.WBDataIntepreter;
import exceptions.LengthTooShortException;
import tools.DataInterconversionTool;

public class TestMain {

	public static void main(String[] args) throws LengthTooShortException {

		short mainVerNumber;
		short secondVerNumber;
		short category;
		mainVerNumber = 142;
		secondVerNumber = 422;
		category = 5124;
		String appId = "newfoundland";
		String clientType = "android";

		String machinecode = "k123abc321";
		Long timestamp = System.currentTimeMillis();
		Long payment = 8888L;
		Byte exitFlag = 1;
		String clientVersion = "alpha";
		String clientChannel = "sampa";
		String userId = "infamous";
		String clientIp = "123.123.123.123";
		String deviceModel = "leo";
		String url = "www.baidu.com";

		byte[] b1 = DataInterconversionTool.shortToBytes(mainVerNumber);
		byte[] b2 = DataInterconversionTool.shortToBytes(secondVerNumber);
		byte[] b3 = DataInterconversionTool.shortToBytes(category);
		byte[] b4 = DataInterconversionTool.stringToBytes(appId);
		byte[] b5 = DataInterconversionTool.stringToBytes(clientType);
		byte[] b6 = DataInterconversionTool.stringToBytes(machinecode);
	 	byte[] b7 = DataInterconversionTool.longToBytes(timestamp);
	 	byte[] b8 = DataInterconversionTool.longToBytes(payment);
		byte[] b9 = new byte[1];
		b9[0]=	exitFlag ;
	 
		byte[] b10 = DataInterconversionTool.stringToBytes(clientVersion);
		byte[] b11 = DataInterconversionTool.stringToBytes(clientChannel);
		byte[] b12 = DataInterconversionTool.stringToBytes(userId);
		byte[] b13 = DataInterconversionTool.stringToBytes(clientIp);
		byte[] b14 = DataInterconversionTool.stringToBytes(deviceModel);
		byte[] b15 = DataInterconversionTool.stringToBytes(url);

		byte[] b4Length = DataInterconversionTool.shortToBytes((short) b4.length);
		byte[] b5Length = DataInterconversionTool.shortToBytes((short) b5.length);
		byte[] b6Length = DataInterconversionTool.shortToBytes((short) b6.length);
		byte[] b7Length = DataInterconversionTool.shortToBytes((short) b7.length);
		byte[] b8Length = DataInterconversionTool.shortToBytes((short) b8.length);
		byte[] b9Length = DataInterconversionTool.shortToBytes((short) b9.length);
		byte[] b10Length = DataInterconversionTool.shortToBytes((short) b10.length);
		byte[] b11Length = DataInterconversionTool.shortToBytes((short) b11.length);
		byte[] b12Length = DataInterconversionTool.shortToBytes((short) b12.length);
		byte[] b13Length = DataInterconversionTool.shortToBytes((short) b13.length);
		byte[] b14Length = DataInterconversionTool.shortToBytes((short) b14.length);
		byte[] b15Length = DataInterconversionTool.shortToBytes((short) b15.length); 
		
		byte[] b4Heading = DataInterconversionTool.shortToBytes(WBDataProperties.appId);
		byte[] b5Heading = DataInterconversionTool.shortToBytes(WBDataProperties.clientType);
		byte[] b6Heading = DataInterconversionTool.shortToBytes(WBDataProperties.machineCode); 
		byte[] b7Heading = DataInterconversionTool.shortToBytes(WBDataProperties.timestamp);
		byte[] b8Heading = DataInterconversionTool.shortToBytes(WBDataProperties.payment);
		byte[] b9Heading = DataInterconversionTool.shortToBytes(WBDataProperties.exitFlag); 
		byte[] b10Heading = DataInterconversionTool.shortToBytes(WBDataProperties.clientVersion);
		byte[] b11Heading = DataInterconversionTool.shortToBytes(WBDataProperties.clientChannel);
		byte[] b12Heading = DataInterconversionTool.shortToBytes(WBDataProperties.userId); 
		byte[] b13Heading = DataInterconversionTool.shortToBytes(WBDataProperties.clientIp);
		byte[] b14Heading = DataInterconversionTool.shortToBytes(WBDataProperties.deviceModel);
		byte[] b15Heading = DataInterconversionTool.shortToBytes(WBDataProperties.url);

		byte[] body = new byte[b4Heading.length + b4Length.length + b4.length + b5Heading.length + b5Length.length
				+ b5.length + b6Heading.length + b6Length.length + b6.length + b7Heading.length + b7Length.length
				+ b7.length + b8Heading.length + b8Length.length + b8.length + b9Heading.length + b9Length.length
				+ b9.length + b10Heading.length + b10Length.length + b10.length + b11Heading.length + b11Length.length
				+ b11.length + b12Heading.length + b12Length.length + b12.length + b13Heading.length + b13Length.length
				+ b13.length + b14Heading.length + b14Length.length + b14.length + b15Heading.length + b15Length.length
				+ b15.length];
		int length = 0   ;
		System.arraycopy(b4Heading, 0, body, length, b4Heading.length); 
		length+=b4Heading.length;
		System.arraycopy(b4Length, 0, body, length, b4Length.length);
		length += b4Length.length;
		System.arraycopy(b4, 0, body, length, b4.length);
		length += b4.length;
		System.arraycopy(b5Heading, 0, body, length, b5Heading.length);
		length += b5Heading.length;
		System.arraycopy(b5Length, 0, body, length, b5Length.length);
		length += b5Length.length;
		System.arraycopy(b5, 0, body, length, b5.length);
		length += b5.length;
		System.arraycopy(b6Heading, 0, body, length, b6Heading.length);
		length += b6Heading.length;
		System.arraycopy(b6Length, 0, body, length, b6Length.length);
		length += b6Length.length;
		System.arraycopy(b6, 0, body, length, b6.length);
		length += b6.length;

		System.arraycopy(b7Heading, 0, body, length, b7Heading.length);
		length += b6Heading.length;
		System.arraycopy(b7Length, 0, body, length, b7Length.length);
		length += b7Length.length;
		System.arraycopy(b7, 0, body, length, b7.length);
		length += b7.length;

		System.arraycopy(b8Heading, 0, body, length, b8Heading.length);
		length += b6Heading.length;
		System.arraycopy(b8Length, 0, body, length, b8Length.length);
		length += b8Length.length;
		System.arraycopy(b8, 0, body, length, b8.length);
		length += b8.length;

		System.arraycopy(b9Heading, 0, body, length, b9Heading.length);
		length += b6Heading.length;
		System.arraycopy(b9Length, 0, body, length, b9Length.length);
		length += b9Length.length;
		System.arraycopy(b9, 0, body, length, b9.length);
		length += b9.length;

		System.arraycopy(b10Heading, 0, body, length, b10Heading.length);
		length += b6Heading.length;
		System.arraycopy(b10Length, 0, body, length, b10Length.length);
		length += b10Length.length;
		System.arraycopy(b10, 0, body, length, b10.length);
		length += b10.length;

		System.arraycopy(b11Heading, 0, body, length, b11Heading.length);
		length += b6Heading.length;
		System.arraycopy(b11Length, 0, body, length, b11Length.length);
		length += b11Length.length;
		System.arraycopy(b11, 0, body, length, b11.length);
		length += b11.length;

		System.arraycopy(b12Heading, 0, body, length, b12Heading.length);
		length += b6Heading.length;
		System.arraycopy(b12Length, 0, body, length, b12Length.length);
		length += b12Length.length;
		System.arraycopy(b12, 0, body, length, b12.length);
		length += b12.length;

		System.arraycopy(b13Heading, 0, body, length, b13Heading.length);
		length += b6Heading.length;
		System.arraycopy(b13Length, 0, body, length, b13Length.length);
		length += b13Length.length;
		System.arraycopy(b13, 0, body, length, b13.length);
		length += b13.length;

		System.arraycopy(b14Heading, 0, body, length, b14Heading.length);
		length += b6Heading.length;
		System.arraycopy(b14Length, 0, body, length, b14Length.length);
		length += b14Length.length;
		System.arraycopy(b14, 0, body, length, b14.length);
		length += b14.length;

		System.arraycopy(b15Heading, 0, body, length, b15Heading.length);
		length += b6Heading.length;
		System.arraycopy(b15Length, 0, body, length, b15Length.length);
		length += b15Length.length;
		System.arraycopy(b15, 0, body, length, b15.length);
		length += b15.length;

		byte[] bSize = DataInterconversionTool.intToBytes(body.length);

		byte[] btotal = new byte[b1.length + b2.length + b3.length + bSize.length + body.length];
		length = 0;
		System.arraycopy(b1, 0, btotal, length, b1.length);
		length += b1.length;
		System.arraycopy(b2, 0, btotal, length, b2.length);
		length += b2.length;
		System.arraycopy(b3, 0, btotal, length, b3.length);
		length += b3.length;
		System.arraycopy(bSize, 0, btotal, length, bSize.length);
		length += bSize.length;
		System.arraycopy(body, 0, btotal, length, body.length);
		length += body.length;
		
		byte[] btotal2 = new byte[btotal.length*2];
		System.out.println("length " + btotal.length);
		System.arraycopy(btotal, 0, btotal2, 0, btotal.length);
		System.arraycopy(btotal, 0, btotal2, btotal.length, btotal.length);

		WBDataIntepreter wbDataIntepreter = new WBDataIntepreter();
	  	wbDataIntepreter.processByteArray(btotal2); 
	  	System.out.println(wbDataIntepreter.getDataContainer().toString());
		System.out.println(wbDataIntepreter.getDataByField(WBDataProperties.clientChannel));
		System.out.println(wbDataIntepreter.getDataContainer().toString());
	}

}
