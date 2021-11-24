package gr.peoplecert.bootcamp.handlers;

import gr.peoplecert.bootcamp.utils.Utils;
import gr.peoplecert.bootcamp.entities.Assignment;

public class AssignmentHandler {
    public static void createAssignment() {
        Assignment a1 = new Assignment();
        System.out.println("GIVE TITLE");
        a1.setTitle(Utils.extractValidString());

        System.out.println("GIVE DESCRIPTION");
        a1.setDescription(Utils.extractValidString());

        a1.setSubDateTime(Utils.getValidDate("GIVE A SUB DATE TIME WITH FORMAT YYYY-M-DD"));

        System.out.println("GIVE ORAL MARK");
        a1.setOralMark(getMark());
        System.out.println("GIVE TOTAL MARK");
        a1.setTotalMark(getMark());
        Assignment.addAssignment(a1);

    }

    private static int getMark() {
        Integer oralMark = null;

        while (oralMark == null) {
            String inputSelection = Utils.extractValidString();
            try {
                oralMark = Integer.parseInt(inputSelection);
                if (oralMark < 0 || oralMark > 100) {
                    throw new Exception("SELECTION NOT WITHIN RANGE");
                }
            } catch (NumberFormatException e) {
                System.out.println("IS NOT A NUMBER");
            } catch (Exception e) {
                oralMark = null;
                System.out.println(e.getMessage());
            }
        }
        return oralMark;
    }


}
