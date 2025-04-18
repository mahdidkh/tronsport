-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS tronsport_db;

-- Create the user if it doesn't exist
CREATE USER IF NOT EXISTS 'tronsport'@'localhost' IDENTIFIED BY 'mahdi3629A';

-- Grant privileges to the user
GRANT ALL PRIVILEGES ON tronsport_db.* TO 'tronsport'@'localhost';

-- Apply the changes
FLUSH PRIVILEGES;
