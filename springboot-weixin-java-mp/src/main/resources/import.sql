
-- talbe 城市
DROP TABLE IF EXISTS city;
CREATE TABLE city (
					id INT PRIMARY KEY AUTO_INCREMENT, 
					NAME VARCHAR(255), 
					state VARCHAR(255), 
					country VARCHAR(255)
					)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO city (NAME, state, country) 
          VALUES ('San Francisco', 'CA', 'US');

-- talbe user
DROP TABLE IF EXISTS w_user;
CREATE TABLE w_user(
						u_id INT PRIMARY KEY AUTO_INCREMENT,
						userName VARCHAR(20),
						openId VARCHAR(255) ,
						create_time DATETIME COMMENT '创建时间  默认精确到秒'
						)ENGINE=INNODB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
INSERT INTO w_user(userName, openId, create_time)
                  VALUE("樊华军", 'o48PpwDDICjLZzrkAxH4hZhykbKE','2017-05-15 15:18:51');

-- table address
DROP TABLE IF EXISTS w_address;
CREATE TABLE w_address(
						address_id INT PRIMARY KEY AUTO_INCREMENT,
						u_id INT,
						address_name VARCHAR(255),
						create_time DATETIME COMMENT '创建时间  默认精确到秒'
						)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO w_address(u_id,address_name, create_time)
                  VALUE(100, '深圳市','2017-05-15 15:18:51');
                  
                  
                  
                  
                  
                  
                  
                  
                  