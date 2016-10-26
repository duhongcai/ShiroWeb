<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/19
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/shiroWeb/assert/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/shiroWeb/assert/bootstrap/css/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link href="/shiroWeb/assert/plugins/bootstrap-daterangepicker/css/daterangepicker.css" rel="stylesheet"
          type="text/css">
    <link href="/shiroWeb/assert/plugins/bootstrap-daterangepicker/css/daterangepicker.scss" rel="stylesheet"
          type="text/css">
    <link href="/shiroWeb/assert/plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" type="text/css">
    <link href="/shiroWeb/assert/css/reset.css" rel="stylesheet" type="text/css">
    <link href="/shiroWeb/assert/css/style.css" rel="stylesheet" type="text/css">
    <link href="/shiroWeb/assert/css/render-bootstarp.css" rel="stylesheet" type="text/css">
    <link href="/shiroWeb/assert/css/local.css" rel="stylesheet" type="text/css">
    <link href="/shiroWeb/assert/css/fonts/font.css" type="text/css" rel="stylesheet">

    <script src="/shiroWeb/assert/plugins/jquery-1.10.2.min.js"></script>
    <script src="/shiroWeb/assert/plugins/bootstrap-daterangepicker/js/moment.js" type="text/javascript"></script>
    <script src="/shiroWeb/assert/bootstrap/js/bootstrap.min.js"></script>
    <script src="/shiroWeb/assert/bootstrap/js/bootstrap-table.js" type="text/javascript"></script>
    <script src="/shiroWeb/assert/bootstrap/js/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
    <script src="/shiroWeb/assert/plugins/bootstrap-daterangepicker/js/daterangepicker.js"
            type="text/javascript"></script>
    <script src="/shiroWeb/assert/plugins/bootstrap-select/js/bootstrap-select.js" type="text/javascript"></script>
    <script src="/shiroWeb/assert/js/yCloud.js" type="text/javascript"></script>
    <script src="/shiroWeb/assert/plugins/bootstrap-daterangepicker/js/datetimepicker.zh-CN.js"
            type="text/javascript"></script>
    <script type="text/javascript">

        var SystemOrder = SystemOrder || {};

            $.ajax({
                type:'post',
                dataType:'JSON',
                url:'initTime',
                error:function(){
                    alert("弄啥嘞！！！！！！！！")
                },
                success:function(data){
                    SystemOrder.initPageDate(data);
                }
            })


        SystemOrder.initPageDate = function (data) {
            //登陆日志-日期范围
            $('#dateRange_login').daterangepicker(
                    {
                        "ranges": {
                            '今天': [moment(), moment()],
                            '昨天': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                            '近7天': [moment().subtract(6, 'days'), moment()],
                        },
                        "startDate": data.lastDay,
                        "endDate": data.today,
                        showDropdowns: true
                    });
        }
        $(document).ready(function () {
            $('#table').bootstrapTable({
                method: 'post',
                url: 'initDate',
                striped: true,
                queryParams: queryOrderParam,
                pagination: true,
                singleSelect: false,
                silent: true,
                sidePagination: 'server',
                pageList: [10, 15, 50],
                contentType: 'application/x-www-form-urlencoded',
                columns: [
                    {
                        field: 'cusId',
                        title: '客户编号',
                        align: 'center'
                    }, {
                        field: 'cusName',
                        title: '客户名称',
                        align: 'center'
                    }, {
                        field: 'cusProvices',
                        title: '地区',
                        align: 'center'
                    }, {
                        field: 'cusType',
                        title: '类型',
                        align: 'center'
                    }, {
                        filed: '',
                        title: '操作',
                        align: 'center'
                    }],
                formatLoadingMessage: function () {
                    return '请稍等，正在加载中...';
                },
                formatNoMatches: function () {
                    return '无符合条件的记录';
                },
                onLoadError: function (data) {
                    $('#table').bootstrapTable('removeAll');
                }
            });
            $('#dateRange_login').daterangepicker(
                    {
                        "ranges": {
                            '今天': [moment(), moment()],
                            '昨天': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                            '近7天': [moment().subtract(6, 'days'), moment()],
                        },
                        "startDate": data.last7Days,
                        "endDate": data.today,
                        showDropdowns: true
                    });
            function queryOrderParam(param) {
                var temp = {
                    offset: param.offset,
                    limit: param.limit
                }
                return temp;
            }
        })
    </script>
</head>
<body>
<div class="container frameset">
    <div class="table-content">
        <!--查询区域-->
        <div class="tab-pane">
            <form class="form form-horizontal margin20">
                <fieldset>
                    <div class="query-spacing"><label>时间选择：</label></div>
                    <div class="query-inline-block glyph-icon date-range-width">
                        <input type="text" id="dateRange_login" class="form-control">
                        <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                    </div>
                    <!--查询按钮-->
                    <div class="query-spacing">
                        <a id="queryDataBut_login" class="btn btn-primary so-btn" style="margin: 10px">查询</a>
                        <a id="queryDataBut_out" class="btn btn-primary so-btn" style="margin: 10px">导出</a>
                    </div>
                </fieldset>
            </form>
            <!--查询结果-->
            <div class="powertable"><table id="table" name="table"></table></div>
        </div>
    </div>
</div>
</body>
</html>