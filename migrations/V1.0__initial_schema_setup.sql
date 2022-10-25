CREATE TABLE app_user( 
id serial primary key, 
name VARCHAR(255) NOT NULL, 
email_address VARCHAR(255) NOT NULL, 
dob DATE NOT NULL, 
password VARCHAR(255) NOT NULL,
user_type VARCHAR(255) NOT NULL
);