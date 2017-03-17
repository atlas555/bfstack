package com.bf.blog.exceptions;

import com.bf.blog.enums.ErrorCodeEnum;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SuppressWarnings("serial")
public class BfstackServiceException extends Exception {

    /**
     * @param ece
     *            ErrorCodeEnum
     * @param args
     *            格式化时要用到的参数列表，可以为空
     * @return 用ErrorCodeEnum中的code作为code，
     *         用msg格式化参数列表args后的值作为errorMessage，来生成异常
     */
    public static BfstackServiceException format(ErrorCodeEnum ece, Object... args) {
        if (ece == null) {
            ece = ErrorCodeEnum.UNKNOWN_ERROR;
        }
        int code = ece.getErrorCode();
        String errorMessage = String.format(ece.getErrorMsg(), args);
        return new BfstackServiceException(code, errorMessage);
    }

    /**
     * @return 在ErrorCodeEnum之后增加args中的参数,来生成异常
     */
    public static BfstackServiceException append(ErrorCodeEnum ece, Object... args) {
        if (ece == null) {
            ece = ErrorCodeEnum.UNKNOWN_ERROR;
        }
        if (args == null || args.length <= 0) {
            return new BfstackServiceException(ece);
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : args) {
            sb.append(obj);
        }
        return new BfstackServiceException(ece, ":", sb);
    }

    /**
     * @return 根据一个异常来生成TeachApplicationException
     */
    public static BfstackServiceException newException(Exception e) {
        if (e == null) {
            return new BfstackServiceException(ErrorCodeEnum.UNKNOWN_ERROR, "e==null");
        }
        if (e instanceof BfstackServiceException) {
            return (BfstackServiceException) e;
        }
        int code = ErrorCodeEnum.UNKNOWN_ERROR.getErrorCode();
        String msg = e.getClass().getSimpleName() + ':' + e.getMessage();
        return new BfstackServiceException(code, msg);
    }

    /**
     * @return 根据errorCode和errorMsg得到description
     */
    private static String getDescription(int errorCode, String errorMsg) {
        return BfstackServiceException.class.getSimpleName() + ":errorCode=" + errorCode + ",errorMsg=" + errorMsg;
    }

    /**
     * @return 根据一个ErrorCodeEnum和不定长数组args得到errorMsg.
     *         把args的内容添加到ErrorCodeEnum的errorMsg后面
     */
    private static String getErrorMsg(ErrorCodeEnum e, Object... args) {
        String errorMsg = e.getErrorMsg();
        if (args == null || args.length <= 0) {
            return errorMsg;
        }
        StringBuilder sb = new StringBuilder(errorMsg);
        for (Object obj : args) {
            sb.append(obj);
        }
        errorMsg = sb.toString();
        return errorMsg;
    }

    private final int errorCode;

    private final String errorMsg;

    private ObjectNode errorData = null;

    private ErrorCodeEnum errorCodeEnum;

    public BfstackServiceException(int errorCode, String errorMsg, ObjectNode errorData) {
        super(getDescription(errorCode, errorMsg));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    public BfstackServiceException(int errorCode, String errorMsg) {
        super(getDescription(errorCode, errorMsg));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BfstackServiceException(ErrorCodeEnum e) {
        this(e.getErrorCode(), e.getErrorMsg());
        this.errorCodeEnum = e;
    }

    public BfstackServiceException(ErrorCodeEnum e, Object... args) {
        this(e.getErrorCode(), getErrorMsg(e, args));
        this.errorCodeEnum = e;
    }

    public BfstackServiceException(ErrorCodeEnum e, ObjectNode errorData) {
        this(e.getErrorCode(), e.getErrorMsg(), errorData);
        this.errorCodeEnum = e;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public ErrorCodeEnum getCodeEnum() {
        if (errorCodeEnum == null) {
            return ErrorCodeEnum.UNKNOWN_ERROR;
        }
        return errorCodeEnum;
    }

    public ObjectNode getErrorData() {
        return errorData;
    }

    @Override
    public String toString() {
        return "GiraffeServiceException{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", errorData=" + errorData +
                ", errorCodeEnum=" + errorCodeEnum +
                '}';
    }
}
