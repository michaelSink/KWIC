import java.util.ArrayList;

public class Pipe {

	private ArrayList<String> buffer;

	public Pipe(){
		buffer = new ArrayList<String>();
	}

	public String get(){
		return buffer.remove(buffer.size() - 1);
	}

	public void add(String data){
		buffer.add(data);
	}

	public boolean hasData(){
		return !buffer.isEmpty();
	}

}