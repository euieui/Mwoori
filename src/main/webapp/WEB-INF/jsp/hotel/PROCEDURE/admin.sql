-- get admin(admin ?˜?´ì§? ë¡œê·¸?¸)
create or replace procedure getAdmin(
    p_id in worker.id%type,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from worker where id=p_id;
end;


----admin member get all count with key
create or replace procedure getAllCountMember(
    p_key in varchar2
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from hotelmember where id like '%'||p_key||'%' or name like '%'||p_key||'%';
    p_cnt:=v_cnt;
end;

-----admin member list
create or replace procedure listMember(
    p_startnum in number,
    p_endnum in number,
    p_key in varchar2,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from ( select * from (
        select rownum as rn, m.* from ( (select * from hotelmember where id like '%'||p_key||'%' 
        or name like '%'||p_key||'%') m)
        ) where rn >= p_startnum ) where rn <= p_endnum ;
end;
