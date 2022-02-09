-- get admin(admin 페이지 로그인)
create or replace procedure getAdmin(
    p_id in worker.id%type,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from worker where id=p_id;
end;