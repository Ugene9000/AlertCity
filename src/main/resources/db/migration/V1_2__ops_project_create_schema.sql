CREATE TABLE IF NOT EXISTS ops_project (
    id INT NOT NULL AUTO_INCREMENT,
    ops_id INT NOT NULL,
    project_id INT NOT NULL,
    PRIMARY KEY (id)
);