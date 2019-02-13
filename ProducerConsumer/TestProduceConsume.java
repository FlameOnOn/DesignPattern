
public class TestProduceConsume {
	
	public static void main(String args[]){
		//仓库对象
		AbstractStorage abstractStorage = new Storage() ;
		
		//生产者对象
		Producer p1 = new Producer(abstractStorage) ;
		Producer p2 = new Producer(abstractStorage) ;
		Producer p3 = new Producer(abstractStorage) ;
		Producer p4 = new Producer(abstractStorage) ;
		Producer p5 = new Producer(abstractStorage) ;
		
		//消费者对象
		Consumer c1 = new Consumer(abstractStorage) ;
		Consumer c2 = new Consumer(abstractStorage) ;
		Consumer c3 = new Consumer(abstractStorage) ;
		
		
		p1.setNum(10);
		p2.setNum(10);
		p3.setNum(10);
		p4.setNum(10);
		p5.setNum(10);
		
		c1.setNum(50);
		c2.setNum(20);
		c3.setNum(30);
		
		p1.setName("p1");
		p2.setName("p2");
		p3.setName("p3");
		p4.setName("p4");
		p5.setName("p5");
		
		c1.setName("c1");
		c2.setName("c2");
		c3.setName("c3");
		
		c1.start();
		c2.start();
		c3.start();
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		
		}
	
}
