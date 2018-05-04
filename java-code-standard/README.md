

## 1.接口规范
> 1
```json
{
	"data": {},
	"status": 1,
	"message": "成功",
	"errorCode": null
}
```
> 2 分页响应
```json
{
	"data": [],
	"totalRow": 102
}
```

> [lockback.xml](https://github.com/fanhuajun/java-demo/tree/master/java-code-standard/src/main/resources/conf/logback.xml)


# 2日志规范
> 用户信息放入MDC
https://blog.csdn.net/u011244202/article/details/54730374

```sql
create table seckill (
  seckillId bigint unsigned not null auto_increment,
  name varchar(8) default null,
  number int(4) default 0,
  startTime datetime default null,
  endTime datetime default null,
  createTime datetime default null,

)
```