<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <c:set var="uri" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新增-订单 </title>
    <meta name="Copyright" content="Douco Design."/>
    <link href="${pageContext.request.contextPath}/static/admin/css/public.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/global.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/jquery.tab.js"></script>

    <style type="text/css">

        .loadingModel {
            position: absolute;
            top: 0;
            left: 0;
            display: none;
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
    </style>
</head>

<body style="background-color:white">

<div id="mMain">
    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3>新增-订单</h3>

        <div class="system">
            <div>
                <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">

                    <!-- 显示第一个自习室号的行 -->
                    <tr id="orderDateParentContent2">
                        <td align="right">自习室号</td>
                        <td>
                            <div style="width:720px;">
                                <!-- 检查列表是否不为空，然后显示第一个自习室号 -->
                                <c:if test="${not empty list}">
                                    <p style="display:inline-block; width:500px; margin-right:10px;">
                                            ${list[0].deskId}
                                    </p>
                                </c:if>
                                <!-- 如果列表为空，可以显示一个占位符或提示信息 -->
                                <c:if test="${empty list}">
                                    <p style="display:inline-block; width:500px; margin-right:10px;">
                                        （没有自习室信息）
                                    </p>
                                </c:if>
                            </div>
                        </td>
                    </tr>
                    <tr id="orderDateParentContent1">
                        <td align="right">座位号</td>
                        <td>
                            <div style="width:720px;">
                                <select style="width:500px;color:black" id="seatId">
                                    <c:forEach var="item" items="${list}">
                                        <option value="${item.id}">${item.seatNo }</option>
                                    </c:forEach>
                                </select>
                                <span style="color:red">*必填</span>
                            </div>
                        </td>
                    </tr>

                    <tr id="orderDateParentContent">
                        <td align="right">预约日期</td>
                        <td>
                            <div style="width:720px;"><input type="text" class="inpMain Wdate" readonly="readonly"
                                                             style="color:black;width:500px;"
                                                             onFocus="WdatePicker({startDate: '%y-%M-%d' })"
                                                             placeholder="请输入预约日期" id="orderDate"> <span
                                    style="color:red">*必填</span>
                            </div>
                        </td>
                    </tr>

                    <tr id="startTimeParentContent">
                        <td align="right">开始时间</td>
                        <td>
                            <div style="width:720px;">

                                <select style="width:500px;color:black" id="startTime">
                                    <c:forEach var="item" items="${timeList}">
                                        <option value="${item.id}">${item.name }</option>
                                    </c:forEach>
                                </select>

                                <span style="color:red">*必填</span>
                            </div>
                        </td>
                    </tr>

                    <tr id="endTimeParentContent">
                        <td align="right">结束时间</td>
                        <td>
                            <div style="width:720px;">
                                <select style="width:500px;color:black" id="endTime">
                                    <c:forEach var="item" items="${timeList}">
                                        <option value="${item.id}">${item.name }</option>
                                    </c:forEach>
                                </select>
                                <span style="color:red">*必填</span>
                            </div>
                        </td>
                    </tr>


                    <tr>
                        <td width="131"></td>
                        <td>

                            <a class="btnGreen" href="javascript:;" onclick="submitData();"
                               style="margin-left:30px;">提交</a>
                            <a class="btnGray" href="javascript:;" onclick="javascript:history.back(-1);"
                               style="margin-left:30px;">返回上一步</a>
                        </td>
                    </tr>
                </table>
                <div style="height:200px"></div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/common/My97DatePicker/4.8/WdatePicker.js"></script>


<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=5768"></script>


<script type="text/javascript">


    $(function () {


    })


    function submitData() {
        var orderDate = $('#orderDate').val();
        var startTime = $('#startTime').val();
        var endTime = $('#endTime').val();
        var seatId = $('#seatId').val();

        if (startTime != '') {
            if (isIntNum(startTime) == false) {
                alert("开始时间必须填入整数");
                return;
            }
        }
        if (endTime != '') {
            if (isIntNum(endTime) == false) {
                alert("结束时间必须填入整数");
                return;
            }
        }
        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/user/order_info/order_desk_submit',
            data: {
                "deskId": "${data.deskId}",
                "orderDate": orderDate,
                "startTime": startTime,
                "endTime": endTime,
                "seatId": seatId
            },
            success: function (result) {
                if (result.code == 0) {
                    alert(result.msg);
                } else {
                    alert(result.msg);
                    window.location.href = "${pageContext.request.contextPath}/user/order_info";
                }
            }
        });
    }


</script>
</body>
</html>
