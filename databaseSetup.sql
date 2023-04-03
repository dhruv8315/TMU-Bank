CREATE DATABASE banking;

CREATE TABLE Users (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE bank_accounts (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  balance DECIMAL(10, 2) NOT NULL,
  account_type ENUM('Saving', 'Checking', 'Credit') NOT NULL,
  account_number VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE transactions (
  id INT NOT NULL AUTO_INCREMENT,
  sender_id INT NOT NULL,
  recipient_id INT NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (sender_id) REFERENCES bank_accounts(id),
  FOREIGN KEY (recipient_id) REFERENCES bank_accounts(id)
);

CREATE TABLE interest_rates (
  id INT NOT NULL AUTO_INCREMENT,
  account_type ENUM('Saving', 'Credit') NOT NULL,
  interest_rate DECIMAL(4, 3) NOT NULL,
  PRIMARY KEY (id)
)