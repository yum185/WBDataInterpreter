package data.structure;

import java.util.HashMap;

public class DataPacket {
	
	private short mainVerNumber ;
	private short secondVerNumber ;
	private short category ;
	private int bodySize ;
	private HashMap<Short, Object> bodyMap = new HashMap<Short, Object>();
	
	public short getMainVerNumber() {
		return mainVerNumber;
	}
	public void setMainVerNumber(short mainVerNumber) {
		this.mainVerNumber = mainVerNumber;
	}
	public int getBodySize() {
		return bodySize;
	}
	public void setBodySize(int bodySize) {
		this.bodySize = bodySize;
	}
	public short getSecondVerNumber() {
		return secondVerNumber;
	}
	public void setSecondVerNumber(short secondVerNumber) {
		this.secondVerNumber = secondVerNumber;
	}
	public short getCategory() {
		return category;
	}
	public void setCategory(short category) {
		this.category = category;
	}
	public HashMap<Short, Object> getBodyMap() {
		return bodyMap;
	}
	public void setBodyMap(HashMap<Short, Object> bodyMap) {
		this.bodyMap = bodyMap;
	}
	
}
