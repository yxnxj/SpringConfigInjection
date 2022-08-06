package com.example.demo;

import com.example.demo.model.DataDto;
import com.example.demo.model.DataEntity;
import com.example.demo.model.DataDto;
import com.example.demo.model.DataVo;

import java.util.Optional;
import java.util.UUID;

public class DataService {
    DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public DataVo search(Long id) {
        Optional<DataEntity> entity = dataRepository.findById(id);

        if(entity.isPresent()) {
            return DataVo.toVo(DataDto.toDto(entity.get()));
        }else {
            throw new NullPointerException();
        }
    }
}
