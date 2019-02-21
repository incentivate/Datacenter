
$(".credentialsButton").click(function(){

    var fisicHostId = $(this).data('fisic-host-id');
    $.get( "/fisicHost/" + fisicHostId + "/credentials", data => {
        console.log(data);

        $('#credentialsTable').empty();

        for (i = 0; i < data.length; ++i) {
            var fisicHost = data[i];

            var new_row = document.createElement('tr');
            new_row.className = "row fisichost";

            var userCol = document.createElement('td');
            userCol.textContent = fisicHost["user"];
            new_row.append(userCol);

            var passwordCol = document.createElement('td');
            passwordCol.textContent = fisicHost["password"];
            new_row.append(passwordCol);

            var notesCol = document.createElement('td');
            notesCol.textContent = fisicHost["notes"];
            new_row.append(notesCol);

            $("#credentialsTable").append(new_row);
        }

        $('#credentialsModal').modal('show');

    }).fail(function(xhr, status, error) {
        console.error(error);
        alert('No se pudieron cargar las credenciales.');
    });
});

$('#credentialsModal').bind('hide', function () {
   $('#credentialsModal tr.fisichost').remove();
});