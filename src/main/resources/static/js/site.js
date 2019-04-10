function setPicker() {

    $("#datepicker").datepicker(
        {});
};

function setInitialDate() {
    var locationString = window.location;

    var locationString = locationString + "";
    var pos1 = locationString.indexOf("startdate");
    var loading = document.getElementById("filterBtn");
    if (pos1 != -1) {
        var pos2 = locationString.indexOf("enddate");
        startDateValue = locationString.substring(pos1 + 10, pos1 + 20);
        endDateValue = locationString.substring(pos2 + 8, pos2 + 18);
        // alert(startDateValue+"/"+endDateValue);

        $('#startDate').datepicker('setDate', startDateValue);
        $('#endDate').datepicker('setDate', endDateValue);
        loading.style.visibility = "visible";
        // loading.style.display="display";
    } else {
        $('#startDate').datepicker('setDate', null);//startDateValue);
        $('#endDate').datepicker('setDate', null);
        loading.style.visibility = "hidden";
        // loading.style.display="none";
    }
};

$(document).ready(function () {
    // setPicker();
    setInitialDate();
});

function reloadPageForDateSelection() {
    startDateValue = $("#startDate").data('datepicker').getFormattedDate(dateFormatString);
    endDateValue = $("#endDate").data('datepicker').getFormattedDate(dateFormatString);

    var startDate = document.getElementById('startDate').value;
    var endDate = document.getElementById('endDate').value;

    var redirectLink = window.location.protocol + "//" + window.location.host + window.location.pathname +
        '?startdate=' + startDate + '&enddate=' + endDate;
    // console.log('Redirecting to: ' + redirectLink);
    if (startDate != '' && endDate != '') {
        window.location.href = redirectLink;
    }else{
        alert('No values for filter');
    }
};


function reloadPageForResetFilter() {
    startDateValue = "0";
    endDateValue = "0";
    var redirectLink = window.location.protocol + "//" + window.location.host + window.location.pathname;
    window.location.href = redirectLink;
}

var startDateValue;
var endDateValue;
let dateFormatString = 'yyyy-mm-dd';