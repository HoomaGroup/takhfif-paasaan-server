<%--
  User: Emad
  Date: 11/20/15
  Time: 12:06 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>تخفیف پاسان</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-rtl.min.css" rel="stylesheet">
    <link href="css/jquery-ui.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link href="css/sb-admin-rtl.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span class="navbar-brand" href="index.html">تخفیف پاسان</span>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-left top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> عماد بیات <b
                        class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="#"><i class="fa fa-fw fa-gear"></i> تنظیمات</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-power-off"></i>خروج</a>
                    </li>
                </ul>
            </li>
        </ul>

        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li>
                    <a href="#" id="paymentIdGenerator"><i class="fa fa-fw fa-dashboard"></i> صدور فاکتور</a>
                </li>
                <li>
                    <a href="#" id="paymentsReport"><i class="fa fa-fw fa-edit"></i>گزارش پرداخت ها</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">


    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<script src="<c:url value="js/jquery.js"/>" type="text/javascript"></script>
<script src="<c:url value="js/jquery-ui.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="js/plugins/jquery.qrcode-0.12.0.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="js/plugins/noty/jquery.noty.packaged.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="js/l10n-fa.js"/>" type="text/javascript"></script>
<script>

    //set default menu
    changeContent('paymentIdGenerator');

    $('#paymentIdGenerator').on("click", function () {
        changeContent('paymentIdGenerator');
    });

    $('#paymentsReport').on("click", function () {
        changeContent('paymentsReport');
    });

    function changeContent(page) {
        $('#page-wrapper').load('/web/adminconsole/admin/' + page, function(e){
        });
    }

</script>

</body>

</html>