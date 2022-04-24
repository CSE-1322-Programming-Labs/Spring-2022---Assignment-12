public class JobLeadsList {
    private Node head;
    private Node tail;

    JobLeadsList(){
        head = null;
        tail = null;
    }

    //Adds to the front of the linked list.
    public void add_to_front(String companyName,String contactName,String contactPhone,String jobTitle,String jobDescription){
        Node newNode = new Node(new JobLead(companyName,contactName,contactPhone,jobTitle,jobDescription)); //Make a new Node with a joblead data inside of it.

        //2 Cases
        if(head == null){ //There are no nodes in the list.
            head = newNode; //The new node will become both the head and the tail as it is the only node in the list.
            tail = newNode;
        }else{ //There is at  least 1 node in the list.
            newNode.next = head; //make the head come after out new node (making it second in the list)
            head.prev = newNode; //make sure that we set our previous in our head to point to the first node.
            head = newNode; //make sure our head points to the first node
        }
    }

    //Adds to the end of the linked list.
    public void add_to_tail(String companyName,String contactName,String contactPhone,String jobTitle,String jobDescription){
        Node newNode = new Node(new JobLead(companyName,contactName,contactPhone,jobTitle,jobDescription)); //Make a new Node with a joblead data inside of it.

        //2 Cases
        if(tail == null){ //There are no nodes in the list.
            head = newNode;//The new node will become both the head and the tail as it is the only node in the list.
            tail = newNode;
        }else{ //There is at  least 1 node in the list.
            tail.next = newNode; //Add a new node after the previously last one.
            newNode.prev = tail; //make sure that new last node points back to the previously old one
            tail = newNode; //Make sure to adjust the tail.
        }
    }

    public void remove_lead(String companyName, String jobTitle){
        //4 Cases
        if(head == null){ //If there is no list to begin with
            System.out.println("There are no JobLeads in the list!");
        }else if(head.lead.getCompanyName().equals(companyName) && head.lead.getJobTitle().equals(jobTitle)){ //If the lead is the first node in the list.
            //print out a message and remove the head.
            System.out.println("Job Lead Deleted");
            removeFirstNode();
        }else if(tail.lead.getCompanyName().equals(companyName) && tail.lead.getJobTitle().equals(jobTitle)){
            //print out a message and remove the tail.
            System.out.println("Job Lead Deleted");
            removeLastNode();
        }else{ // general case, 3+ nodes and it cannot be the first or last node.
            Node traversal = head; //Create a traversal node so we do not destroy our linked list while traveling through it.
            while(traversal.next.next != null){ //make sure we have at least 2 nodes ahead of us. Note that this algorithm will not look at the first or last node, but we already checked those.
                //If the next node is the one in question, then just connect our current node to the one after the next one and same the other way around.
                if(traversal.next.lead.getCompanyName().equals(companyName) && traversal.next.lead.getJobTitle().equals(jobTitle)){
                    System.out.println("Job Lead Deleted");
                    traversal.next =  traversal.next.next; //Delete the next node.
                    traversal.next.prev = traversal; //readjust the previous to point to the right place.
                    break;
                }else{
                    traversal = traversal.next;
                }
            }
        }
    }


    //This method will remove the first node.
    public void removeFirstNode(){
        if(head==null){ //Check to see that there actually is a Node to remove.
            System.out.println("List is Empty.");
        }else if (head.next == null){ // If there is only 1 item in the list just point head and tail to null.
            head = null;
            tail = null;
        }else{
            head = head.next; //set the head pointer to point to the next node, effectively deleting the first node.
            if(head.next == null) tail = head; //if the new head has no next node, it is the last node, so set the tail to it too.
        }
    }

    //This method will remove the last node.
    public void removeLastNode(){
        if(tail == null){ //check to make sure there is a list to begin with.
            System.out.println("List is Empty.");
        }else if(tail.prev == null){ //if there is only 1 Node, then just set head and tail to null.
            head = null;
            tail = null;
        }else{
            tail = tail.prev; //Set the tail to one before it, effectively deleting the last node.
            if(tail.prev == null) tail = head; //if this is the only node in the list, it would also be the head.
        }
    }

    //Prints list from head to tail.
    public void print_head_to_tail(){
        if(head == null){
            System.out.println("List is empty!");
        }else{
            Node traversal = head;
            while(traversal!= null){
                System.out.println(traversal.lead); //call the toString method inside the JobLead class which is in each node.
                traversal = traversal.next;
            }
            System.out.println();
        }
    }

    public void print_tail_to_head(){
        if(tail == null){
            System.out.println("List is empty!");
        }else{
            Node traversal = tail;
            while(traversal!= null){
                System.out.println(traversal.lead); //call the toString method inside the JobLead class which is in each node.
                traversal = traversal.prev;
            }
            System.out.println();
        }
    }


}
