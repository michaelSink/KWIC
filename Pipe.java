import java.util.ArrayList;

public class Pipe {

	private ArrayList<String> buffer;

	/*
		Input: None
		Output: this
		Purpose: Initilize buffer. 
	*/
	public Pipe(){
		buffer = new ArrayList<String>();
	}

	/*
		Input: None
		Output: String
		Purpose: Get String in buffer based on FIFO. 
	*/
	public String get(){
		return buffer.remove(buffer.size() - 1);
	}

	/*
		Input: String
		Output: None
		Purpose: Add data to buffer 
	*/
	public void add(String data){
		buffer.add(0, data);
	}

	/*
		Input: None
		Output: Boolean
		Purpose: Determine if buffer has data to process. 
	*/
	public boolean hasData(){
		return !buffer.isEmpty();
	}

}