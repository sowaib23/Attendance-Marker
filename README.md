Attendance Marker System

A simple Java Swing desktop application designed to track daily class attendance and automatically calculate final percentage reports at the end of the semester.

Introduction:

Taking roll call manually on paper and calculating attendance percentages at the end of the term is tedious and time-consuming. This lightweight GUI tool was built to help teachers or Class Representatives (CRs) quickly mark attendance and eliminate manual work.

Objectives:

Digitally record class attendance with ease.

Reduce manual calculation errors and save administrative time.

Generate instant attendance percentage reports at the end of the course.

Problem Solved
Calculating overall attendance percentages for each student based on the total number of classes held requires repetitive manual calculations. This application automates the entire tracking and reporting process.

How It Works:

Mark Present: When the app runs, students are displayed as interactive buttons. Clicking a student's button marks them present, turning the button green with a "DONE✓" label.

Complete the Day: Once attendance is taken for the session, clicking "Complete for the Day" increments the total class count and updates student records.

Generate Report: At the end of the course, clicking "End of Course-Generate Report" pops up a summary showing total classes held alongside each student's attendance percentage.

How to Use:

Ensure Java (JDK) is installed on your computer.

Open the project in your preferred IDE (VS Code, Eclipse, or NetBeans).

Run AttendanceMarker.java.

Limitations:

In-Memory Storage: Attendance records are stored temporarily in RAM while the app is running and will reset once closed, as there is no database or file storage.

Static Student List: New students cannot be added or removed through the user interface because the student list is hardcoded in the source file.