package assignment01;

import support.cse131.ArgsProcessor;

public class GradeCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		String name = ap.nextString("The name of student");
		double averageAssignmentGrade = ap.nextDouble("The average grade on all assignments");
		int extensionPoints = ap.nextInt("The number of points earned during extensions");
		int studioAttended = ap.nextInt("The total number of studio sessions attended");
		double averageQuizGrade = ap.nextDouble("The average grade on all quizzes");
		int studioPrepsCompleted = ap.nextInt("The total number of pre-studio preps completed");
		double averageExamGrade = ap.nextDouble("The average grade on all exams");
		boolean CourseReview = Math.random() == 0.5;
		
		
		double weightedAssignmentGrade = averageAssignmentGrade * 40 / 100.0;
		double weightedExtensionGrade = extensionPoints * 12 / 40.0;
		double weightedStudioGrade = Math.round(studioAttended / 8.0 * 1300) / 100.0;
		double weightedQuizGrade = Math.round(averageQuizGrade * 2)/100.0;
		double weightedStudioPrepGrade = studioPrepsCompleted * 2 / 10.0;
		double weightedExamGrade = averageExamGrade * 30 / 100.0;
		
		double totG = 1.0 + weightedAssignmentGrade + weightedExtensionGrade +
				(studioAttended / 8.0 * 13) + (averageQuizGrade * 2)/100.0 + 
				weightedStudioPrepGrade + weightedExamGrade;
		double totalGrade = Math.round(totG*100) / 100.0;
				
		System.out.println("CSE131 Grade for: "+name+"\n");
		
		System.out.println("Average assignment grade: "+averageAssignmentGrade+"%");
		System.out.println("\t Weighted assignment grade (out of 40): "+weightedAssignmentGrade+"%\n");
		
		System.out.println("Number of extension points: "+extensionPoints);
		System.out.println("\t Weighted extension grade (out of 12): "+weightedExtensionGrade+"%\n");
		
		System.out.println("Number of studios attended:"+studioAttended);
		System.out.println("\t Weighted studio grade (out of 13): "+weightedStudioGrade+"%\n");
		
		System.out.println("Average quiz grade: "+averageQuizGrade+"%");
		System.out.println("\t Weighted quiz grade (out of 2): "+weightedQuizGrade+"%\n");
		
		System.out.println("Studio preps completed: "+studioPrepsCompleted);
		System.out.println("\t Weighted studio prep grade (out of 2): "+weightedStudioPrepGrade+"%\n");
		
		System.out.println("Average exam grade: "+averageExamGrade);
		System.out.println("\t Weighted exam grade (out of 30): "+weightedExamGrade+"%\n");	
		
		System.out.println("Completed course review: "+CourseReview+"\n");
		
		System.out.println("Total Grade: "+totalGrade+"%");

	}

}
