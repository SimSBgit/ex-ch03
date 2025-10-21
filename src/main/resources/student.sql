SHOW DATABASES;

CREATE DATABASE testdb;

CREATE TABLE student(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(100) NOT NULL,
	email VARCHAR(100),
	age INT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO student(NAME, email, age)
VALUES
('김철수', 'kim@example.com', 20),
('이영희', 'lee@example.com', 22),
('박민수', 'park@example.com', 21);

SELECT * FROM student;

select * from student ORDER BY id DESC;

select * from student where id = 1;

INSERT INTO student(NAME, email, age) 
VALUES('화이팅', 'fight@example.com', 23);

UPDATE student SET NAME = '수정철수', email = 'kim@example', age = 20
WHERE id = 1;

DELETE FROM student WHERE id = 8;