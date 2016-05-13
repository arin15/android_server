<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<META charset="UTF-8">
<title>[JUI Library] - JavaScript/Tooltip</title>

<!-- <link rel="stylesheet" href="../../../custom/menual.css" /> -->
<!-- <link rel="stylesheet" href="../../dist/jui.css" /> -->
<!-- <link rel="stylesheet" href="../../dist/jennifer.theme.css" /> -->
<!-- <script src="../../lib/jquery-1.8.0.min.js"></script> -->
<!-- <script src="../../lib/jquery.binder.js"></script> -->
<!-- <script src="../../js/base.js"></script> -->
<!-- <script src="../../js/core.js"></script> -->
<!-- <script src="../../js/ui/dropdown.js"></script> -->
<!-- <script src="../../js/ui/modal.js"></script> -->
<!-- <script src="../../js/uix/table.js"></script> -->
<!-- <script src="../../js/uix/xtable.js"></script> -->

<link rel="stylesheet" href="/resources/script/jui-develop/dist/jui.css" />
<link rel="stylesheet" href="/resources/script/jui-develop/dist/jennifer.theme.css" />
<script src="/resources/script/jui-develop/lib/jquery-1.8.0.min.js"></script>
<script src="/resources/script/jui-develop/lib/jquery.binder.js"></script>
<script src="/resources/script/jui-develop/js/base.js"></script>
<script src="/resources/script/jui-develop/js/core.js"></script>
<script src="/resources/script/jui-develop/js/ui/dropdown.js"></script>
<script src="/resources/script/jui-develop/js/ui/modal.js"></script>
<script src="/resources/script/jui-develop/js/uix/table.js"></script>
<script src="/resources/script/jui-develop/js/uix/xtable.js"></script>

<script>
jui.ready(function(ui, uix, _) {
    var table_width = $("#xtable").outerWidth();
    xtable = uix.xtable("#xtable", {
        fields: [ "EMPLOYEE_ID", "FIRST_NAME", "LAST_NAME", "EMAIL", "PHONE_NUMBER" ],
        sort: true,
        sortLoading: true,
        scrollWidth: table_width,
        resize: true,
        event: {
            colmenu: function(column, e) {
                this.toggleColumnMenu(e.pageX - 25);
            },
            select: function(row, e) {
                console.log(row);
            }
        }
    });

    //xtable.update(table_data);
    
});

var xtable_1_submit = function() {
	$.ajax({
        url        : "/example/selSampleEmpList_xtable.gs"
       ,type       : "GET"
       ,async      : true
       ,data       : { param1 : "yes" }
       ,dataType   : "json"
       ,exception : function(response) {
       }
       ,success:function(response){
    	   //alert(response.result);
    	   xtable.update(response.result);
       }
   });
	
};

var xtable_1_reset = function() {
	xtable.clear();
};

</script>
</head>
<body class="jui">

<button class="btn small" onclick="xtable_1_submit()">
    <i class="icon-play"></i> Search
</button>
<button class="btn small" onclick="xtable_1_reset()">
    <i class="icon-play"></i> reset
</button>
<br>
<div id="xtable" class="xtable">
    <table class="table simple">
        <thead>
        <tr>
            <th>EMPLOYEE_ID</th>
            <th>FIRST_NAME</th>
            <th>LAST_NAME</th>
            <th>EMAIL</th>
            <th>PHONE_NUMBER</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>
<script data-jui="#xtable" data-tpl="row" type="text/template">
    <tr>
        <td><!= EMPLOYEE_ID !></td>
        <td><!= FIRST_NAME !></td>
        <td><!= LAST_NAME !></td>
		<td><!= EMAIL !></td>
        <td><!= PHONE_NUMBER !></td>
    </tr>
</script>

<script data-jui="#xtable" data-tpl="loading" type="text/template">
    <div class="loading"></div>
</script>

<script data-jui="#xtable" data-tpl="none" type="text/template">
    <tr>
        <td colspan="8" class="none" align="center">Data does not exist.</td>
    </tr>
</script>

</body>
</html>