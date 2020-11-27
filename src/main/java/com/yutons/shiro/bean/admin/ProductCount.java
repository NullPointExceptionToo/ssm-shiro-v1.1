package com.yutons.shiro.bean.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCount {
	private Integer pid;
	private String proName;
	private Integer proCount;
	private Integer sellCount;
	private Integer restCount;
}
