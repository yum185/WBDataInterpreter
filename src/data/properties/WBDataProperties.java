package data.properties;


public class WBDataProperties {

	public static int minByteLength = 10;

	public static short appId = 0x0001; 		// 对应 String 必填
	public static short clientType = 0x0002; 	// 对应 String 非必填
	public static short machineCode = 0x0003; 	// 对应 String 必填
	public static short timestamp = 0x0004; 	// 对应 Long 必填
	public static short payment = 0x0005; 		// 对应 Long 非必填
	public static short exitFlag = 0x0006; 		// 对应 Byte 必填
	public static short clientVersion = 0x0007; // 对应 String 非必填
	public static short clientChannel = 0x0008; // 对应 String 非必填
	public static short userId = 0x0009; 		// 对应 String 非必填
	public static short clientIp = 0x0010; 		// 对应 String 必填
	public static short deviceModel = 0x0011; 	// 对应 String 非必填
	public static short url = 0x0012; 			// 对应 String 非必填

	public static String getFieldName(short id) {
		String returnString = "";
		switch (id) {
		case 0x0001:
			returnString = "appId";
			break;
		case 0x0002:
			returnString = "clientType";
			break;
		case 0x0003:
			returnString = "machineCode";
			break;
		case 0x0004:
			returnString = "timestamp";
			break;
		case 0x0005:
			returnString = "payment";
			break;
		case 0x0006:
			returnString = "exitFlag";
			break;
		case 0x0007:
			returnString = "clientVersion";
			break;
		case 0x0008:
			returnString = "clientChannel";
			break;
		case 0x0009:
			returnString = "userId";
			break;
		case 0x0010:
			returnString = "clientIp";
			break;
		case 0x0011:
			returnString = "deviceModel";
			break;
		case 0x0012:
			returnString = "url";
			break;
		default:
			break;
		}
		return returnString;
	}
}
