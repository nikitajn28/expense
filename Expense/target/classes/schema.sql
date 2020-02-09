DROP TABLE IF EXISTS user;
CREATE TABLE user(
  id  LONG(32760) PRIMARY KEY,
  name char(255),
email char(255)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category(
    id LONG(32760) PRIMARY KEY,
    categoryName varchar(255)
);


DROP TABLE IF EXISTS expense;
CREATE TABLE expense(
    id LONG(32760) PRIMARY KEY,
    description varchar(255),
    date varchar(255),
  location varchar(255),
   category_id LONG(32760),
   user_id LONG(32760)
   
);




 


