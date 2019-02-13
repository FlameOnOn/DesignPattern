
public class Producer extends Thread{
	private int num ; //每次要生产的数量
	
	private AbstractStorage abstractStorage ;// 所属仓库
	
	public Producer(AbstractStorage abstractStorage){
		this.abstractStorage = abstractStorage ;
	}
	
	public void setNum(int num){
		this.num = num ;
	}
	
	public void run(){
		while(true)
		produce(num) ;
	}
	
	public void produce(int num){
		abstractStorage.produce(num);
	}
}
