package JAVA.Project;

import java.util.Scanner;

public class EmployeePayrollMultiple 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        int[] ids = new int[n];
        String[] names = new String[n];
        double[] basics = new double[n];
        int[] absentDays = new int[n];
        double[] taxes = new double[n];
        double[] absentDeductions = new double[n];
        double[] netPays = new double[n];

        for (int i = 0; i < n; i++) 
        {
            System.out.println("\nEnter details for Employee #" + (i + 1));
            System.out.print("Enter Employee ID: ");
            ids[i] = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            names[i] = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            basics[i] = sc.nextDouble();

            System.out.print("Enter Number of Absent Days: ");
            absentDays[i] = sc.nextInt();
            sc.nextLine();

            taxes[i] = (basics[i] > 50000) ? 0.10 * basics[i] : 0.05 * basics[i];
            double perDaySalary = basics[i] / 30;
            absentDeductions[i] = perDaySalary * absentDays[i];
            netPays[i] = basics[i] - taxes[i] - absentDeductions[i];
        }

        System.out.println("\n\n--- All Employee Payslips ---");
        for (int i = 0; i < n; i++) 
        {
            System.out.println("\n--- PAY SLIP for Employee #" + (i + 1) + " ---");
            System.out.println("Employee ID: " + ids[i]);
            System.out.println("Name: " + names[i]);
            System.out.println("Basic Salary: " + String.format("%.2f", basics[i]));
            System.out.println("Absent Days: " + absentDays[i]);
            System.out.println("Tax Deduction: " + String.format("%.2f", taxes[i]));
            System.out.println("Absent Deduction: " + String.format("%.2f", absentDeductions[i]));
            System.out.println("Total Deduction: " + String.format("%.2f", (taxes[i] + absentDeductions[i])));
            System.out.println("Net Pay: " + String.format("%.2f", netPays[i]));
            System.out.println("------------------------------");
        }
        System.out.println("\n Thank you for using the Employee Payroll System!");
        System.out.println(" Developed by Gyanendra Singh");
        sc.close();
    }
}
