<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>更改口令</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
	<style>
		.updpwd{
			background-color: #2ae;
		}
		.login_btn{
			background-color: #9be;
			width: 99px;
			font-size: 14px;
			font-family: 微软雅黑;
		}
		.upd_pwd_msg{
			font-size: 14px;
			text-align: right;
		}
	</style>
	<script  type="text/javascript">
		function closeWindow(){
//			if(flag == 'change'){
//				//alert('修改完毕');
//			}
			parent.window.opener = null;
			parent.close();
		}

	</script>
</head>

<body class="updpwd">
<s:form  action="updatePwd" method="POST">
	<table style="width: 200px">
		<%--<tr>--%>
			<%--<td colspan="2">--%>
				<%--<span id="msgId" class="upd_pwd_msg"><s:fielderror></s:fielderror> </span>--%>
			<%--</td>--%>
		<%--</tr>--%>
		<tr>
			<td>原始密码：</td>
			<td><s:password id="oldPassword" name="oldPassword"></s:password></td>
			<%--<td><s:fielderror fieldName="oldPassword"/> </td>--%>
		</tr>
		<tr>
			<td>新&nbsp;密&nbsp;码：</td>
			<td><s:password id="newPassword" name="newPassword"></s:password></td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><s:password id="reNewPassword" name="reNewPassword" ></s:password></td>
		</tr>
		<tr>
			<td colspan="2">
				<s:submit cssClass="login_btn"  value="修改" ></s:submit>
				<s:reset type="button" cssClass="login_btn" onclick="closeWindow()" value="关闭" ></s:reset>
			</td>
		</tr>
	</table>
</s:form>
</body>
<script type="text/javascript">

    function createXMLHttpRequest() {
        try {
            return new XMLHttpRequest();
        } catch (e) {
            try {
                return new ActiveXObject("Msxml2.HTTP");
            } catch (e) {
                try {
                    return new ActiveXObject("Microsoft.HTTP");
                } catch (e) {
                    throw e;
                }
            }
        }
    }




	function closeWindow() {
		window.location.href = "/staffAction_logout"
    }
    <%--function update() {--%>
	    <%--var xmlHttpRequest = createXMLHttpRequest();--%>
	    <%--xmlHttpRequest.onreadystatechange = function () {--%>
            <%--if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {--%>
                <%--var responseText = xmlHttpRequest.responseText;--%>

            <%--}--%>
        <%--};--%>
         <%--var url = "/updatePwd.actiion";--%>
	    <%--xmlHttpRequest.open("post",url)--%>
			<%--xmlHttpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");--%>

	        <%--var oldPassword = document.getElementById("oldPassword").value;--%>
	        <%--var newPassword = document.getElementById("newPassword").value;--%>
	        <%--var reNewPassword = document.getElementById("reNewPassword").value;--%>
           <%--var body = "oldPassword="+oldPassword+"&newPassword="+newPassword+"&reNewPassword=" + reNewPassword;--%>
            <%--xmlHttpRequest.send(body);--%>


    <%--}--%>
</script>

</html>
