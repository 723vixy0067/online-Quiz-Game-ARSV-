CREATE database Userapp;

use Userapp;

CREATE TABLE questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question_text VARCHAR(255) NOT NULL,
    options VARCHAR(255) NOT NULL, -- Store as comma-separated values, e.g., "Option1,Option2,Option3"
    correct_answer VARCHAR(255) NOT NULL
);
