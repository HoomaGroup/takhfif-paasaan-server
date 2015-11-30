<%--
  User: Emad
  Date: 11/27/15
  Time: 2:01 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<div class="container-fluid">

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1 class="panel-title">صدور فاکتور</h1>
                </div>
                <div class="panel-body">

                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info-circle">مبلغ خرید را وارد کرده و تولید شناسه پرداخت را بزنید.</i>
                    </div>
                    <label>مبلغ (به ریال): </label>
                    <input id="amount" name="amount" class="form-control input-lg" style="width: 200px; display: inline-block">
                    <input type="submit" id="generatePayId" class="btn-lg btn-success" value="تولید شناسه پرداخت"/>

                    <div id="paymentIdInfoContainer" class="arrow_box">
                        <div id="qrCodeContainer" class="col-lg-2 col-md-2 col-sm-4 col-xs-4"></div>
                        <div class="col-lg-10 col-md-10 col-sm-8 col-xs-8" id="paymentInfo">
                            <div class="row">
                                <span id="paymentIdLabel">شناسه پرداخت:</span>
                                <span id="paymentIdValue"></span>
                            </div>
                            <div class="row">
                                <span id="paymentStatusLabel">وضعیت پرداخت:</span>
                                <span id="paymentStatusValue">در انتظار پرداخت</span>
                                <img src="<c:url value="/images/refresh.png"/>" id="refreshPaymentStatus"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->

</div>
<!-- /.container-fluid -->

<script>
    $(document).ready(function() {
        $('#amount').focus();
    });

    $('#generatePayId').on("click", function () {
        if (isValidInput()) {
            getPaymentIdInfo();
        }
    });

    $('#refreshPaymentStatus').on("click", function () {
        getPaymentStatus($('#paymentIdValue').text());
    });

    function isValidInput() {
        var amount = $('#amount').val();
        if ($.trim(amount).length > 0) {
            return true;
        } else {
            noty({
                text: 'لطفا مبلغ را وارد کنید.',
                type: 'error',
                timeout: 5000
            });
        }
    }

    function getPaymentIdInfo() {
        var amount =$('#amount').val();

        $.ajax({
            url: '/api/paasaan/generatePaymentId',
            type: 'post',
            dataType: 'json',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({amount: amount, merchantId: '1'}),

            success: function (data) {
                updatePaymentInfo(data.paymentId);

            },
            error: function (xhr, textStatus, errorThrown) {
            }
        });
    }

    function updatePaymentInfo(value) {
        $('#qrCodeContainer').empty();
        $('#paymentIdInfoContainer').removeClass('hidden');
        $("#paymentIdInfoContainer").slideDown("slow");
        $('#paymentIdValue').text(value)

        $('#qrCodeContainer').qrcode({
            "size": 100,
            "color": "#3a3",
            "text": value
        });
    }

    function getPaymentStatus(paymentId) {
        $.ajax({
            url: '/api/paasaan/searchPayment',
            type: 'post',
            dataType: 'json',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({paymentId: paymentId, merchantId: '1'}),

            success: function (data) {
                $('#paymentStatusValue').text(l10n.paymentStatus[data.paymentInfos[0].paymentStatus]);
            },
            error: function (xhr, textStatus, errorThrown) {
            }
        });
    }
</script>

</body>
</html>