package main.java.oop_week8.class_problems;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String studentId;
    private String name;
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
    public String getName() { return name; }
}

abstract class Question {
    protected String questionText;
    protected char correctAnswer;
    public Question(String questionText, char correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
    public abstract boolean evaluate(char answer);
}

class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String questionText, char correctAnswer) {
        super(questionText, correctAnswer);
    }
    @Override
    public boolean evaluate(char answer) {
        return Character.toUpperCase(answer) == Character.toUpperCase(correctAnswer);
    }
}

class Attempt {
    private Student student;
    private Examination examination;
    private List<Character> answers = new ArrayList<>();
    private boolean submitted = false;

    public Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
    }

    public void answerQuestion(char choice) {
        if (!submitted) {
            answers.add(choice);
        }
    }

    public void submit() {
        this.submitted = true;
    }

    public int calculateScore() {
        List<Question> qs = examination.getQuestions();
        int score = 0;
        for (int i = 0; i < Math.min(answers.size(), qs.size()); i++) {
            if (qs.get(i).evaluate(answers.get(i))) {
                score++;
            }
        }
        return score;
    }
}

class Examination {
    String examTitle;
    private List<Question> questions = new ArrayList<>();

    public Examination(String examTitle) {
        this.examTitle = examTitle;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public List<Question> getQuestions() { return questions; }
}

public class OnlineExaminationSystem {
    // Online Examination System Design and Implementation container
}