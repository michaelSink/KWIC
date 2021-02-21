abstract class Filter implements Runnable{

	Pipe in, out;

	protected void setIn(Pipe in){
		this.in = in;
	}

	protected void setOut(Pipe out){
		this.out = out;
	}


	protected String pull(){
		while(true){
			if(in.hasData()){
				return in.get();
			}
		}
	}

	protected void write(String data){
		out.add(data);
	}

}