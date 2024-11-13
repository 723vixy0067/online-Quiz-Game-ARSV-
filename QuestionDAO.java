package com.user.dao;

import com.user.model.Question;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/quizgame";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    // SQL Queries
    private static final String GET_ALL_QUESTIONS = "SELECT * FROM questions";

    // Get all questions from the database
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_QUESTIONS)) {

            while (resultSet.next()) {
                Question question = new Question();
                question.setId(resultSet.getInt("id"));
                question.setQuestionText(resultSet.getString("question_text"));
                
                // Split options by delimiter (e.g., comma)
                String options = resultSet.getString("options");
                question.setOptions(Arrays.asList(options.split(",")));
                
                question.setCorrectAnswer(resultSet.getString("correct_answer"));

                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    // Add other methods for inserting, updating, and deleting questions as needed
}
