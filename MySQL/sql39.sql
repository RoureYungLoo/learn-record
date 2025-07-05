select count(up.device_id) did_count, sum(up.question_cnt) question_cnt
from user_profile up
         left join question_practice_detail qpd on up.device_id = qpd.device_id
where month(qpd.date) = '8'
group by month(qpd.date);
