
create or replace PROCEDURE selectHotelmember (
    p_id IN hotelmember.id%type,
    p_rc OUT SYS_REFCURSOR )
IS
BEGIN
    OPEN p_rc FOR
        select * from hotelmember where id=p_id;
END;