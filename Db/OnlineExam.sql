CREATE TABLE user (username varchar(10) NOT NULL,first_name varchar(10) DEFAULT NULL,last_name varchar(10) DEFAULT NULL,enabled tinyint(1) DEFAULT NULL, password varchar(100) DEFAULT NULL,PRIMARY KEY (`username`));

CREATE TABLE role (user_role_id int(10) NOT NULL AUTO_INCREMENT, username varchar(10) DEFAULT NULL, role varchar(20) DEFAULT NULL, PRIMARY KEY (`user_role_id`), KEY `username` (`username`), CONSTRAINT `role_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`));


CREATE TABLE `course` (`course_id` int(10) NOT NULL AUTO_INCREMENT,`course_name` varchar(10) DEFAULT NULL,`description` varchar(50) DEFAULT NULL,PRIMARY KEY (`course_id`));
 
CREATE TABLE `course_section` (`section_id` int(10) NOT NULL AUTO_INCREMENT,`course_id` int(10) DEFAULT NULL,`teacher_id` varchar(10) DEFAULT NULL,`semester` varchar(10) DEFAULT NULL,`course_year` date DEFAULT NULL,PRIMARY KEY (`section_id`),KEY `course_id` (`course_id`),KEY `teacher_id` (`teacher_id`),CONSTRAINT `course_section_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),CONSTRAINT `course_section_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`username`));

CREATE TABLE `student_section` (`section_id` int(10) NOT NULL,`student_id` varchar(10) NOT NULL,PRIMARY KEY (`section_id`,`student_id`),KEY `section_id` (`section_id`),KEY `student_id` (`student_id`),CONSTRAINT `student_section_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `course_section` (`section_id`),CONSTRAINT `student_section_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `user` (`username`));


create table question ( question_id int(10) not null auto_increment, question_description varchar(2000), primary key(question_id));

create table quiz (quiz_id int(10) not null auto_increment, section_id int(10), activation_time timestamp,primary key(quiz_id));

CREATE TABLE `quiz_question` (
  `quiz_id` int(10) NOT NULL,
  `question_id` int(10) NOT NULL,
  PRIMARY KEY (`quiz_id`,`question_id`));

create table tag(tag_id int(10) not null auto_increment, tag_name varchar(10) , question_id int(10), primary key(tag_id));

create table test_case (test_id int(10) primary key not null auto_increment, test_question_id int(10), input varchar(100), output varchar(100));

alter table quiz_question add constraint quiz_question_fk_1 foreign key(quiz_id) references quiz(quiz_id);
alter table quiz_question add constraint quiz_question_fk_2 foreign key(question_id) references question(question_id);

alter table tag add constraint tag_fk_1 foreign key(question_id) references question(question_id);

alter table test_case add constraint test_case_fk_1 foreign key(test_question_id) references question(question_id);



