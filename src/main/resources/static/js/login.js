function myFunction() {
    let data = {
        'username': $("#username").val(), 
        'password': $("#password").val()
    };
    
    postJson(
        "/login/user", 
        data, 
        response => $("#paragraph").text(response.result),
        function(xhr, status, error) {
            $("#paragraph").text(status);
            console.log(error);
        }
    );
}

function postJson(url, data, successFn, errorFn) {
    $.ajax({
        url: url,
        type: "POST",
        contentType:'application/json',
        data: JSON.stringify(data),
        dataType:'JSON',
        success: successFn,
        error: errorFn
    });
}

$(document).ready(function() {
    console.log("READY");
    $("#jsButton").click(myFunction);
});
