
public final class ThreadSafeSingleton {

	/*
	 * Ensures that the instance is never cached locally
	 */
	private static volatile ThreadSafeSingleton instance = null;

	private ThreadSafeSingleton() {

	}

	public static ThreadSafeSingleton getInstance() {
		
		if (instance == null) {
			/*
			 * Ensures that there wouldnt be race conditions
			 */
			synchronized(ThreadSafeSingleton.class) {
				instance = new ThreadSafeSingleton();
			}	
		}

		return instance;
	}

}