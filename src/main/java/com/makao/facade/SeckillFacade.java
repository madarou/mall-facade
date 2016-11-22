package com.makao.facade;

import java.util.List;

import com.makao.dto.Exposer;
import com.makao.dto.SeckillExecution;
import com.makao.entity.Seckill;
import com.makao.exception.RepeatKillException;
import com.makao.exception.SeckillCloseException;
import com.makao.exception.SeckillException;

/**
 * @author ZYR
 * 远程调用的接口, dubbo接口
 */
public interface SeckillFacade { 
    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();


    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);


    /**
     * 秒杀开启时输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException
            , RepeatKillException, SeckillCloseException;

    /**
     * 执行秒杀操作 by 存储过程
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
