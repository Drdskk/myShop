package com.cql.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cql.mapper")
public class MapperConfiguration {
}
