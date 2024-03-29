<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <c:set var="uri" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人中心</title>
    <meta name="Copyright" content=""/>
    <link href="${pageContext.request.contextPath}/static/admin/css/public.css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/common/page/myPagination.css?t=4"/>
    <style type="text/css">
        .btnStyle {
            margin-left: 8px;
            margin-top: 8px
        }

        .loadingModel {
            position: absolute;
            top: 0;
            left: 0;
            background-color: rgba(9, 9, 9, 0.63);
            width: 100%;
            height: 100%;
            z-index: 1000;
        }


        .loading-content {
            width: 50%;
            text-align: center;
            background: #ffffff;
            border-radius: 6px;
            line-height: 30px;
            z-index: 10001;
        }

        tbody > tr > th {
            padding: 10px;
        }
    </style>
</head>

<body style="background-color:white">

<div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
    <h3>个人中心</h3>

    <div id="list">
        <div>

            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">

                <thead>

                </thead>
                <tbody>
                <tr>
                    <th width="10%">登录名</th>
                    <th width="90%">${detail.userInfo.loginName}</th>
                </tr>
                <tr>
                    <th width="10%">姓名</th>
                    <th width="90%">${detail.userInfo.realName}</th>
                </tr>
                <tr>
                    <th width="10%">联系电话</th>
                    <th width="90%">${detail.userInfo.celPhone}</th>
                </tr>
                <tr>
                    <th width="10%">账号余额</th>
                    <th width="90%">${detail.userInfo.userAccount}</th>
                </tr>
                <tr>
                    <th width="10%">注册时间</th>
                    <th width="90%">${detail.userInfo.createTime}</th>
                </tr>

                </tbody>
            </table>

            <div class="action">
                <a href="${pageContext.request.contextPath}/user/user_info/update2?id=${detail.userInfo.id}"
                   class="btn">修改</a>
                <a href="${pageContext.request.contextPath}/user/deposit_log/deposit" class="btnGreen">充值</a>
            </div>

        </div>
    </div>

</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>

<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=#随机码#"></script>

<script type="text/javascript">

    $(function () {

    })
</script>

</html>
