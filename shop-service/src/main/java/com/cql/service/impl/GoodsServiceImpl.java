package com.cql.service.impl;

import com.cql.config.MyFileUpload;
import com.cql.config.MyUUID;
import com.cql.entity.Goods;
import com.cql.mapper.GoodsMapper;
import com.cql.service.GoodsService;
import com.cql.config.MyCurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    //项目根路径下的目录
    public final static String IMG_PATH_PREFIX="img/";
    /**
     * 查询操作
     * @param goods
     * @return  返回结果——Goods对象的List集合
     */
    @Override
    public List<Goods> getGoods(Goods goods) {
        List<Goods> goodsList=goodsMapper.getGoods(goods);
        return goodsMapper.getGoods(goods);
    }

    /**
     * 插入/修改操作
     * @param goods
     * @return  返回结果操作是否成功——0 or 1
     */
    @Override
    public Integer addGoods(Goods goods) {
        //根据id是否为空判断是插入还是修改操作
        if(goods.getId().isEmpty()){
            //添加操作
            //设置id,创建时间
            return goodsMapper.addGoods(goods.setId(MyUUID.getUUID()).setCreateTime(MyCurrentTime.getTime()));
        }else{
            //修改操作
            return goodsMapper.setGoods(goods);
        }
    }

    /**
     * 修改操作
     * @param goods
     * @return  返回删除是否成功 0 or 1
     */
    public Integer setGoods(Goods goods){
        if("0".equals(goods.getState())){
            return goodsMapper.setGoods(goods.setState("1"));
        }else {
            return goodsMapper.setGoods(goods.setState("0"));
        }
    }

    /**
     * (逻辑)删除操作
     * @param goods
     * @return  返回删除操作结果——1 or 0
     */
    @Override
    public Integer delGoods(Goods goods) {
        return goodsMapper.delGoods(goods);
    }

    /**
     * 修改操作
     * @param file
     * @param goods
     * @return  返回视图   成功-goodsPage 失败-goods-PicForm
     */
    @Override
    public Integer picUpload(HttpServletRequest request,MultipartFile file,Goods goods){
        return goodsMapper.setGoods(goods.setPicture(MyFileUpload.getUploadFileLoader(request,file)));
    }
}
