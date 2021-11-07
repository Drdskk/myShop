package com.cql.service;

import com.cql.entity.Goods;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface GoodsService {
    List<Goods> getGoods(Goods goods);
    Integer addGoods(Goods goods);
    Integer setGoods(Goods goods);
    Integer delGoods(Goods goods);
    Integer picUpload(HttpServletRequest request,MultipartFile file,Goods goods);
}
