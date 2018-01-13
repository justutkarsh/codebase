package concurrency;

public class SyncTest{


	public  synchronized void methodA(){
		while(true){

			System.out.println("executing A");
		}
	}

	public synchronized void methodB(){
		while(true){
			System.out.println("executing B");
		}
	}

	public static void main(String[] args) {

		final SyncTest st = new SyncTest();
		new Thread(new Runnable(){
                 public void run()
		{st.methodA();
		}}).start();
	
		new Thread(new Runnable(){
            public void run()
	{st.methodB();
	}}).start();
	
	}

        
}
