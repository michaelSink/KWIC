
public class DataSource implements Runnable{

	inputTransfer transfer;

	private String line;
	protected Pipe out;

	/*
		Input: Pipe
		Output: None
		Purpose: Setting for out pipe 
	*/
	protected void setOut(Pipe out){
		this.out = out;
	}

	/*
		Input: inputTransfer
		Output: this
		Purpose: Initialize inputTransfer. 
	*/
	public DataSource(inputTransfer transfer) {
		this.transfer = transfer;
	}

	/* 
		Input: None
		Output: None
		Purpose: Constantly poll from inputTransfer interface,
					and send data to out Pipe.
	*/
	@Override
	public void run() {
		try{
			while(true){
				this.line = transfer.getLine();
				if(!line.isEmpty()){
					String[] inputData = line.split("\n");
					for(int i = 0; i < inputData.length; i++){
						out.add(inputData[i]);
					}
					out.add(null);
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}