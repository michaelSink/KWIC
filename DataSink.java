
public class DataSink implements Runnable{

	Pipe in;

	protected void setIn(Pipe in){
		this.in = in;
	}

	@Override
	public void run() {
		while(true){
			if(in.hasData()){
				System.out.println(in.get());
			}else{
				try{
					Thread.sleep(5);
				}catch(Exception e){
					break;
				}
			}
		}
	}

}