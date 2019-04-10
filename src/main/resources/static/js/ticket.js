$(document).on('click','#ticket_kind',function(){
    // setPicker();
    // setInitialDate();
    let ticket_kind = document.getElementById('ticket_kind').value;
    let ticket_priority = document.getElementById('ticket_priority').value;
    let ticket_date = document.getElementById('date').value;
    // let ticket_priority_sel = document.getElementById('ticket_priority').value.selected;
    console.log(ticket_kind+", "+typeof(ticket_kind)+", "+ticket_priority);
    console.log(ticket_date);
    // console.log(ticket_priority);
});

/*$(document).on('click','#ticket_kind',function(){
    let list = $(ticketAttr);
    $.each(list, function( index, value ) {
        // alert( index + ": " + value.email );
        alert(ticketAttr);
    });
    // var valuePassedFromJSP = $("body").attr("data-customvalueone");
});*/
