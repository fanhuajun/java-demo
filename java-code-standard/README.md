

## 1.接口规范
```java
public class ResponseDTO<E> extends BaseObject {
    private static final long serialVersionUID = 7094474287531232051L;
    private E data; // 返回数据
    private int status;// 是否成功 ResponseStatus
    private String message; // 成功或错误提示信息
    private String errorCode;// 错误编码

}
```