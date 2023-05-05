package com.guo.roy.research.testing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by apple on 2019/4/8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TestVO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String field1;
    private String field2;
    private String field3;
    private String field4;

    private List<String> field4s;

}
