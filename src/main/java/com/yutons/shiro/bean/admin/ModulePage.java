package com.yutons.shiro.bean.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class ModulePage<T> {
    protected Integer code = 0;
    protected String msg;
    protected Integer count = 0;
    protected List<T> data;
}
