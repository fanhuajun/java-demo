
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

-- talbe 用户表
DROP TABLE IF EXISTS w_user;
CREATE TABLE w_user(
						uId INT PRIMARY KEY AUTO_INCREMENT,
						userName VARCHAR(20),
						openId VARCHAR(255) COMMENT '用户识别标志',
						createTime DATETIME COMMENT '创建时间  默认精确到秒'
						)ENGINE=INNODB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
INSERT INTO w_user(userName, openId, createTime)
                  VALUE("用户名1", 'o48PpwDDICjLZzrkAxH4hZhykbKE','2017-05-15 15:18:51');
---用户名1 樊华军
                  
-- table 信息表
DROP TABLE IF EXISTS w_info;
CREATE TABLE w_info(
						infoId INT PRIMARY KEY AUTO_INCREMENT,
						infoDetail VARCHAR(255),
						createTime DATETIME COMMENT '创建时间  默认精确到秒'
						)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO w_info(infoDetail, createTime)
              VALUE('深圳市福田','2017-05-15 15:18:51'),
                    ('江西省九江市','2017-05-15 15:18:51');
                        
-- table 用户、信息关联表
DROP TABLE IF EXISTS w_ref_user_info;
CREATE TABLE w_ref_user_info(
						userId INT,
						infoId INT
						)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO w_ref_user_info(userId, infoId)
              VALUE(100, 1),
                    (100, 2);
                       
-- table 关键字
DROP TABLE IF EXISTS w_keyword;
CREATE TABLE w_keyword(
						keywordId INT PRIMARY KEY AUTO_INCREMENT,
						pId INT,
						keywordName VARCHAR(255),
						infoId INT,
						createTime DATETIME COMMENT '创建时间  默认精确到秒'
						)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO w_keyword(keywordId, pId,keywordName, infoId, createTime)
                  VALUE(1, 0, '地址', null, '2017-05-15 15:18:51'),
                       (2, 1, '地址1', 1, '2017-05-15 15:18:51'),
                       (3, 1, '地址2', 2, '2017-05-15 15:18:51');

-- table 用户、关键字关联表
DROP TABLE IF EXISTS w_ref_user_keyword;
CREATE TABLE w_ref_user_keyword(
						userId INT,
						keywordId INT
						)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO w_ref_user_keyword(userId, keywordId)
              VALUE(100, 1),
                   (100, 2),
                   (100, 3);
                       
-- Command
DROP TABLE IF EXISTS w_command;
create table w_command(
                 commandId int primary key auto_increment,
                 commandCode varchar(255) comment '命令代码',
                 commandName varchar(255),
                 createTime datetime default now() comment '创建时间'
                 )engine=innodb default charset=utf8;
insert into w_command(commandCode, commandName)
               value('101-', '添加用户名');
--SELECT * FROM test.w_info where infoId in(
--  select infoId from test.w_keyword 
--  where pId in(SELECT keywordId FROM test.w_keyword where keywordName = '地址'
--  ));
--
--select * from test.w_keyword where keywordName = '地址1';

                  
                  
                  
                  
                  
                  
                  
                  
                  