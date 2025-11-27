-- Insert sample departments
INSERT INTO department (id, name, budget) VALUES (1, 'Engineering', 1000000);
INSERT INTO department (id, name, budget) VALUES (2, 'Marketing', 800000);
INSERT INTO department (id, name, budget) VALUES (3, 'Sales', 900000);

-- Insert sample employees
INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id) VALUES (1, 'John Doe', 'john.doe@example.com', 1, '2021-01-01', 70000, NULL);
INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id) VALUES (2, 'Jane Smith', 'jane.smith@example.com', 2, '2020-05-15', 65000, 1);
INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id) VALUES (3, 'Alice Johnson', 'alice.johnson@example.com', 3, '2019-11-20', 75000, 1);

-- Insert sample performance reviews
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES (1, 1, '2021-06-01', 9, 'Excellent performance');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES (2, 2, '2021-06-01', 8, 'Good performance');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES (3, 3, '2021-06-01', 7, 'Needs improvement');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES (4, 3, '2021-05-01', 6, 'Needs improvement');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES (5, 3, '2021-04-01', 5, 'Needs improvement');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES (6, 3, '2021-03-01', 4, 'Needs improvement');
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES (7, 3, '2021-02-01', 3, 'Needs improvement');

-- Insert sample projects
INSERT INTO project (id, name, start_date, end_date, department_id) VALUES (1, 'Project Alpha', '2021-01-01', '2021-12-31', 1);
INSERT INTO project (id, name, start_date, end_date, department_id) VALUES (2, 'Project Beta', '2021-02-01', '2021-11-30', 2);

-- Insert sample employee_project relationships
INSERT INTO employee_project (employee_id, project_id, assigned_date, role) VALUES (1, 1, '2021-01-01', 'Lead Developer');
INSERT INTO employee_project (employee_id, project_id, assigned_date, role) VALUES (2, 1, '2021-02-01', 'Developer');
INSERT INTO employee_project (employee_id, project_id, assigned_date, role) VALUES (3, 2, '2021-03-01', 'Marketing Specialist');