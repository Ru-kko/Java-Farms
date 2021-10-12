$(document).ready(() =>{
    buld(); 
})
function buld(){
    $('#categoriesRows').empty();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/Category',
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
    console.log(options);
    $('#idInput').css('display','block');

    $('#categoriesTable').css('display','none');
    $('#inputContainer').css('display','block');

    console.log("a");
}