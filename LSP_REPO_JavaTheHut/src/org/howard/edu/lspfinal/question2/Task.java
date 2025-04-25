package org.howard.edu.lspfinal.question2;

/**
 * Implementation for the Task Data Structure for the Hashmap
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }
    
    /**
     * returns the name of the task
     * 
     * @return the name of the task
     */
    public String getName() {
        return name;
    }
    
    /**
     * returns the priority of the task
     * 
     * @return the priority of the task
     */
    public int getPriority() {
        return priority;
    }
    
    /**
     * returns the status of the task
     * 
     * @return the status of the task
     */
    public String getStatus() {
        return status;
    }
    
	/**
	 * Sets the status of the task
	 * 
	 * @param sets status of the task
	 */
	public void setStatus(String status) {
	    this.status = status;
	}

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority='" + priority + "', status='" + status + "'}";
    }
}
