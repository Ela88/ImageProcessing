package fhv.pipes_and_filters.abstracts;

public abstract class PullPipe<OUT>{
	
	protected PullFilter<OUT> _filter;
	
	public PullPipe(PullFilter<OUT> filter){
		_filter = filter;
	}
	
	public OUT read(){
		return _filter.read();
	}
}
