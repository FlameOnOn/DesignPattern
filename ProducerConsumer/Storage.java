
import java.util.LinkedList;

public class Storage implements AbstractStorage{
	
	private final int MAX_SIZE = 100 ;//仓库最大容量
	private LinkedList list = new LinkedList() ; // 仓库存储的载体
	
	

	@Override
	public void consume(int num) {
		synchronized(list){
			System.out.println(Thread.currentThread().getName() + " got lock----------------") ;
			while(list.size() < num){
				System.out.println(Thread.currentThread().getName() +"【要消费的产品数量】:" + num + "\t【库存量】:"+ list.size() + "\t暂时不能执行消费任务!");
				try{
					System.out.println(Thread.currentThread().getName() + " enter wait----------------") ;
					list.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " wake up----------------") ;
			for(int i = 0 ; i < num ; i++){
				list.remove() ;
			}
			
			System.out.println(Thread.currentThread().getName() +"【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size()) ;
			
			System.out.println(Thread.currentThread().getName() +"notify all") ;
			list.notifyAll();
		}
	}

	@Override
	public void produce(int num) {
		synchronized(list){
			System.out.println(Thread.currentThread().getName() + " got lock----------------") ;
			while(list.size() + num > MAX_SIZE){
				System.out.println(Thread.currentThread().getName() +"[要生产的产品数量]" + num + "\t[库存量]:" + list.size() + "\t暂时不能执行生产任务!") ;
				try{
					System.out.println(Thread.currentThread().getName() + " enter wait----------------") ;
					//生产阻塞
					list.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " wake up----------------") ;
			for(int i = 0 ; i < num ; i++){
				list.add(new Object()) ;
			}
			
			System.out.println(Thread.currentThread().getName() +"【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size()) ;
			System.out.println(Thread.currentThread().getName() +"notify all") ;
			list.notifyAll();
		}
	}
	
}
