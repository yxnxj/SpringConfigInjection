package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@Accessors(chain=true)
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {

    private UUID uuid;

    private String col1;

    private LocalDateTime created_at;

    public static DataDto toDto(DataEntity entity){
        DataDto toVo = DataDto.builder()
                .uuid(entity.getUuid())
                .col1(entity.getCol1())
                .created_at(entity.getCreated_at())
                .build();

        return toVo;
    }
}
