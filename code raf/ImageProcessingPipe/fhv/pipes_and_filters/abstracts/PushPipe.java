package fhv.pipes_and_filters.abstracts;

import fhv.pipes_and_filters.interfaces.Pipe;

public class PushPipe<IN>implements Pipe {
	
	protected PushFilter<IN> _filter;
	
	public PushPipe(PushFilter<IN> filter){
		_filter = filter;
	}
	
	public void write(IN in){
		if(_filter != null){
			_filter.write(in);
		}
	}	
}
