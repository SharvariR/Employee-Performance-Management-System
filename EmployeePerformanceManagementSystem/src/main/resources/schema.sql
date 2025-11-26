-- Create Department table
CREATE TABLE IF NOT EXISTS department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    budget DOUBLE NOT NULL
);

-- Create Employee table
CREATE TABLE IF NOT EXISTS employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    department_id BIGINT,
    date_of_joining DATE NOT NULL,
    salary DOUBLE NOT NULL,
    manager_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES department(id),
    FOREIGN KEY (manager_id) REFERENCES employee(id)
);

-- Create PerformanceReview table
CREATE TABLE IF NOT EXISTS performance_review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT,
    review_date DATE NOT NULL,
    score INT NOT NULL,
    review_comments TEXT,
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);

-- Create Project table
CREATE TABLE IF NOT EXISTS project (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES department(id)
);

-- Create Employee_Project table for many-to-many relationship
CREATE TABLE IF NOT EXISTS employee_project (
    employee_id BIGINT,
    project_id BIGINT,
    assigned_date DATE NOT NULL,
    role VARCHAR(255) NOT NULL,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);