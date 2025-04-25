package org.howard.edu.lspfinal.question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the Task Manager
 */
public class TaskManager {
    private Map<String, Task> taskMap;

    public TaskManager() {
    	// Sets a empty HashMap when the Constructor is Called
        this.taskMap = new HashMap<>();
    }
    
    /**
     * Adds a New Task to the Task Manager
     * 
     * @param name name of the task to add
     * @param priority integer value of the priority level of the task
     * @param status string of the current status of the task
     * @throws DuplicateTaskException is thrown whenever an task of the same name has been inputed
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (taskMap.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exits.");
        }

        Task task = new Task(name, priority, status);
        taskMap.put(name, task);
    }
    
    /**
     * Retrieves a task by its name.
     *
     * @param name name of the task to retrieve
     * @return the Task object from the provided name
     * @throws TaskNotFoundException if the name provided is not a task
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = taskMap.get(name);
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return task;
    }
    
    /**
     * Updates the status of an existing task.
     *
     * @param name name of the task to update
     * @param newStatus the new status to be update the task
     * @throws TaskNotFoundException if the name provided is not a task
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

    /**
     * Prints out all the Tasks and Groups them by there Status
     */
    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> grouped = new HashMap<>();
        
        System.out.println("Tasks grouped by status:");
        // Hash Map Iteration from https://www.w3schools.com/java/java_howto_loop_through_hashmap.asp
        // Maps the Current hash map split on the key of there status
        for (Task task : taskMap.values()) {
            String status = task.getStatus();
            if (!grouped.containsKey(status)) {
                grouped.put(status, new ArrayList<>());
            }
            grouped.get(status).add(task);
        }
        
        // Iterates through each Grouping of Tasks and then Iterates through each task of a grouping
        for (Map.Entry<String, List<Task>> entry : grouped.entrySet()) {
            System.out.println("Status: " + entry.getKey());
            for (Task task : entry.getValue()) {
                System.out.println(task);
            }
        }
    }



}
