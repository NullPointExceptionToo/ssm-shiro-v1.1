package com.yutons.shiro.bean.admin.quota;

import com.yutons.shiro.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @title: 生化筛查常规测定实体
 * @Author fq
 * @Date: 2022/3/20 14:03
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Screening extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 总蛋白
     */
    private Double total_protein;
    /**
     * 白蛋白
     */
    private Double white_protein;
    /**
     * 球蛋白
     */
    private Double circle_protein;
    /**
     * 白球蛋白比例
     */
    private Double whilte_circle_per;
    /**
     * 谷丙转氨酶
     */
    private Double aminotransferase;
    /**
     * 总胆红素
     */
    private Double all_bilirubin;
    /**
     * 直接胆红素
     */
    private Double dir_bilirubin;
    /**
     * 间接胆红素
     */
    private Double no_bilirubin;
    /**
     * 肾小球滤过率-cr
     */
    private Double glomerulus_per;
    /**
     * 肌酐
     */
    private Double jigan;
    /**
     * 尿素
     */
    private Double niaosu;
    /**
     * 尿酸
     */
    private Double niaoshuan;
    /**
     * 甘油三醇
     */
    private Double glycerol;
    /**
     * 总胆固醇
     */
    private Double all_cholesterol;
    /**
     * 高密度脂蛋白-C
     */
    private Double high_protein;
    /**
     * 空腹血糖
     */
    private Double no_glucose;
    /**
     * 钾
     */
    private Double jia;
    /**
     * 钠
     */
    private Double na;
    /**
     * 氯
     */
    private Double lv;

}
