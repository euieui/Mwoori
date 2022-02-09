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
