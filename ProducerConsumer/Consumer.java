
public class Consumer extends Thread{
	private int num ;
	private AbstractStorage abstractStorage ;
	
	public Consumer(AbstractStorage abstractStorage){
		this.abstractStorage = abstractStorage ;
	}
	
	public void setNum(int num){
		this.num = num ;
	}
	
	public void run(){
		while(true)
		consume(num) ;
	}
	
	public void consume(int num){
		abstractStorage.consume(num);
	}
}
