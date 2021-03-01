package common;
/**
 * 
 */

/**
 * @author pranj
 *
 */

	class InvalidPairException extends Exception{  
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		InvalidPairException(String s){  
		  super(s);  
		 }  
		}
	
	
	class NumberOfTargetNodesExceeded extends Exception{  
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		NumberOfTargetNodesExceeded(String s){  
		  super(s);  
		 }  
		}
