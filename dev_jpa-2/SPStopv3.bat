@echo off

::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
title SQL ���� ���º���
:LOOP
echo =================================================
echo    �ɼ��� �������ּ���.
echo    "stop | disable | enable | start"
echo    "oracle | maria"
echo =================================================
color 0E
set /p Option=�ɼ��Է�:
set /p applyDB=����DB:

if /i "%Option%" == "stop" goto:STOP
if /i "%Option%" == "disable" goto:DISABLE
if /i "%Option%" == "enable" goto:ENABLE
if /i "%Option%" == "start" goto:START

cls
goto LOOP
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

:STOP
echo SQL���񽺵��� ����ϴ�
if %applyDB% == oracle (
	net stop OracleOraDb11g_home1ClrAgent
	net stop OracleOraDb11g_home1TNSListener
	net stop OracleServiceORCL
	net stop OracleJobSchedulerORCL
	net stop OracleDBConsoleorcl
	net stop OracleVssWriterORCL
)
if %applyDB% == maria (
	net stop MariaDB
	)
goto:EXIT

:DISABLE
echo SQL���񽺵��� ��� �� ������ �����մϴ�
if %applyDB% == oracle (
	sc config OracleOraDb11g_home1ClrAgent start= disabled                      
	sc config OracleOraDb11g_home1TNSListener start= disabled
	sc config OracleServiceORCL start= disabled
	sc config OracleJobSchedulerORCL start= disabled
	sc config OracleDBConsoleorcl start= disabled
	sc config OracleVssWriterORCL start= disabled
)
if %applyDB% == maria (
	sc config MariaDB start= disabled
)
goto:EXIT


:ENABLE
echo SQL���񽺵��� ��������� �����մϴ�
if %applyDB% == oracle (
	sc config OracleOraDb11g_home1ClrAgent start= demand
	sc config OracleOraDb11g_home1TNSListener start= demand
	sc config OracleServiceORCL start= demand
	sc config OracleJobSchedulerORCL start= demand
	sc config OracleDBConsoleorcl start= demand
	sc config OracleVssWriterORCL start= demand
)
if %applyDB% == maria (
	sc config MariaDB start= demand
)
goto:EXIT


:START
echo SQL���񽺵��� �����մϴ�
if %applyDB% == oracle (
	sc start OracleOraDb11g_home1ClrAgent
	sc start OracleOraDb11g_home1TNSListener
	sc start OracleServiceORCL
	sc start OracleJobSchedulerORCL
	sc start OracleDBConsoleorcl
	sc start OracleVssWriterORCL
)
if %applyDB% == maria (
	sc start MariaDB
)
goto:EXIT


:EXIT
echo �۾��� �Ϸ�Ǿ����ϴ�.
set /p oneMore=�߰� �۾��� �����Ű���(y/n):
if /i %oneMore% == y (goto:LOOP)
pause
