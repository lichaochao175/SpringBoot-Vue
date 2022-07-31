package com.lcc.springbootvue.domain.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Licc
 * @date 2022/7/30 8:40 PM
 *  公用id
 */
@Data
public class BaseId  implements Serializable {

    private Integer id;
}