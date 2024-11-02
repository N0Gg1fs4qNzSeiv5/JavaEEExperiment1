package xyz.djma.pojo;

/**
 * web统一返回结果
 */
public class Result {
    /**
     * 标识操作是否成功<br>
     * 0 失败返回<br>
     * 1 成功返回
     */
    private int code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    private Result() {};

    private Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功的返回结果
     * @param msg 消息
     * @return Result
     */
    public static Result success(String msg) {
        return new Result(1, msg, null);
    }

    /**
     * 带有数据的成功返回结果
     * @param msg 消息
     * @param data 数据
     * @return Result
     */
    public static Result success(String msg, Object data) {
        return new Result(1, msg, data);
    }

    /**
     * 失败的返回结果
     * @param msg 消息
     * @return Result
     */
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
