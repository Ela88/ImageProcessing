/**
 * Pull Filter will read data from the pipeline and return the data
 */

package fhv.pipes_and_filters.abstracts.filter;

import fhv.pipes_and_filters.abstracts.pipe.PullPipe;
import fhv.pipes_and_filters.interfaces.Filter;

public abstract class PullFilter<OUT>implements Filter{
	
	protected PullPipe<OUT> _pipe;
	private boolean _outFinished = false;
	
	public PullFilter(PullPipe<OUT> pipe){
		_pipe = pipe;
	}
	
	public OUT read(){
		return process();
	}
	
	public abstract OUT process();

	public boolean is_outFinished() {
		return _outFinished;
	}

	public void set_outFinished(boolean _outFinished) {
		this._outFinished = _outFinished;
	}
}
