package uk.co.probablyfine.dirty.utils;

public class Exceptions {

	public static class StoreException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public StoreException(Throwable cause) {
			super(cause);
		}
	}

	public interface ExceptionalSupplier<T, E extends Exception> {
		T get() throws E;
	}

	public interface ExceptionalVoid<E extends Exception> {
		void call() throws E;
	}

	public static <T, E extends Exception> T unchecked(ExceptionalSupplier<T, E> supplier) {
		try {
			return supplier.get();
		} catch (Exception e) {
			throw new StoreException(e);
		}
	}

	public static <E extends Exception> void unchecked(ExceptionalVoid<E> supplier) {
		try {
			supplier.call();
		} catch (Exception e) {
			throw new StoreException(e);
		}
	}
}
