public class Node {
    //The instructions do not say to make these public or private, so i'll make them public for ease of access.
    public JobLead lead;
    public Node prev;
    public Node next;

    //Technically this is unnecessary as it will default to null , but to make it explicit.
    Node(){
        lead = null;
        prev = null;
        next = null;
    }

    //Added an overloaded constructor so that it is possible to just initialize the lead using the constructor.
    Node(JobLead lead){
        this.lead = lead;
        prev = null;
        next = null;
    }

}
