/**
 * Push filter will write data into the next pipe
 */

package fhv.pipes_and_filters.abstracts;

import fhv.pipes_and_filters.interfaces.Filter;

public abstract class PushFilter<IN> implements Filter {
	
	protected PushPipe<IN> _pipe;
	protected boolean _outFinished = false;
	
	public PushFilter(PushPipe<IN> pipe){
		_pipe = pipe;
	}
	
	public void write(IN in){
		process(in);
	}
	
	public abstract void process(IN in);
}
