import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        boolean running = true;
        JobLeadsList linkedList = new JobLeadsList();
        do{
            printMenu();
            String[] jobInfoList;
            switch (getValidateUserMenuInput()){
                case 1:
                    jobInfoList = getJobLeadInfo();
                    linkedList.add_to_front(jobInfoList[0],jobInfoList[1],jobInfoList[2],jobInfoList[3],jobInfoList[4]);
                    break;
                case 2:
                    jobInfoList = getJobLeadInfo();
                    linkedList.add_to_tail(jobInfoList[0],jobInfoList[1],jobInfoList[2],jobInfoList[3],jobInfoList[4]);
                    break;
                case 3:
                    String[] deleteInfo = getJobLeadDeletionInfo();
                    linkedList.remove_lead(deleteInfo[0],deleteInfo[1]);
                    break;
                case 4:
                    linkedList.print_head_to_tail();
                    break;
                case 5:
                    linkedList.print_tail_to_head();
                    break;
                case 6:
                    running = false;
                    System.out.println("Terminating program, Thank you ;)");
                    break;
                default: //This is kind of redundant since we catch invalid inputs in the getValidateMenuInput method.
                    System.out.println("Invalid input, please try again.");
            }
        }while(running);
    }

    private static void printMenu(){
        System.out.println("1 – Add lead to head of list");
        System.out.println("2 – Add lead to tail of list");
        System.out.println("3 – Delete a lead");
        System.out.println("4 – Print list from head to tail");
        System.out.println("5 – Print list from tail to head");
        System.out.println("6 – Exit\n");
    }

    //This method will get and validate the user menu input.
    private static int getValidateUserMenuInput(){
        boolean testPassed = false;
        int userInputInteger = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter option number: ");
            try{
                userInputInteger = Integer.parseInt(sc.nextLine());
                if(userInputInteger>=1 && userInputInteger <= 6){ //if the number is actually a valid menu option, return that number.
                    testPassed = true;
                }else{
                    System.out.println("Please enter a number between 1-6.");
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter an Integer.");
            }
        }while(!testPassed);
        return userInputInteger;
    }

    //This method gets all the information about a string array of all the information and stores it.
    //personally I would have made the methods in the linked list take an object and make this method return an object, but instructions are instructions.
    public static String[] getJobLeadInfo(){
        String[] information = new String[5];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Company Name: " );
        information[0] = sc.nextLine();

        System.out.print("Enter Contact Person Name: ");
        information[1] = sc.nextLine();

        System.out.print("Enter Contact Person Phone: ");
        information[2] = sc.nextLine();

        System.out.print("Enter Job Title: ");
        information[3] = sc.nextLine();

        System.out.print("Enter Job Description: ");
        information[4] = sc.nextLine();

        return information;
    }

    //This method gets all the information about a string array of all the information and stores it.
    //personally I would have made the methods in the linked list take an object and make this method return an object, but instructions are instructions.
    public static String[] getJobLeadDeletionInfo(){
        String[] information = new String[2];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Company Name: " );
        information[0] = sc.nextLine();

        System.out.print("Enter Job Title: ");
        information[1] = sc.nextLine();

        return information;
    }
}
