package com.cql.service.impl;

import com.cql.config.MyFileUpload;
import com.cql.config.MyUUID;
import com.cql.entity.Goods;
import com.cql.entity.GoodsEvaluate;
import com.cql.mapper.GoodsEvaluateMapper;
import com.cql.mapper.GoodsMapper;
import com.cql.service.GoodsService;
import com.cql.config.MyCurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsEvaluateMapper goodsEvaluateMapper;

    /**
     * 查询操作
     * @param goods
     * @return  返回结果——Goods对象的List集合
     */
    @Override
//    public List<Goods> getGoods(Goods goods) {
//        return goodsMapper.getGoods(goods);
//    }
    public List<Goods> getGoods(Goods goods) {
        Double num=0.0;
        Double countLevel=0.0;

        List<Goods> goodsList=goodsMapper.getGoods(goods);
        List<GoodsEvaluate> goodsEvaluateList= goodsEvaluateMapper.getGoodsEvaluates(new GoodsEvaluate());

        //遍历并计算出平均评分，再set
        for(Goods goods1:goodsList){
            for(GoodsEvaluate goodsEvaluate:goodsEvaluateList){
                if(goods1.getId().equals(goodsEvaluate.getGoodsId())){
                    countLevel=countLevel+Integer.parseInt(goodsEvaluate.getLevel());
                    num++;
                }
            }
            goods1.setScore(String.valueOf(new DecimalFormat("#.00").format(countLevel/num)));
        }
        return goodsList;
    }

    /**
     * 插入/修改操作
     * @param goods
     * @return  返回结果操作是否成功——isZero
     */
    @Override
//    public Integer addGoods(Goods goods) {
//        //根据id是否为空判断是插入还是修改操作
//        if(goods.getId().isEmpty()){
//            //添加操作
//            //设置id,创建时间
//            return goodsMapper.addGoods(goods.setId(MyUUID.getUUID()).setCreateTime(MyCurrentTime.getTime()));
//        }else{
//            //修改操作
//            return goodsMapper.setGoods(goods);
//        }
//    }
    public Integer addGoods(Goods goods) {
        if(goods.getId().isEmpty()){
            return goodsMapper.insert(goods
                    .setId(MyUUID.getUUID())
                    .setCreateTime(MyCurrentTime.getTime())
                    .setState("0")
                    .setDelFlag("0"));
        }else{
            return goodsMapper.updateById(goods);
        }
    }

    /**
     * 修改操作
     * @param goods
     * @return  返回删除是否成功 isZero
     */
//    public Integer setGoods(Goods goods){
//        if("0".equals(goods.getState())){
//            return goodsMapper.setGoods(goods.setState("1"));
//        }else {
//            return goodsMapper.setGoods(goods.setState("0"));
//        }
//    }
    public Integer setGoods(Goods goods){
        //判断当前状态
        if("0".equals(goods.getState())){
            return goodsMapper.updateById(goods.setState("1"));
        }else {
            return goodsMapper.updateById(goods.setState("0"));
        }
    }

    /**
     * (逻辑)删除操作
     * @param goods
     * @return  返回删除操作结果——isZero
     */
    @Override
//    public Integer delGoods(Goods goods) {
//        return goodsMapper.delGoods(goods);
//    }
    public Integer delGoods(Goods goods) {
        return goodsMapper.updateById(goods.setDelFlag("1"));
    }

    /**
     * 修改操作
     * @param file
     * @param goods
     * @return  返回视图   成功-goodsPage 失败-goods-PicForm
     */
    @Override
//    public Integer picUpload(HttpServletRequest request,MultipartFile file,Goods goods){
//        return goodsMapper.setGoods(goods.setPicture(MyFileUpload.getUploadFileLoader(request,file)));
//    }
    public Integer picUpload(HttpServletRequest request,MultipartFile file,Goods goods){
        return goodsMapper.updateById(goods.setPicture(MyFileUpload.getUploadFileLoader(request,file)));
    }
}
