package newProject;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
class Student{
private String name;
private String id;
private int presentCount;
private boolean isMarkedToday;
public Student(String name,String id,int presentCount){
this.name=name;
this.id=id;
this.presentCount=presentCount;
this.isMarkedToday=false;
}
public String getName(){return name;}
public String getId(){return id;}
public int getPresentCount(){return presentCount;}
public void setPresentCount(int count){
this.presentCount=count;
}
public void markPresent(){
this.isMarkedToday=true;
}
public void confirmAttendance(){
if(isMarkedToday){
this.presentCount++;
isMarkedToday=false;
}}}
public class AttendanceMarker extends JFrame{
private List<Student>students=new ArrayList<>();
private int totalClassesHeld=0;
public AttendanceMarker(){
setTitle("Attendance Marker-BAU(CSM-1222)");
setSize(500,600);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
loadData();
showMainInterface();
}
private void showMainInterface(){
JPanel mainPanel=new JPanel(new BorderLayout(15,15));
mainPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
JPanel listPanel=new JPanel(new GridLayout(students.size(),1,5,5));
for(Student s:students){
JButton sBtn=new JButton(
s.getName()+"("+s.getId()+")-Count:"+s.getPresentCount());
sBtn.addActionListener(e->{
s.markPresent();
sBtn.setText(s.getName()+"-DONE✓");
sBtn.setEnabled(false);
sBtn.setBackground(new Color(144,238,144));
});
listPanel.add(sBtn);
}
JPanel controlPanel=new JPanel(new GridLayout(3,1,8,8));
JButton completeDayBtn=new JButton("Complete for the Day");
completeDayBtn.setBackground(new Color(173,216,230));
completeDayBtn.addActionListener(e->{
totalClassesHeld++;
for(Student s:students){
s.confirmAttendance();
}
JOptionPane.showMessageDialog(this,"Today's Attendance Saved! Total:"+totalClassesHeld);
showMainInterface();
});
JButton reportBtn=new JButton("End of Course-Generate Report");
reportBtn.addActionListener(e->generateReport());
JButton exitBtn=new JButton("Exit Application");
exitBtn.setBackground(new Color(255,182,193));
exitBtn.addActionListener(e->System.exit(0));
controlPanel.add(completeDayBtn);
controlPanel.add(reportBtn);
controlPanel.add(exitBtn);
mainPanel.add(
new JLabel("CSM-1222 Attendance System",SwingConstants.CENTER),BorderLayout.NORTH);
mainPanel.add(new JScrollPane(listPanel),BorderLayout.CENTER);
mainPanel.add(controlPanel,BorderLayout.SOUTH);
setContentPane(mainPanel);
revalidate();
}
private void loadData(){
students.add(new Student("Sowaib Abdullah","2409023",0));
students.add(new Student("Rahim Ahmed","2409024",0));
students.add(new Student("Karim Ullah","2409025",0));
}
private void generateReport(){
if(totalClassesHeld==0){
JOptionPane.showMessageDialog(this,"No classes recorded!");
return;
}
StringBuilder report=new StringBuilder();
report.append("Final Report\n");
report.append("Total Classes:"+totalClassesHeld+"\n\n");
for(Student s:students){
double p=(s.getPresentCount()*100.0)/totalClassesHeld;
report.append(String.format("%s:%d Days(%.2f%%)\n",s.getName(),s.getPresentCount(),p));
}
JOptionPane.showMessageDialog(this,new JScrollPane(new JTextArea(report.toString())));
}
public static void main(String[] args){
SwingUtilities.invokeLater(()->{
new AttendanceMarker().setVisible(true);
});}}