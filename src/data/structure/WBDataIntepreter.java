package data.structure;
import interfaces.WBDataInterface;

public class WBDataIntepreter implements WBDataInterface {

	private boolean inputValid = false ;
	private WBDataContainer dataContainer;
	
	public void processByteArray(byte[] byteArray){
		this.dataContainer = new WBDataContainer(byteArray);
		this.inputValid = true;
	}
	
	public Object getDataByField(short tagId) { 
		if(inputValid)
			return this.dataContainer.removePacket(tagId); 
		else
			return false;
	}  
	
	public WBDataContainer getDataContainer(){
		return this.dataContainer;
	}
	
}
