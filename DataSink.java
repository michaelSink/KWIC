
public class DataSink implements Runnable{

	Pipe out;

	@Override
	public void run() {
		while(true){
			if(out.hasData()){
				System.out.println(out.get());
			}
		}
	}

}