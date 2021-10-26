var inputs = [
    $('#inputs div #idInput'),
    $('#textInput')
];

$(document).ready(() => {
    var used = false;

    $.ajax({
        type: 'GET',
        url: '/api/Client',
        success: (res) => {
            for (let i = 0; i < res.length; i++) {
                let clientRow;
                if(i == 0){
                    clientRow = `<option value="${res[i].idClient}" selected>${res[i].name}</option>`;
                }else{
                    clientRow = `<option value="${res[i].idClient}">${res[i].name}</option>`;
                }
                $('#clientSelect').append(clientRow);
            }
        }
    });
    $.ajax({
        type: 'GET',
        url: '/api/Farm',
        success: (res) => {
            for (let i = 0; i < res.length; i++) {
                let clientRow;
                if(i == 0){
                    clientRow = `<option value="${res[i].id}" selected>${res[i].name}</option>`;
                }else{
                    clientRow = `<option value="${res[i].id}">${res[i].name}</option>`;
                }
                $('#farmSelect').append(clientRow);
            }
        }
    });

    $('#sumbitMessage').click(add);

    $('#removeMessage').click(() => {
        if (used) return;
        used = true;
        $.ajax({
            type: 'DELETE',
            url: '/api/Message',
            contentType: 'application/json',
            data: JSON.stringify({
                'idMessage': parseInt(inputs[0].val())
            })
        })
            .fail(() => {
                alert('An unspected error');
            })
            .always(() => {
                used = false;
                build();
                $('#messagesTable').css('display', 'block');
                $('#inputContainer').css('display', 'none');
            })
    })

    $('#uploadMessage').click(() => {
        if (used) return;

        used = true;
        $.ajax({
            type: 'PUT',
            url: '/api/Message',
            contentType: 'application/json',
            data: JSON.stringify({
                'idMessage': parseInt(inputs[0].val()),
                'messageText': inputs[1].val(),
                'client':{
                    'idClient':parseInt($('#clientSelect').val())
                },
                'farm': {
                    'id':parseInt($('#farmSelect').val())
                }
            })
        })
            .fail(() => {
                alert('An unspected error');
            })
            .always(() => {
                used = false;
                build();
                $('#messagesTable').css('display', 'block');
                $('#inputContainer').css('display', 'none');
            })
    });
    $('#addMessage').click(() => {
        if (used) return;
        used = true;
        $.ajax({
            type: 'POST',
            url: '/api/Message',
            contentType: 'application/json',
            data: JSON.stringify({
                'messageText': inputs[1].val(),
                'client':{
                    'idClient':parseInt($('#clientSelect').val())
                },
                'farm': {
                    'id':parseInt($('#farmSelect').val())
                }
            })
        })
            .fail(() => {
                alert('An unspected error');
            })
            .always(() => {
                used = false;
                build();
                $('#messagesTable').css('display', 'block');
                $('#inputContainer').css('display', 'none');
            })
    });
    build();
})
function build() {
    $('#messagesRows').empty();

    $.ajax({
        type: 'GET',
        url: '/api/Message',
        success: (res) => {
            res.forEach(i => {
                const row = '<tr class="tableRow">' + 
                    `<th scope="row" class="id">${i.idMessage}</th>` +
                    `<th scope="row" class="text">${i.messageText}</th>` +
                    `<th scope="row" class="client">${i.client.name}</th>` +
                    `<th scope="row" class="farm">${i.farm.name}</th>` +
                    '<td class="edit"><a class="btn btn-secondary btn-sm btn-edit">edit</a></td></tr>';
                $('#messagesRows').append(row);
            });
            $('td a.btn-edit').click(edit);
        }
    });
}
function add() {
    $('#idInputG').css('display', 'none');

    inputs.forEach(i => {
        i.val('');
    });

    $('#addMessage').css('display', 'block');
    $('#removeMessage').css('display', 'none');
    $('#uploadMessage').css('display', 'none');

    $('#messagesTable').css('display', 'none');
    $('#inputContainer').css('display', 'block');
}
function edit() {
    var parent = $(this).parent().parent();
    var options = [
        parent.find('th.id'),
        parent.find('th.text')
    ];
    for (let i = 0; i < options.length; i++) {
        inputs[i].val(options[i].text());
    };

    inputs[0].css('display', 'flex');

    $('#addMessage').css('display', 'none');
    $('#removeMessage').css('display', 'block');
    $('#uploadMessage').css('display', 'block');

    $('#messagesTable').css('display', 'none');
    $('#inputContainer').css('display', 'block');
}