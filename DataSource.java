import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DataSource implements Runnable{

	protected Pipe out;
	private BufferedReader dataSource;
	
	public DataSource() {
		dataSource = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void run() {
		try{
			String data;
			while(true){
				data = dataSource.readLine();
				if(data == null || data.isEmpty()){
					break;
				}
				out.add(data);
			}
		}catch(Exception e){}
	}
	
}