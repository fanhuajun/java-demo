
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
						uId INT PRIMARY KEY AUTO_INCREMENT,
						userName VARCHAR(20),
						openId VARCHAR(255) ,
						createTime DATETIME COMMENT '创建时间  默认精确到秒'
						)ENGINE=INNODB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
INSERT INTO w_user(userName, openId, createTime)
                  VALUE("樊华军", 'o48PpwDDICjLZzrkAxH4hZhykbKE','2017-05-15 15:18:51');

-- table address
DROP TABLE IF EXISTS w_info;
CREATE TABLE w_info(
						infoId INT PRIMARY KEY AUTO_INCREMENT,
						uId INT,
						infoDetail VARCHAR(255),
						createTime DATETIME COMMENT '创建时间  默认精确到秒'
						)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO w_info(uId,infoDetail, createTime)
                  VALUE(100, '深圳市福田','2017-05-15 15:18:51'),
                       (100, '江西省九江市','2017-05-15 15:18:51');
           
                       
-- table 关键字
DROP TABLE IF EXISTS w_keyword;
CREATE TABLE w_keyword(
						keywordId INT PRIMARY KEY AUTO_INCREMENT,
						pId INT,
						keywordName VARCHAR(255),
						infoId INT,
						uId int,
						createTime DATETIME COMMENT '创建时间  默认精确到秒'
						)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO w_keyword(keywordId, pId,keywordName, infoId, uId, createTime)
                  VALUE(1, 0, '地址', null, 100, '2017-05-15 15:18:51'),
                       (2, 1, '地址1', 1, 100, '2017-05-15 15:18:51'),
                       (3, 1, '地址2', 2, 100, '2017-05-15 15:18:51');

--SELECT * FROM test.w_info where info_id in(
--  select info_id from test.w_keyword 
--  where p_id in(SELECT keyword_id FROM test.w_keyword where keyword_name = '地址'
--  ));
--
--select * from test.w_keyword where keyword_name = '地址1';

                  
                  
                  
                  
                  
                  
                  
                  
                  