import java.util.ArrayList;

public class Pipe {

	private ArrayList<String> buffer = new ArrayList<String>();

	public String get(){
		return buffer.remove(0);
	}

	public void add(String data){
		buffer.add(data);
	}

	public boolean hasData(){
		return !buffer.isEmpty();
	}

}