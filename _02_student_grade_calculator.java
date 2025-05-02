/*Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user*/
import java.util.*;
class Details{
    Scanner sc = new Scanner(System.in);
    String name;
    int roll;
    float []marks = new float[5];
    float totalMarks,percentage;
    Details(){
        name ="none";
        roll = 0;
        totalMarks = 0.0f;
        percentage = 0.0f;
    }
    void setDetails(){
        System.out.println("Enter the name of the students : ");
        try{
            name = sc.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Enter the valid name ---> "+e);
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
        }
        System.out.println("Enter the roll number : ");
        try{
            roll = sc.nextInt();
            sc.nextLine(); //Condumes the next line
        }
        catch(InputMismatchException e){
            System.out.println("Enter the valid roll number ---> "+e);
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
        }
    }
    void setMarks(){
       
        for(int i =0; i<5;i++){
            System.out.println("Enter the marks for subject "+(i+1)+" : ");
            try{
                marks[i] = sc.nextFloat();
            }
            catch(InputMismatchException e){
                System.out.println("Enter the valid marks ---> "+e);
            }
            catch(Exception e){
                System.out.println("Exception : "+e);
            }
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Marks must be between 0 and 100. Please re-enter.");
                i--; 
                continue;
            }
        }
    }
    void averagePercentage(){
        for(int i =0;i<5;i++){
            totalMarks+=marks[i];
        }
        percentage = totalMarks/5;
    }
    String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+ (Excellent)";
        } else if (percentage >= 80) {
            return "A (Very Good)";
        } else if (percentage >= 70) {
            return "B+ (Good)";
        } else if (percentage >= 60) {
            return "B (Above Average)";
        } else if (percentage >= 50) {
            return "C (Average)";
        } else if (percentage >= 40) {
            return "D (Pass)";
        } else {
            return "F (Fail)";
        }
    }
    void getDetails(){
        System.out.println("---------Result summary--------");
        System.out.println("Name : "+name);
        System.out.println("Roll Number : "+roll);
        System.out.println("Total marks obtained out of 500 : "+totalMarks);
        System.out.println("Percentage : "+percentage+" %");
        System.out.println("Grade : "+calculateGrade(percentage));
        System.out.println("-------------------------------");
    }
}
public class _02_student_grade_calculator {
    public static void main(String[] args) {
        Details obj = new Details();
        obj.setDetails();
        obj.setMarks();
        obj.averagePercentage();
        obj.getDetails();
    }
}
