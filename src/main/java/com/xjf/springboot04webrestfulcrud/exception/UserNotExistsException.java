package com.xjf.springboot04webrestfulcrud.exception;

/**
 * @author xjf
 * @date 2019/1/18 14:35
 */

/**
 * 用户不存在异常
 */
public class UserNotExistsException extends Exception{
    public UserNotExistsException() {
        super("用户不存在");
    }
}
