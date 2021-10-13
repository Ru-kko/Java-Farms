/**
 *  @var 0 = Table
 *  @var 1 = Adding
 *  @var 2 = Editing
 */
const localState = 0;
const domain = document.domain;

$(document).ready(() =>{
    console.log(domain);
    buld(); 
})
function buld(){
    $('#categoriesRows').empty();
    $.ajax({
        type: 'GET',
        url:  domain + '/api/Category' || 'http://localhost:8080/api/Category',
        success: (res) =>{
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
    const parent = $(this).parent().parent();
    var options = [
        parent.find('th.id').text(),
        parent.find('th.name').text(),
        parent.find('th.description').text()
    ];
    var inputs = [
        $('#inputs div #idInput'),
        $('#inputs div #nameInput'),
        $('#inputs div #descriptionInput')
    ];

    for (let i = 0; i < options.length; i++) {
        inputs[i].val(options[i]);
        console.log(inputs[i]);
    };

    inputs[0].css('display','flex');

    $('#addCategory').css('display','none');



    $('#categoriesTable').css('display','none');
    $('#inputContainer').css('display','block');

}