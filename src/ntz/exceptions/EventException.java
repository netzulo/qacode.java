/**
 * 
 */
package ntz.exceptions;
/**
* @author netzulo.com
* @since 2016-08-06
* @version 0.5.7
* 
* <p></p>
* <p></p>
* <p></p>
*/
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author jgarcia
 *
 */
public class EventException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -943761282020893183L;

	/**
	 * 
	 */
	public EventException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public EventException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public EventException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EventException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EventException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		// TODO Auto-generated method stub
		return super.fillInStackTrace();
	}

	@Override
	public synchronized Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}

	@Override
	public String getLocalizedMessage() {
		// TODO Auto-generated method stub
		return super.getLocalizedMessage();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		// TODO Auto-generated method stub
		return super.getStackTrace();
	}

	@Override
	public synchronized Throwable initCause(Throwable cause) {
		// TODO Auto-generated method stub
		return super.initCause(cause);
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}

	@Override
	public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	@Override
	public void setStackTrace(StackTraceElement[] stackTrace) {
		// TODO Auto-generated method stub
		super.setStackTrace(stackTrace);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	
	
}
