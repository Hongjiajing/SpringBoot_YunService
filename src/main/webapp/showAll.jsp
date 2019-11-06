<%@page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>SpringBoot</title>
    <meta charset="UTF-8"/>
    <!--BootStrap的css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/BootStrap/css/bootstrap.css">
    <!--BootStrap+jqGrid的css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Boot-jqGrid/css/trirand/ui.jqgrid-bootstrap.css">
    <!--普通js-->
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <!--BootStrapjs-->
    <script src="${pageContext.request.contextPath}/BootStrap/js/bootstrap.js"></script>
    <!--BootStrap+jqGrid的国际版js-->
    <script src="${pageContext.request.contextPath}/Boot-jqGrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <!--BootStrap+jqGrid的js-->
    <script src="${pageContext.request.contextPath}/Boot-jqGrid/js/trirand/jquery.jqGrid.min.js"></script>
    <style>
    </style>
    <script type="application/javascript">
        $(function () {
            $("#table").jqGrid({
                styleUI:"Bootstrap",
                url:"${pageContext.request.contextPath}/User/queryAll",
                datatype:"json",
                cellEdit:true,
                caption:"我的SpringBoot用户表",
                pager:"#pager",
                page:1,
                rowNum:3,
                rowList:[3, 5, 7],
                viewrecords:true,
                editurl:"${pageContext.request.contextPath}/User/edit",
                colNames:["编号", "姓名", "年龄","性别","状态", "操作"],
                colModel:[
                    {name:"id"},
                    {name:"username",editable:true,},
                    {name:"age",editable:true,},
                    {name:"sex",editable:true,},
                    {name:"status",align:"center",formatter:function (cellvalue, options, rowObject) {
                                if(rowObject.status!==null)
                                    return "<a class='btn btn-warning' onclick=\"editStatus('" + rowObject.status +","+ rowObject.id + "')\">"+rowObject.status+"</a>";
                            }
                        },
                    {name:"edit",
                        formatter:function (cellvalue, options, rowObject) {
                            return  "<a class='btn btn-success' onclick=\"deleteUser('" + rowObject.id + "')\">删除</a>"
                                +"&nbsp;"+
                            "<a class='btn btn-danger' onclick=\"updateUser('" + rowObject.id + "')\">修改</a>";
                                }
                            }
                        ]
            }).jqGrid("navGrid", "#pager", {edit: true});
        });

        function deleteUser(id) {
            if (id != null)
                $("#table").jqGrid('delGridRow', id, {
                    height: 300,
                    reloadAfterSubmit: true
                });
            else
                alert("请选择一行");
        };
        function updateUser(id) {
            if (id != null)
                $("#table").jqGrid('editGridRow', id, {
                    height: 300,
                    reloadAfterSubmit: true
                });
            else
                alert("请选择一行");
        };
        function editStatus(status) {
            if(status!=null){
                console.log(status);
                window.location.href="${pageContext.request.contextPath}/User/editStatus?status="+status;
            }
        };
    </script>
</head>
<body>
    <table id="table"></table>
    <div id="pager" style="height: 38px;"></div>
</body>
</html>