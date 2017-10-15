<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>中国移动业务管理系统</TITLE>
<link href="css/style.css" rel="stylesheet" type="text/css">
${msg }
</HEAD>
<BODY LEFTMARGIN=0 MARGINWIDTH=0>
	<TABLE WIDTH=750 BORDER=0 align="center" CELLPADDING=0 CELLSPACING=0>
		<TR>
			<TD ROWSPAN=2><IMG SRC="images/index_01.gif" WIDTH=444
				HEIGHT=237 ALT=""></TD>
			<TD><IMG SRC="images/index_02.gif" WIDTH=306 HEIGHT=99 ALT=""></TD>
		</TR>
		<TR>
			<TD><IMG SRC="images/index_03.gif" WIDTH=306 HEIGHT=138 ALT=""></TD>
		</TR>
		<TR>
			<TD ROWSPAN=2><IMG SRC="images/index_04.gif" WIDTH=444
				HEIGHT=363 ALT=""></TD>
			<TD width="306" height="185" background="images/index_05.gif"><table
					width="250" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><form action="Login" method=post>
								<div align="center">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td height="30"><div align="center">
													<strong>用户名：</strong> <INPUT name=username type="text"
														value="${cookie.username.value }"> <br>
												</div></td>
										</tr>
										<tr>
											<td height="30"><div align="center">
													<strong>密&nbsp;&nbsp;&nbsp;码：</strong> <INPUT name=password
														type=password value="${cookie.password.value }">
												</div></td>
										</tr>
										<tr>
											<td height="30"><div align="center">
													<strong>记住密码：</strong> <INPUT name="remember"
														type="checkbox" value="yes">
												</div></td>
										</tr>
										<tr>
											<td height="30">
												<div align="center">
													<INPUT class=f2 type=submit size=4 value=进入系统 name=Submit>
												</div>
											</td>
										</tr>
									</table>
								</div>
							</form></td>
					</tr>
				</table></TD>
		</TR>
		<TR>
			<TD><IMG SRC="images/index_06.gif" WIDTH=306 HEIGHT=178 ALT=""></TD>
		</TR>
	</TABLE>
	<!-- End ImageReady Slices -->
</BODY>
</HTML>