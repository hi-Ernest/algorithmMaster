-- 秒杀执行存储过程
delimiter $$

create procedure `seckill`.`execute_seckill`
    (in v_seckill_id bigint,in v_phone bigint,
     in v_kill_time timestamp, out r_result int)
     BEGIN
        declare insert_count int DEFAULT 0;
        START transaction;
        insert ignore into success_killed
            (seckill_id, user_phone, create_time)
            values (v_seckill_id, v_phone, v_kill_time);
        select row_count() into insert_count;
        IF (insert_count = 0) then
            rollback;
            set r_result = -1;
        elseif (insert_count < 0) then
            rollback;
            set r_result = -2;
        else
            update seckill
            set number = number -1;
            where seckill_id = v_seckill_id
              and end_time > v_kill_time
              and start_time < v_kill_time
              and number > 0;
            select row_count() into insert_count;
            IF (insert_count = 0) then
                rollback;
                set r_result = -2;
            else
                commit;
                set r_result = 1;
            end IF;
        end IF;
    end;
$$
--  存储过程定义结束

set @r_result = -3;
-- 执行存储过程
call execute seckill(1003, 17783390229, now(), @r_result);
-- 获取结果
select @r_result;
