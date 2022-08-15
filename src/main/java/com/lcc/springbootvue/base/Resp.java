package com.lcc.springbootvue.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lcc.springbootvue.constant.enums.ResultCodeEnum;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 通用的json返回体
 *
 * @param <T>
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Resp<T> {

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private T data;

    public Resp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> Resp<T> of(Codes code) {
        return new Resp<T>(code.getCode(), code.getMessage());
    }

    public static <T> Resp<T> of(int code, String msg) {
        return new Resp<T>(code, msg);
    }

    public static <T> Resp<T> of(int code, String msg, T data) {
        return new Resp<T>(code, msg).setData(data);
    }

    /**
     * 成功的响应
     */
    public static <T> Resp<T> suc() {
        return of(Codes.SUC.getCode(), Codes.SUC.getMessage(), null);
    }

    public static <T> Resp<T> suc(T data) {
        if (data instanceof String) {
            return of(Codes.SUC.getCode(), (String) data, data);
        }
        return of(Codes.SUC.getCode(), Codes.SUC.getMessage(), data);
    }

    public static <T> Resp<T> suc(T data, String msg) {
        return of(Codes.SUC.getCode(), msg, data);
    }

//    /**
//     * 分页返回
//     *
//     * @param page mybatisPlus 的 封装 Ipage
//     * @return 分页的 resp json
//     */
//    public static <T> Resp<PageData<T>> sucPage(IPage<T> page) {
//        PageInfo pageInfo = new PageInfo(page.getCurrent(), page.getPages(), page.getTotal());
//        PageData<T> pageData = new PageData<>(pageInfo, page.getRecords());
//        return suc(pageData);
//    }

    /**
     * fail的响应
     */
    public static <T> Resp<T> fail() {
        return of(Codes.FAIL);
    }

    public static <T> Resp<T> fail(String msg) {
        return of(Codes.FAIL.getCode(), msg);
    }

    public static <T> Resp<T> fail(ResultCodeEnum code) {
        return of(code.getCode(), code.getDescription());
    }

    public static <T> Resp<T> fail(ResultCodeEnum code, String msg) {
        return of(code.getCode(), msg);
    }

    public Resp<T> setData(T data) {
        this.data = data;
        return this;
    }
}
