/**
 * @author Allen G. Saakov,
 * @date 04/13/23
 * @tile Stack implementation using an Array List
 */

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class ArrayListStack
{
    // declare a class – level array list
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        // declare objects and flag
        Date myDate = new Date();
        String myDateFormat = "MM/dd/yyyy";
        SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);
        JFrame frame = new JFrame("Consulting Client Tracker");
        boolean flag = false;

        while(!flag) {
            // user inputs the amount of elements they want in the stack
            JOptionPane.showMessageDialog(frame, "Input the client information. Input 'Done' when finished");
            while (true) {
                String clients = JOptionPane.showInputDialog("Clients to add: ");
                if (clients.equals("Done")) {
                    break;
                }
                // undo and then redo list reversal
                Collections.reverse(list);
                push(clients);
                Collections.reverse(list);
            }

            // reverse the list to create the stack


            // store the stack elements in a StringBuilder object
            StringBuilder sb = new StringBuilder();
            // declare an Iterator object
            Iterator<String> itr = list.iterator();
            // iterate through the list of elements in the ArrayList
            System.out.println("iterate through ArrayList elements");
            while(itr.hasNext())
            {
                sb.append(itr.next() + "\n");
            }

            // display the stack elements in a Dialog Box
            JOptionPane.showMessageDialog(null, dtToday.format(myDate) +
                    "\n" + "Display Elements \n" + sb);

            // give user options on what to do with the stack
            boolean doneManipulating = false;
            String[] userSelection = { "pop", "isEmpty", "top", "done with actions"};
            while(!doneManipulating) {
                int userSelect = JOptionPane.showOptionDialog(frame,
                        "Select the action to take on the stack.",
                        "Pick one: ", 0, JOptionPane.INFORMATION_MESSAGE, null, userSelection, userSelection[0]);
                switch (userSelect) {
                    case 0 -> {
                        JOptionPane.showMessageDialog(frame, "Element popped: " + pop());
                        if (isEmpty())
                            JOptionPane.showMessageDialog(frame, "You removed all clients from stack, please exit program.");
                    }
                    case 1 -> JOptionPane.showMessageDialog(frame, "Is list empty: " + isEmpty());
                    case 2 -> JOptionPane.showMessageDialog(frame, "Element at the top of stack is: " + top());
                    case 3 -> doneManipulating = true;
                }
            }

            // clear the StringBuilder object
            sb.setLength(0);

            // update the Iterator object
            itr = list.iterator();

            // store the updated stack elements in a StringBuilder object
            System.out.println("iterate through ArrayList elements");
            while(itr.hasNext())
            {
                sb.append(itr.next() + "\n");
            }

            // display the current stack elements in a Dialog Box
            JOptionPane.showMessageDialog(null, dtToday.format(myDate) +
                    "\n" + "Display Elements \n" + sb);

            // ask user if they want to exit program
            String[] exitOption = { "Yes", "No" };
            int exitSelect = JOptionPane.showOptionDialog(frame, "Do you want to exit?", "End Program Option",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, exitOption, exitOption[0] );
            if (exitSelect == 0) flag = true;
        }
    }

    // define the pop() method
    public static Object pop() {
        // declare an object to manipulate the list,
        if(isEmpty()) {
            return null;
        }
        Object obj;
        obj = list.remove(0);
        return obj;
    }

    public static boolean isEmpty() {
        return list.size() == 0;
    }

    public static void push(Object s) {
            list.add((String) s);
       }

    public static Object top() {
        return list.get(0);
    }


}
