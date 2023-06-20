package WorkingWithAbstraction.P03_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public Map<String, Student> getRepository() {
        return this.repository;
    }

    public void ParseCommand(String[] args) {
        String command = args[0];
        String name = args[1];

        if (command.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);

            if (!repository.containsKey(name)) {
                Student student = new Student(name, age, grade);
                repository.put(name, student);
            }

        } else if (command.equals("Show")) {
            if (repository.containsKey(name)) {
                Student student = repository.get(name);
                String view = String.format("%s is %s years old.", student.getName(), student.getAge());

                if (student.getGrade() >= 5.00) {
                    view += " Excellent student.";
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    view += " Average student.";
                } else {
                    view += " Very nice person.";
                }

                System.out.println(view);
            }
        }
    }
}
