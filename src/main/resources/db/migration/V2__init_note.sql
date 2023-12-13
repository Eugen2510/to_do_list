CREATE TABLE IF NOT EXISTS note
(
    id IDENTITY PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    user_id VARCHAR(100) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (username)
    );