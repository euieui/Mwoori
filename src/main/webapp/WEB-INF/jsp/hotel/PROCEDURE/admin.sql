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
    p_key in varchar2,
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


-----admin room get all count with key
create or replace procedure getAllCountRoom(
    p_key in varchar2,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from hotel where hotelnum like '%'||to_number(p_key)||'%';
    p_cnt:=v_cnt;
end;


-----admin room list
create or replace procedure getAllRoomList(
    p_startnum in number,
    p_endnum in number,
    p_key in varchar2,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (
		select * from ( 
		select rownum as rn, r.* from 
		( ( select * from hotel where hotelnum like '%'||to_number(p_key)||'%'
		order by hotelnum asc) r )) 
		where rn>=p_startNum ) where rn<=p_endNum;
end;


---- admin room insert


create or replace PROCEDURE insertRoom(
    p_hotelnum IN varchar2,
    p_persons IN varchar2,
    p_price IN varchar2,
    p_img IN varchar2,
    p_roomsize IN varchar2,
    p_kind IN varchar2
)
IS
BEGIN
    insert into hotel (hotelnum, persons, price, img, roomsize, kind) 
		values(to_number(p_hotelnum), to_number(p_persons), to_number(p_price), p_img,
		 to_number(p_roomsize), p_kind);
    commit;
END;


create or replace procedure getRoom(
    p_hotelnum in varchar2,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from hotel where hotelnum=to_number(p_hotelnum);
end;



create or replace procedure deleteRoom (
    p_hotelnum in varchar2)
IS
BEGIN
    delete hotel where hotelnum=to_number(p_hotelnum)
    commit;
END;

