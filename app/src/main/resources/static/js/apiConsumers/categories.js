/**
 *  @var 0 = Table
 *  @var 1 = Adding
 *  @var 2 = Editing
 */
const localState = 0;
const domain = document.domain == 'localhost' ? 'http://localhost:8080' : document.domain;

$(document).ready(() => {
    console.log(domain);
    buld();
})
function buld() {
    $('#categoriesRows').empty();
    $.ajax({
        type: 'GET',
        url: domain + '/api/Category',
        success: (res) => {
            res.forEach(i => {
                const row = '<tr class="tableRow">' +
                    `<th scope="row" class="id">${i.id}</th>` +
                    `<th scope="row" class="name">${i.name}</th>` +
                    `<th scope="row" class="description">${i.description}</th>` +
                    '<td class="edit"><a class="btn btn-secondary btn-sm btn-edit">edit</a></td></tr>';
                $('#categoriesRows').append(row)
            });
            $('td a.btn-edit').click(edit);
        }
    })
}
function edit() {
    var used = false;
    const parent = $(this).parent().parent();
    var options = [
        parent.find('th.id'),
        parent.find('th.name'),
        parent.find('th.description')
    ];
    var inputs = [
        $('#inputs div #idInput'),
        $('#inputs div #nameInput'),
        $('#inputs div #descriptionInput')
    ];

    for (let i = 0; i < options.length; i++) {
        inputs[i].val(options[i].text());
    };

    inputs[0].css('display', 'flex');

    $('#addCategory').css('display', 'none');

    $('#categoriesTable').css('display', 'none');
    $('#inputContainer').css('display', 'block');

    $('#uploadCategory').click(() => {
        if(used) return;
        $.ajax({
            type: 'PUT',
            url: domain + '/api/Category',
            contentType: 'application/json',
            data: JSON.stringify({
                'id': parseInt(inputs[0].val()),
                'name': inputs[1].val(),
                'description': inputs[2].val()
            })
        })      
            .done(() => {
                for (let i = 0; i < options.length; i++) {
                    options[i].text(inputs[i].val());
                };
            })
            .fail((e) => {
                alert('An unspected error');
                console.log(e);
            })
            .always(() => {
                $('#categoriesTable').css('display', 'block');
                $('#inputContainer').css('display', 'none');
            })

    })
}