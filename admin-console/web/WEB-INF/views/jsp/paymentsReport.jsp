<%--
  User: Emad
  Date: 11/29/15
  Time: 7:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>گزارش وضعیت پرداخت ها</title>
    <link href="css/jquery-ui.min.css" rel="stylesheet">
</head>
<body>

<div class="container-fluid">

    <div id="searchBox">
        <label>شناسه پرداخت: </label>
        <input id="paymentId" name="paymentId" class="form-control input-lg" style="width: 200px; display: inline-block">
        <input type="submit" id="searchPaymentId" class="btn-lg btn-primary" value="جستجو"/>
    </div>

    <div id="paymentsTable">

        <div class="panel panel-default">
            <div class="panel-heading">گزارش وضعیت پرداخت ها</div>

            <table class="table">
               <thead>
                <tr>
                    <th>شناسه پرداخت</th>
                    <th>مبلغ (به ریال)</th>
                    <th>وضعیت پرداخت</th>
                </tr>
               </thead>
                <tbody id="tableBody">
                </tbody>
            </table>
        </div>

    </div>

</div>

<script src="<c:url value="/js/jquery-ui.min.js"/>" type="text/javascript"></script>
<script>

    $('#searchPaymentId').on("click", function () {
        searchPaymentId($('#paymentId').val());
    });

    function searchPaymentId(paymentId) {
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
                putResultInTable(data.paymentInfos);
            },
            error: function (xhr, textStatus, errorThrown) {
            }
        });

    }

    function putResultInTable(data) {
        $("#paymentsTable tbody tr").remove();

        for (var i = 0 ; i < data.length ; i++) {
            $('#paymentsTable tbody').append (
                    '<tr>' +
                        '<td>' + data[i].paymentId + '</td>' +
                        '<td>' + data[i].amount + '</td>' +
                        '<td>' + l10n.paymentStatus[data[i].paymentStatus] + '</td>' +
                    +'</tr>')

        }

    }

    $(document).ready(function () {
        $('#paymentId').focus();
        searchPaymentId()
    });
</script>
</body>
</html>