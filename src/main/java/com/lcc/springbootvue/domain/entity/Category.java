package com.lcc.springbootvue.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lcc.springbootvue.domain.CommEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("category")
public class Category  extends CommEntity {
  private static final long serialVersionUID = 1L;

  private long id;
  private long parentId;
  private String name;

}
