package data.structure; 

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;
import data.properties.WBDataProperties;
import exceptions.LengthTooShortException;
import exceptions.MissingAppIdException;
import exceptions.MissingClientIpException;
import exceptions.MissingExitFlagException;
import exceptions.MissingMachineCodeException;
import exceptions.MissingTimestampException;
import tools.DataInterconversionTool;

public class WBDataContainer implements Serializable {

	private static final long serialVersionUID = -6148441761784573039L;
	private Vector<DataPacket> packetList = new Vector<DataPacket>(); 

	public WBDataContainer(byte[] byteData) { 
		int RemainingLength = byteData.length;
		if (RemainingLength <= WBDataProperties.minByteLength) {
			try {
				throw new LengthTooShortException();
			} catch (LengthTooShortException e) {
				e.printStackTrace();
			}
		} 
		int index = 0;
		while(RemainingLength>0){  
			DataPacket  dataPacket = new DataPacket(); 
			byte[] byte2Array = new byte[2]; 
			byte[] byte4Array = new byte[4]; 
			byte2Array[0] = byteData[index++];
			byte2Array[1] = byteData[index++];
			dataPacket.setMainVerNumber(DataInterconversionTool.bytesToShort(byte2Array));
			byte2Array[0] = byteData[index++];
			byte2Array[1] = byteData[index++];
			dataPacket.setSecondVerNumber(DataInterconversionTool.bytesToShort(byte2Array));
			byte2Array[0] = byteData[index++];
			byte2Array[1] = byteData[index++];
			dataPacket.setCategory( DataInterconversionTool.bytesToShort(byte2Array));
			byte4Array[0] = byteData[index++];
			byte4Array[1] = byteData[index++];
			byte4Array[2] = byteData[index++];
			byte4Array[3] = byteData[index++];
			dataPacket.setBodySize(DataInterconversionTool.bytesToInt(byte4Array));
			int tempSize = dataPacket.getBodySize(); 
			HashMap<Short, Object> objectMap = new HashMap<Short, Object>(); 
			while (tempSize > 0) {
				byte2Array[0] = byteData[index++];
				byte2Array[1] = byteData[index++];
				Short tag = DataInterconversionTool.bytesToShort(byte2Array);
				byte2Array[0] = byteData[index++];
				byte2Array[1] = byteData[index++];
				if( tag == WBDataProperties.timestamp || tag == WBDataProperties.payment ){ 
					short length = DataInterconversionTool.bytesToShort(byte2Array);
					byte[] vBytes = new byte[length];
					System.arraycopy(byteData, index, vBytes, 0, length);
					long value = DataInterconversionTool.bytesToLong(vBytes);
					objectMap .put(tag, value);
					tempSize -= (4 + length);
					index += length;
				}
				else if( tag == WBDataProperties.exitFlag ){ 
					short length = DataInterconversionTool.bytesToShort(byte2Array);
					byte[] vBytes = new byte[length];
					System.arraycopy(byteData, index, vBytes, 0, length);
					byte value = vBytes[0];
					objectMap.put(tag, value); 
					tempSize -= (4 + length);
					index += length;
				}
				else { 
					short length = DataInterconversionTool.bytesToShort(byte2Array);
					byte[] vBytes = new byte[length];
					System.arraycopy(byteData, index, vBytes, 0, length);
					String value = DataInterconversionTool.bytesToString(vBytes);
					objectMap.put(tag, value);
					tempSize -= (4 + length);
					index += length;
				}
			}
			checkRequiredFields(objectMap);
			RemainingLength = RemainingLength -10 - dataPacket.getBodySize();
			dataPacket.setBodyMap(objectMap);
			packetList.add(dataPacket); 
		}
	}

	private void checkRequiredFields(HashMap<Short, Object> map) {
		if (!map.containsKey(WBDataProperties.appId)) {
			try {
				throw new MissingAppIdException();
			} catch (MissingAppIdException e) {
				e.printStackTrace();
			}
		} else if (!map.containsKey(WBDataProperties.clientIp)) {
			try {
				throw new MissingClientIpException();
			} catch (MissingClientIpException e) {
				e.printStackTrace();
			}
		} else if (!map.containsKey(WBDataProperties.machineCode)) {
			try {
				throw new MissingMachineCodeException();
			} catch (MissingMachineCodeException e) {
				e.printStackTrace();
			}
		} else if (!map.containsKey(WBDataProperties.exitFlag)) {
			try {
				throw new MissingExitFlagException();
			} catch (MissingExitFlagException e) {
				e.printStackTrace();
			}
		} else if (!map.containsKey(WBDataProperties.timestamp)) {
			try {
				throw new MissingTimestampException();
			} catch (MissingTimestampException e) {
				e.printStackTrace();
			}
		}
	}
 
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(DataPacket packet : packetList){  
			sb.append("版本号:");
			sb.append(packet.getMainVerNumber() + ".");
			sb.append(packet.getSecondVerNumber());
			sb.append(System.lineSeparator());
			sb.append("Category:");
			sb.append(packet.getCategory());
			sb.append(System.lineSeparator());
			sb.append("Body size:");
			sb.append(packet.getBodySize());
			sb.append(System.lineSeparator());
			for (Entry<Short, Object> entry : packet.getBodyMap().entrySet()) {
				sb.append("Tag:");
				sb.append(WBDataProperties.getFieldName(entry.getKey()));
				sb.append(" , ");
				sb.append("Value:");
				sb.append(entry.getValue());
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

	public Vector<DataPacket> getpacketList() {
		return this.packetList;
	}
	
	public Object removePacket(short tag) {
		if(this.packetList.isEmpty())
			return null;
		else{
			 Object object = null;
			for (DataPacket entry : packetList) { 
				if(entry.getBodyMap().containsKey(tag)){ 
					object = entry.getBodyMap().get(tag);
					packetList.remove(entry); 
					break;
				}
			} 
			return object;
		} 
	} 

}
