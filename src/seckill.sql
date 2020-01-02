-- 秒杀执行存储过程
delimiter $$

create procedure `seckill`.`execute_seckill`
    (in v_seckill_id bigint )