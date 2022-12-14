package com.taskManagement.view;

import com.taskManagement.controller.AssigneeController;
import com.taskManagement.model.Assignee;
import com.taskManagement.validation.Validator;

/**
 * List various operations available for
 * creating, reading, updating, deleting 
 * assignee.
 * 
 * @author Ajith venkadesh.
 * @version 1.0
 */
public class AssigneeMenu {
    
	/**
	 * Display all options available for assignee.
	 */
	public void dispalyOptions() {
	    final AssigneeController controller = new AssigneeController();
        final TaskMenu menu = new TaskMenu();
        final AssigneeDetails details = new AssigneeDetails();
        final Validator validator = new Validator();
               
        System.out.println ("\n Enter 1 for creating new assignee"
		        + "\n Enter 2 for updating a partcular assignee"
		        + "\n Enter 3 for deleting a particular assignee"
		        + "\n Enter 4 searching a particular assignee"
		        + "\n Enter 5 to move to task menu ");
        int choice = MenuLauncher.INPUT.nextInt();
        MenuLauncher.INPUT.nextLine();
        switch (choice) {
        case 1 :
        	 final Assignee assignee = new Assignee(details.getAssigneeId(),
        			 validator.validateName(details.getAssigneeName()));
        	 System.out.println (controller.createAssignee(assignee));
    	    break;
        case 2 :
        	System.out.println (controller.updateAssignee(validator.validateAssigneeId
    	    		(details.getAssigneeId()), validator.validateName
    	    		(details.getAssigneeName())));
    	    break;
        case 3 :
        	System.out.println (controller.deleteAssignee(validator.validateAssigneeId
    	    		(details.getAssigneeId())));
    	    break;
        case 4 :
    	    details.print(controller.searchParticularAssignee(validator.validateAssigneeId
    	    		(details.getAssigneeId())));
    	    break;
        case 5 :
    	    menu.displayOptions();
    	    break;
        default :
        	System.out.println ("You have enetered wrong choice");
    	    break;
        }
    }
}
