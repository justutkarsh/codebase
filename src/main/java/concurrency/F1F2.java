package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FunctionSequencer {
	Boolean f1ran = false;


	public synchronized void f1() throws InterruptedException {
		while (f1ran == true)
			wait();
		System.out.println("running f1");
		f1ran = true;
		System.out.println("exiting f1");
		notifyAll();
	}

	public synchronized void f2() throws InterruptedException {
		
		System.out.println("running f2");
		f1ran = false;
		System.out.println("exiting f2");
		while (f1ran == true)
			wait();
		notifyAll();
	}
}

class Runf1 implements Runnable {
	FunctionSequencer fs;

	public Runf1(FunctionSequencer fs) {
		this.fs = fs;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				fs.f1();
				TimeUnit.MILLISECONDS.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exiting via interrupt");
		}
		// TODO Auto-generated method stub

	}

}

class Runf2 implements Runnable {
	FunctionSequencer fs;

	public Runf2(FunctionSequencer fs) {
		this.fs = fs;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				fs.f2();
				TimeUnit.MILLISECONDS.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exiting via interrupt");
		}
		// TODO Auto-generated method stub
	}
}

public class F1F2 {
	public static void main(String[] args) throws Exception {
		FunctionSequencer fs = new FunctionSequencer();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Runf1(fs));
		exec.execute(new Runf2(fs));
		TimeUnit.SECONDS.sleep(2);
		System.out.println("exiting F1F2");
		exec.shutdownNow();

	}

}
