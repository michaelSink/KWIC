abstract class Filter implements Runnable{

	Pipe in, out;

	/*
		Input: Pipe
		Output: None
		Purpose: Setting for in Pipe 
	*/
	protected void setIn(Pipe in){
		this.in = in;
	}

	/*
		Input: Pipe
		Output: None
		Purpose: Setting for out Pipe 
	*/
	protected void setOut(Pipe out){
		this.out = out;
	}


	/*
		Input: None
		Output: Stirng
		Purpose: Constantly poll from in Pipe, and
					return data received. 
	*/
	protected String pull(){
		while(true){
			if(in.hasData()){
				return in.get();
			}else{
				try{
					Thread.sleep(5);
				}catch(Exception e){}
			}
		}

	}

	/*
		Input: String
		Output: None
		Purpose: Add passed data to buffer. 
	*/
	protected void write(String data){
		out.add(data);
	}

}