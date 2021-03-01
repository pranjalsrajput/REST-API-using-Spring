package com.rest.restservice.GraphUtilities;
import java.util.List;

/**
 * 
 */

/**
 * @author pranj
 *
 */

 public class Node {
		    private String value;
			private List<Node> listOfParents;
		    private List<Node> listOfChildren;
	
		    public Node(String value, List<Node> listOfParents, List<Node> listOfChildren) {
		      this.value = value;
		      this.listOfParents=listOfParents;
		      this.listOfChildren=listOfChildren;
		    }
	
		    @Override
		    public String toString() {
		      return value;
		    }
		    
		    /**
			 * @return the value
			 */
			public String getValue() {
				return value;
			}

			/**
			 * @param value the value to set
			 */
			public void setValue(String value) {
				this.value = value;
			}


		    public List<Node> getListOfParents() {
				return listOfParents;
			}

			public void setListOfParents(List<Node> listOfParents) {
				this.listOfParents = listOfParents;
			}
			
			public List<Node> getListOfChildren() {
				return listOfChildren;
			}

			public void setListOfChildren(List<Node> listOfChildren) {
				this.listOfChildren = listOfChildren;
			}

		  }