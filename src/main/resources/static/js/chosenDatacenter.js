var fisicHostId;

// Arma el árbol de credenciales dinamicamente al clickear el botón de credenciales dentro de un FisicHost
$(".credentialsButton").click(function(){

    fisicHostId = $(this).data('fisic-host-id');
    $.get( "/fisicHost/" + fisicHostId + "/credentials", data => {

        $('#credentialsTable').empty();


//                    var tab = document.createElement('tr');
//                    tab.className = "row";
//                    var tab1 = document.createElement('th');
//                    tab1.className = "modal-user";
//                    tab1.textContent = "USUARIO";
//                    tab.append(tab1);
//                    var tab2 = document.createElement('th');
//                    tab2.className = "modal-pass";
//                    tab1.textContent = "PASSWORD";
//                    tab.append(tab2);
//                    var tab3 = document.createElement('th');
//                    tab3.className = "modal-notes";
//                    tab1.textContent = "NOTAS";
//                    tab.append(tab3);
//                    $("#credentialsTable").append(tab);

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

            var editButton = document.createElement('button');
            editButton.id =`edi-${fisicHost["id"]}`;
            editButton.className ="glyphicon glyphicon-edit btn btn-warning btn-sm";
            editButton.textContent = "   EDITAR"
            new_row.append(editButton);

            var deleteButton = document.createElement('button');
            deleteButton.id = `del-${fisicHost["id"]}`;
            deleteButton.className ="glyphicon glyphicon-remove btn btn-danger btn-sm";
            deleteButton.textContent = "   ELIMINAR"
            new_row.append(deleteButton);

            $("#credentialsTable").append(new_row);
        }

        $('#credentialsModal').modal('show');

    }).fail(function(xhr, status, error) {
        alert('No se pudieron cargar las credenciales.');
    });
});


// Borrar un FisicHost
$('.btnDeleteFh').click(function() {
    var conf = confirm("¿Borrar el Host Fisico?");
    if (conf == true) {
        fisicHostId = $(this).data('fisic-host-id');
            $.post( "/hostFisicos/" + fisicHostId + "/delete", data => {
                location.reload();
            });
    }
});

// Función Ajax
function doAjax(e){

      var credentialId = e.target.id;

      var newUser = $('#newUser').val();
      var newPass = $('#newPass').val();
      var newNotes = $('#newNotes').val();

      var sendInfo = {
                         User: newUser,
                         Password: newPass,
                         Notes: newNotes
                     };

      var url = "/fisicHost/" + credentialId + "/credentials/update";

      $.ajax({
             type: "POST",
             url: url,
             data: sendInfo,
             success: function(data)
                      {
                         alert('Credencial actualizada correctamente');
                         location.reload();
                      },
             error: function ()
                      {
                         alert('ERROR al actualizar la credencial');
                         location.reload();
                	  }
      });
}

// Editar credencial de un FisicHost
$("#credentialsTable").on('click',"button[id^='edi-']",  (e) => {

    $('#credentialsModal').modal('hide');
    $('#editModal').modal('show');
    $('#newUser').val('');
    $('#newPass').val('');
    $('#newNotes').val('');
    $('#btn-confirm').on('click', () => {
          doAjax(e);
    });
});


// Borra la credencial deseada del FisicHost
$("#credentialsTable").on('click',"button[id^='del-']",  (e) => {
    var credentialId = e.target.id;
        console.log('credId' + credentialId);
        $.post( "/fisicHost/" + credentialId + "/credentials/delete", data => {
            location.reload();
    });
});


$('#credentialsModal').bind('hide', function () {
   $('#credentialsModal tr.fisichost').remove();
});


// Agregar una credencial
$('.btn-addCred').on('click', () => {
    $('#credentialsModal').modal('hide');
    $('#newUser2').val('');
    $('#newPass2').val('');
    $('#newNotes2').val('');
    $('#addCredModal').modal('show');

$('#btn-saveCred').on('click', () => {


    var newUser = $('#newUser2').val();
    var newPass = $('#newPass2').val();
    var newNotes = $('#newNotes2').val();

    var sendInfo = {
                     User: newUser,
                     Password: newPass,
                     Notes: newNotes
                   };

    console.log(sendInfo);
    var url = '/fisicHost/' + fisicHostId + '/credentials/add';

    $.ajax({
                 type: "POST",
                 url: url,
                 data: sendInfo,
                 success: function(data)
                          {
                             alert('Credencial agregada correctamente');
                             location.reload();
                          },
                 error: function ()
                          {
                             alert('ERROR al agregar la credencial');
                             location.reload();
                    	  }
          });
    });
});