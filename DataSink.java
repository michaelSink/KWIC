
public class DataSink implements Runnable, finalOutput{

	protected Pipe in;
	private String output = "";

	/*
		Input: Pipe
		Output: None
		Purpose: Setter for the in pipe
	*/
	protected void setIn(Pipe in){
		this.in = in;
	}

	/*
		Input: None
		Output: None
		Purpose: Constantly polls from in pipe, and
					writes output to storing variable. 
	*/
	@Override
	public void run() {
		while(true){
			if(in.hasData()){
				String data = in.get();
				if(data != null){
					output += data + "\n";
				}
			}else{
				try{
					Thread.sleep(5);
				}catch(Exception e){
					break;
				}
			}
		}
	}

	/*
		Input: None
		Output: String
		Purpose: Return final output from previous transformations. 
	*/
	@Override
	public String getOuput() {
		return output;
	}

	/*
		Input: None
		Output: None
		Purpose: Reset output variable.
	*/
	@Override
	public void resetOutput() {
		this.output = "";
	}

}