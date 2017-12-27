package com.cst.stream.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @author Johnney.chiu
 * create on 2017/12/12 15:22
 * @Description 描述App oil的数据
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppOilVo {
    private String id;

    private String province;

    private Double b90;

    private Double b93;

    private Double b97;

    private Double b0;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date insertTimestamp;

    private String remark;

}
