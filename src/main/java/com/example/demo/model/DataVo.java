package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class DataVo {

    private final UUID uuid;

    private final String col1;

    private final LocalDateTime created_at;


    public static DataVo toVo(DataDto dto){
        DataVo toVo = DataVo.builder()
                .uuid(dto.getUuid())
                .col1(dto.getCol1())
                .created_at(dto.getCreated_at())
                .build();
        
        return toVo;
    }
}
