-- bookform.do  
-- 프로시저
create or replace procedure confirmRoom(
    p_checkin in book_view.checkin%type,
    p_checkout in book_view.checkout%type,
    p_kind in book_view.kind%type,
    p_usernum in book_view.usernum%type,
    p_roomnum in number,
    p_boolean out number
)
is
    vs_bookedCnt number;
    vs_maxPeopleNumber number;
    vs_maxRoomNumber number;
begin
    select count(*) into vs_bookedCnt from book_view where checkout > to_date(p_checkin,'yyyy-mm-dd') and checkin < to_date(p_checkin,'yyyy-mm-dd') and kind = p_kind;

    select distinct persons into vs_maxPeopleNumber from hotel where kind = p_kind;
    
    select count(*) into vs_maxRoomNumber from hotel where kind = p_kind;
    
    if  vs_maxPeopleNumber >= p_usernum / p_roomnum and (vs_maxRoomNumber - vs_bookedCnt) >= p_roomnum then p_boolean := 1;
    else p_boolean := 0;
    end if;
end;


-- 예약되어 있는 방 check 
-- 프로시저
create or replace procedure bookedRoom(
    p_checkin book_view.checkin%type,
    p_checkout book_view.checkout%type,
    p_kind book_view.kind%type,
    p_rc out sys_refcursor
    
)
is
begin
    open p_rc for
    select hotelnum from book_view where checkout > to_date(p_checkin,'yyyy-mm-dd') 
		and checkin < to_date(p_checkout,'yyyy-mm-dd') and kind = p_kind;
end;


-- kind 에 따른 총 방 갯수
-- 프로시저
create or replace procedure selectRoomNum(
    p_kind hotel.kind%type,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
    select hotelnum from hotel where kind=p_kind;
end;