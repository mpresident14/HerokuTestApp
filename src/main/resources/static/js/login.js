function myFunction() {
    let data = {'username':'paul', 'password':'12345'};
    $.ajax({
        url: "/login/user",
        type: "POST",
        contentType:'application/json',
        data: JSON.stringify(data),
        dataType:'JSON',
        success: function(response) {
            $("#paragraph").text(response.result);
        },
        error: function(xhr, status, error) {
            console.log(error);
            $("#paragraph").text(status);
        },
    });
}

$(document).ready(function() {
    console.log("READY");
    $("#jsButton").click(myFunction);
});
